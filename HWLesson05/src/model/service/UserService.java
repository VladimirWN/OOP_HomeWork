package model.service;

import model.data.User;

public interface UserService {
    public boolean isCorrect(String s);

    public User createUser(String firstName, String lastName);
}
