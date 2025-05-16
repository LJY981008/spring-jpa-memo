package com.example.springjpamemo.dto;

import lombok.Getter;

@Getter
public class SignupResponseDto {
    private final Long id;
    private final String userName;
    private final int age;

    public SignupResponseDto(Long id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }
}
