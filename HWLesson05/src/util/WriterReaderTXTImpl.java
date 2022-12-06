package util;

import model.data.Contact;
import model.data.Phone;
import model.data.PhoneType;
import model.data.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriterReaderTXTImpl implements WriterReader {
    @Override
    public List<Contact> readDB(String path) {
        List<Contact> contacts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()) {
                Contact contact = new Contact();
                contact.setUser(new User(br.readLine(), br.readLine()));
                List<Phone> phones = new ArrayList<>();
                String nextLine = br.readLine();
                while (nextLine != null && !nextLine.isBlank()) {
                    Phone phone = new Phone();
                    phone.setNumber(nextLine);
                    switch (br.readLine()) {
                        case "1" -> phone.setPhoneType(PhoneType.HOME);
                        case "2" -> phone.setPhoneType(PhoneType.WORK);
                        default -> phone.setPhoneType(PhoneType.OTHER);
                    }
                    phones.add(phone);
                    nextLine = br.readLine();
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
            for (Contact contact :
                    contacts) {
                pw.write(contact.getUser().getFirstName());
                pw.write("\n");
                pw.write(contact.getUser().getLastName());
                pw.write("\n");
                for (Phone phone :
                        contact.getPhones()) {
                    pw.write(phone.getNumber());
                    pw.write("\n");
                    switch (phone.getPhoneType()) {
                        case HOME -> pw.write("1");
                        case WORK -> pw.write("2");
                        case OTHER -> pw.write("3");
                    }
                    pw.write("\n");
                }
                pw.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
