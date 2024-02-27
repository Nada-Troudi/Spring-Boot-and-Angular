package com.gestionbacs.backend.services.jwt;

import com.gestionbacs.backend.entities.User;
import com.gestionbacs.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String matricule) throws UsernameNotFoundException {
        // Write logic to fetch user from DB
        User user = userRepository.findByMatricule(matricule)
                .orElseThrow(() -> new UsernameNotFoundException("User not find with this Matricule:" + matricule));
        return new org.springframework.security.core.userdetails.User(user.getMatricule(), user.getPassword(), Collections.emptyList());

    }
}
