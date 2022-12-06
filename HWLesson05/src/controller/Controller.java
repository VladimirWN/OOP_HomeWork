package controller;

import config.Config;
import model.data.Contact;
import model.data.Phone;
import model.data.PhoneType;
import model.data.User;
import model.service.*;
import util.WriterReaderCSVImpl;
import util.WriterReaderTXTImpl;
import view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private View view;
    private ContactService<User> contactService = new ContactServiceImpl();
    private UserService userService = new UserServiceImpl();

    public Controller(View view) {
        this.view = view;
    }

    public void start() {
        view.set("Выберите файл для загрузки базы: 1 - phonebook.csv, 2 - phonebook.txt");
        String key = view.get();
        PhoneBook phoneBook = new PhoneBookImpl();
        if (key.equals("1")) {
            Config.path = "phonebook.csv";
            phoneBook = new PhoneBookImpl(new WriterReaderCSVImpl());
        } else if (key.equals("2")) {
            Config.path = "phonebook.txt";
            phoneBook = new PhoneBookImpl(new WriterReaderTXTImpl());
        } else {
            view.set("Введены некорректные данные. Остановка выполнения программы.");
            System.exit(0);
        }
        phoneBook.loadContacts(Config.path);

        while (true) {
            view.set("1 - текущие контакты; 2 - поиск контакта; 3 - добавление контакта; " +
                    "4 - удаление контакта; 5 - экспорт данных");
            key = view.get();
            switch (key) {
                case "1" -> {
                    String s = phoneBook.printAllContacts();
                    if (s.isBlank()) {
                        view.set("Книга пуста.");
                    } else {
                        view.set(s);
                    }
                }
                case "2" -> searchContact(phoneBook);
                case "3" -> addContact(phoneBook);
                case "4" -> removeContact(phoneBook);
                case "5" -> exportData(phoneBook);
                default -> view.set("Такого пункта меню нет.");
            }
        }
    }

    public void searchContact(PhoneBook phoneBook) {
        view.set("Введите имя или фамилию:");
        String search = view.get();
        List<Contact> result = phoneBook.searchContact(search);
        if (result.isEmpty()) {
            view.set("Контактов не обнаружено.");
        } else {
            view.set("Результат поиска: " + result);
        }
    }

    public void addContact(PhoneBook phoneBook) {
        List<String> checkList = new ArrayList<>(Arrays.asList("Имя:", "Фамилия:", "Номер:", "1 - домашний, 2 - рабочий, 3(и др.) - другое:"));
        int i = 0;
        String[] temp = {"0", "0"};
        while (!checkList.get(i).equals("Номер:")) {
            while (!userService.isCorrect(temp[i])) {
                view.set(checkList.get(i));
                temp[i] = view.get();
                if (!userService.isCorrect(temp[i])) {
                    view.set("Могут быть только латинские буквы в поле " + checkList.get(i).subSequence(0, checkList.get(i).length() - 1));
                }
            }
            i++;
        }
        List<Phone> phones = new ArrayList<>();
        Contact contact = contactService.createContact(new User(temp[0], temp[1]), phones);
        if (phoneBook.isExist(contact)) {
            view.set("Такой пользователь уже есть в книге, добавление невозможно.");
        } else {
            int round = 0;
            do {
                Phone phone = new Phone();
                view.set(checkList.get(i++));
                phone.setNumber(view.get());
                view.set(checkList.get(i));
                switch (view.get()) {
                    case "1" -> phone.setPhoneType(PhoneType.HOME);
                    case "2" -> phone.setPhoneType(PhoneType.WORK);
                    default -> phone.setPhoneType(PhoneType.OTHER);
                }
                phones.add(phone);
                view.set("Добавить еще номер? 1 - да, любая клавиша - нет");
                if ("1".equals(view.get())) {
                    round = 1;
                } else {
                    round = 0;
                }
                i = 2;
            } while (round == 1);
            contact.setPhones(phones);
            phoneBook.addContact(contact);
        }
    }

    public void removeContact(PhoneBook phoneBook) {
        view.set(phoneBook.printAllContacts());
        view.set("Введите номер контакта для удаления, для отмены - \"exit\"");
        String key = view.get();
        if ("exit".equals(key)) {
            view.set("Отмена удаления.");
        } else {
            if (!key.matches("\\d+") || phoneBook.getContactList().size() <= Integer.parseInt(key)) {
                view.set("Введены некорректные данные. Отмена удаления.");
            } else {
                phoneBook.removeContact(Integer.parseInt(key));
                view.set("Запись удалена.");
            }
        }
    }

    public void exportData(PhoneBook phoneBook) {
        view.set("Введите название нового файла с форматом .csv или .txt:");
        String path = view.get();
        phoneBook.export(path);
    }
}
