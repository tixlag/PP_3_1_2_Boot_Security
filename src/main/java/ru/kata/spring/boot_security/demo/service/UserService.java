package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void addWithHiddenRoles(User user);

    User get(Long id);

    List<User> getAll();

    void edit(User user);

    void edit(Long id, String name, String lastName, byte age,
              String username, String password, List<Long> roles);

    void delete(Long id);

    void firstRun();
}
