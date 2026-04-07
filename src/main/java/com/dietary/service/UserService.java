package com.dietary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.dietary.entity.User;
import com.dietary.repository.UserRepository;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    public User register(User user) {
    	

    	    if (repo.findByEmail(user.getEmail()).isPresent()) {
    	        throw new RuntimeException("Email already exists");
    	    }

    	    user.setPassword(encoder.encode(user.getPassword()));
    	    user.setRole(user.getRole() == null ? "USER" : user.getRole());

    	    return repo.save(user);
    	}

    public Optional<User> findByEmail(String email) {
        return repo.findByEmail(email);
    }
	
}