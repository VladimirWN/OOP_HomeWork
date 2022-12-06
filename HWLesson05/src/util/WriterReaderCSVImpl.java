package util;

import model.data.Contact;
import model.data.Phone;
import model.data.PhoneType;
import model.data.User;
import model.service.PhoneBook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WriterReaderCSVImpl implements WriterReader {
    @Override
    public List<Contact> readDB(String path) {
        List<Contact> contacts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()) {
                Iterator<String> s = Arrays.stream(br.readLine().split(",")).iterator();
                Contact contact = new Contact();
                contact.setUser(new User(s.next(), s.next()));
                List<Phone> phones = new ArrayList<>();
                while (s.hasNext()) {
                    Phone phone = new Phone();
                    phone.setNumber(s.next());
                    switch (s.next()) {
                        case "1" -> phone.setPhoneType(PhoneType.HOME);
                        case "2" -> phone.setPhoneType(PhoneType.WORK);
                        default -> phone.setPhoneType(PhoneType.OTHER);
                    }
                    phones.add(phone);
                }
                contact.setPhones(phones);
                contacts.add(contact);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }

    @Override
    public void updateDB(String path, List<Contact> contacts) {
        File file = new File(path);
        try (PrintWriter pw = new PrintWriter(file)) {
            StringBuilder sb = new StringBuilder();
            for (Contact contact :
                    contacts) {
                sb.append(contact.getUser().getFirstName()).append(',')
                        .append(contact.getUser().getLastName()).append(',');
                for (Phone phone :
                        contact.getPhones()) {
                    sb.append(phone.getNumber()).append(",");
                    switch (phone.getPhoneType()) {
                        case HOME -> sb.append("1");
                        case WORK -> sb.append("2");
                        case OTHER -> sb.append("3");
                    }
                    sb.append(",");
                }
                sb.append("\n");
            }
            pw.write(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
