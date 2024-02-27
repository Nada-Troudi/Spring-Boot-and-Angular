package com.gestionbacs.backend.services;

import com.gestionbacs.backend.dto.SignupRequest;

public interface AuthService {
    boolean createUser(SignupRequest signupRequest);
}
