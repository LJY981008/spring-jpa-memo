package com.example.springjpamemo.dto;

import lombok.Getter;

@Getter
public class CreateBoardRequestDto {
    private final String title;
    private final String contents;
    private final String userName;

    public CreateBoardRequestDto(String title, String contents, String userName) {
        this.title = title;
        this.contents = contents;
        this.userName = userName;
    }
}
