package com.example.springjpamemo.Controller;

import com.example.springjpamemo.Service.BoardService;
import com.example.springjpamemo.dto.CreateBoardRequestDto;
import com.example.springjpamemo.dto.CreateBoardResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<CreateBoardResponseDto> createBoard(
            @RequestBody CreateBoardRequestDto requestDto
    ){
        CreateBoardResponseDto responseDto = boardService.createBoard(requestDto.getTitle(), requestDto.getContents(), requestDto.getUserName());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
