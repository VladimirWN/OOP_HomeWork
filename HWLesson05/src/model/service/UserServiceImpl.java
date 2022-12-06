package model.service;

import model.data.User;


public class UserServiceImpl implements UserService {

    @Override
    public boolean isCorrect(String s) {
        return !s.isBlank() && s.matches("^[a-zA-Z]*$");
    }

    @Override
    public User createUser(String firstName, String lastName) {
        return new User(firstName, lastName);
    }
}
