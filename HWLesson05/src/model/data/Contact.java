package model.data;

import java.util.List;
import java.util.Objects;

public class Contact {
    private User user;
    private List<Phone> phones;

    public Contact(User user, List<Phone> phones) {
        this.user = user;
        this.phones = phones;
    }

    public Contact() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(user, contact.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, phones) * 27;
    }

    @Override
    public String toString() {
        return String.format("Товарищ: %s\n\tСохраненные номера: %s", this.user, this.phones);
    }
}
