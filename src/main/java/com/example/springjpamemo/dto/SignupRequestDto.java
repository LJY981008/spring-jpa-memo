package com.example.springjpamemo.dto;

import lombok.Getter;

@Getter
public class SignupRequestDto {
    private final String userName;
    private final String password;
    private final Integer age;

    public SignupRequestDto(String userName, String password, Integer age) {
        this.userName = userName;
        this.password = password;
        this.age = age;
    }
}
