package com.gestionbacs.backend.dto;

public class SignupRequest {


    @lombok.Setter
    @lombok.Getter
    private String email;


    @lombok.Setter
    @lombok.Getter
    private String name;

    @lombok.Setter
    @lombok.Getter
    private String password;

}
