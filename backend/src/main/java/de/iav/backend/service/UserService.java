package de.iav.backend.service;

import de.iav.backend.exception.UserNotFoundException;

import de.iav.backend.model.User;

import de.iav.backend.repository.UserRepository;
import de.iav.backend.repository.UserRepositoryWOSec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    public final List<User> tempUsers = new ArrayList<>(Arrays.asList(
            new User("12345", "Erum",  "erum.schaukat@iav.de", "12345", "USER", new ArrayList<>()),
            new User("23456", "Houman",  "houman.mohammadi@iav.de", "23456", "USER",new ArrayList<>()),
            new User("34567", "Jaroslaw", "jaroslaw.placzek@iav.de", "34567", "USER",new ArrayList<>())
    ));
    private final UserRepositoryWOSec userRepositoryWOSec;


    public List<User> getAllUsers() {
        return userRepositoryWOSec.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepositoryWOSec.findById(id);
    }
    public void deleteUser(String id){
        userRepositoryWOSec.deleteById(id);
    }

    public User updateUser(String id, User userToUpdate) {
        userRepositoryWOSec.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        User updatedStudent = userToUpdate.withId(id);
        return userRepositoryWOSec.save(updatedStudent);
    }
    public User saveUser(User user) {
        return userRepositoryWOSec.save(user);
    }

    public List<User> setUserByRepository() {
        if (userRepositoryWOSec.findAll().size() == 0)
            return fillDataWithUsers();
        else
            return userRepositoryWOSec.findAll();
    }

    private List<User> fillDataWithUsers() {
        return userRepositoryWOSec.saveAll(tempUsers);
    }

    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(userRepositoryWOSec.findByEmail(email));
    }
}