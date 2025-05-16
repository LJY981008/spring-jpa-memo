package com.example.springjpamemo.dto;

import lombok.Getter;

@Getter
public class BoardAgeResponseDto {
    private String title;
    private String contents;
    private int age;

    public BoardAgeResponseDto() {
    }

    public BoardAgeResponseDto(String title, String contents, int age) {
        this.title = title;
        this.contents = contents;
        this.age = age;
    }
}
