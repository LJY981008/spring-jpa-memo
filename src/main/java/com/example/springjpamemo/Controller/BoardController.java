package com.example.springjpamemo.Controller;

import com.example.springjpamemo.Service.BoardService;
import com.example.springjpamemo.dto.BoardAgeResponseDto;
import com.example.springjpamemo.dto.BoardResponseDto;
import com.example.springjpamemo.dto.CreateBoardRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<BoardResponseDto> createBoard(
            @RequestBody CreateBoardRequestDto requestDto
    ){
        BoardResponseDto responseDto = boardService.createBoard(requestDto.getTitle(), requestDto.getContents(), requestDto.getUserName());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> findAllBoards(){
        List<BoardResponseDto> listBoards = boardService.findAllBoards();

        return ResponseEntity.status(HttpStatus.OK).body(listBoards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardAgeResponseDto> findBoardById(@PathVariable Long id){
        BoardAgeResponseDto boardById = boardService.findBoardById(id);
        return ResponseEntity.status(HttpStatus.OK).body(boardById);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id){
        boardService.deleteBoard(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
