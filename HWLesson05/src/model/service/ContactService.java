package model.service;

import model.data.Contact;
import model.data.Phone;
import model.data.User;

import java.util.List;

public interface ContactService<T extends User> {
    public Contact createContact(T user, List<Phone> phoneList);

    public boolean addNumber(Contact contact, Phone phone);

    public void editUser(Contact contact, String first, String second);
}
