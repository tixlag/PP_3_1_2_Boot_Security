package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    EntityManager manager;


    @Override
    public void add(User user) {
        manager.persist(user);
    }

    @Override
    public User get(int id) {
//        return manager.getObject() .createQuery("from User", User.class).getSingleResult();
        return manager.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) manager.createQuery("from User").getResultList();
    }

    @Override
    public void edit(Long id, User user) {

    }

    @Override
    public void edit(Long id, String name, String lastName, byte age,
                     String username, String password, Set<Role> roles) {
        User currentUser = manager.find(User.class, id);
        currentUser.setName(name);
        currentUser.setLastName(lastName);
        currentUser.setAge(age);
        currentUser.setUsername(username);
        currentUser.setPassword(password);
        currentUser.setRoles(roles);
    }

    @Override
    public void edit(User user) {
        manager.merge(user);
    }

    @Override
    public void delete(Long id) {
        manager.remove(manager.find(User.class, id));
    }

    @Override
    public User getByName(String name) {
        TypedQuery query = manager.createQuery("from User where username=:name", User.class);
        query.setParameter("name", name);
        return (User) query.getSingleResult();
    }
}
