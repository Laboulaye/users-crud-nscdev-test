package com.testprojects.NSCTest.service;

import com.testprojects.NSCTest.dao.UserRepository;
import com.testprojects.NSCTest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис-слой по работе с пользователями.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
            return checkUserExists(id);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        checkUserExists(user.getId());
        return userRepository.save(user);
    }

    public void deleteUserById(long id) {
        checkUserExists(id);
        userRepository.deleteById(id);
    }

    private User checkUserExists(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    }

}
