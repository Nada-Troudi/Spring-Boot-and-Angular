package com.gestionbacs.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    private String matricule;
    private String password;
}
