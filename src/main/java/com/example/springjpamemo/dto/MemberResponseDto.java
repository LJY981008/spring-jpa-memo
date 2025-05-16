package com.example.springjpamemo.dto;

import lombok.Getter;

@Getter
public class MemberResponseDto {
    private final String userName;
    private final int age;

    public MemberResponseDto(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}
