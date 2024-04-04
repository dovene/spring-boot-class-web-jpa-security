package com.dev.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dev.school.model.User;
import com.dev.school.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
    private UserRepository userRepository;
    @Override
    public void register(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
