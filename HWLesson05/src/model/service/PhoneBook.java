package model.service;

import model.data.Contact;

import java.util.List;

public interface PhoneBook {
    public void loadContacts(String path);


    public String printAllContacts();

    public List<Contact> searchContact(String string);

    public void addContact(Contact contact);

    public void removeContact(int index);

    public boolean isExist(Contact contact);

    public List<Contact> getContactList();

    public void export(String path);
}
