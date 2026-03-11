package com.eylul.ecommerce.services;

import com.eylul.ecommerce.models.User;
import com.eylul.ecommerce.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void updateUser(User updatedUser) {

        User existingUser = userRepository.findById(updatedUser.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setFirstName(
                updatedUser.getFirstName() != null ? updatedUser.getFirstName() : existingUser.getFirstName()
        );

        existingUser.setLastName(
                updatedUser.getLastName() != null ? updatedUser.getLastName() : existingUser.getLastName()
        );

        existingUser.setEmail(
                updatedUser.getEmail() != null ? updatedUser.getEmail() : existingUser.getEmail()
        );



        userRepository.save(existingUser);
    }

}
