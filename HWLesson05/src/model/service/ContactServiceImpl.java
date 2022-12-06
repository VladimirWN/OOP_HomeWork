package model.service;

import model.data.Contact;
import model.data.Phone;
import model.data.User;

import java.util.List;

public class ContactServiceImpl implements ContactService<User> {
    @Override
    public Contact createContact(User user, List<Phone> phoneList) {
        return new Contact(user, phoneList);
    }

    @Override
    public boolean addNumber(Contact contact, Phone phone) {
        return contact.getPhones().add(phone);
    }

    @Override
    public void editUser(Contact contact, String first, String last) {
        contact.getUser().setFirstName(first);
        contact.getUser().setLastName(last);
    }
}
