package com.srivasavi.service;

import com.srivasavi.model.User;
import com.srivasavi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired private UserRepository repo;

    public User register(User user) {
        return repo.save(user);
    }

    public boolean validate(String username, String password) {
        Optional<User> u = repo.findByUsername(username);
        return u.isPresent() && u.get().getPassword().equals(password);
    }

    public boolean updatePassword(String username, String newPassword) {
        Optional<User> user = repo.findByUsername(username);
        if (user.isPresent()) {
            user.get().setPassword(newPassword);
            repo.save(user.get());
            return true;
        }
        return false;
    }

    public boolean updatePasswordByEmail(String email, String newPassword) {
        Optional<User> user = repo.findByEmail(email);
        if (user.isPresent()) {
            user.get().setPassword(newPassword);
            repo.save(user.get());
            return true;
        }
        return false;
    }
    public String registerUser(User user) {
        if (repo.findByEmail(user.getEmail()).isPresent()) {
            return "Email already exists";
        }
        repo.save(user);
        return "User registered";
    }

    public boolean emailExists(String email) {
        return repo.findByEmail(email).isPresent();
    }

}
