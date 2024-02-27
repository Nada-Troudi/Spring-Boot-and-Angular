package com.gestionbacs.backend.services;

import com.gestionbacs.backend.dto.SignupRequest;

import com.gestionbacs.backend.entities.User;
import com.gestionbacs.backend.repository.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean createUser(SignupRequest signupRequest) {
        //Check if user already exist
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return false;
        }

        User user = new User();
        BeanUtils.copyProperties(signupRequest, user);

        //Hash the password before saving
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hashPassword);
        userRepository.save(user);
        return true;
    }
}
