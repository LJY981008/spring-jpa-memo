package com.example.springjpamemo.Service;

import com.example.springjpamemo.Repository.BoardRepository;
import com.example.springjpamemo.Repository.MemberRepository;
import com.example.springjpamemo.dto.BoardAgeResponseDto;
import com.example.springjpamemo.dto.BoardResponseDto;
import com.example.springjpamemo.entity.Board;
import com.example.springjpamemo.entity.Member;
import com.example.springjpamemo.validator.FindValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final FindValidator findValidator;

    public BoardService(BoardRepository boardRepository, MemberRepository memberRepository, FindValidator findValidator) {
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
        this.findValidator = findValidator;
    }

    public BoardResponseDto createBoard(String title, String contents, String userName) {
        Optional<Member> byUserName = memberRepository.findByUserName(userName);
        Member member = findValidator.validFindByUserName(byUserName, userName);
        Board board = new Board(title, contents);

        board.setMember(member);
        Board savedResult = boardRepository.save(board);

        return new BoardResponseDto(savedResult.getId(), savedResult.getTitle(), savedResult.getContents());
    }

    public List<BoardResponseDto> findAllBoards() {
        List<BoardResponseDto> boards = boardRepository.findAll().stream().map(BoardResponseDto::toDto).toList();
        return boards;
    }

    public BoardAgeResponseDto findBoardById(Long id) {
        Optional<Board> byId = boardRepository.findById(id);
        Board board = findValidator.validFindById(byId, id.toString());
        Member member = board.getMember();
        return new BoardAgeResponseDto(board.getTitle(), board.getContents(), member.getAge());
    }

    public void deleteBoard(Long id) {
        Optional<Board> byId = boardRepository.findById(id);
        Board board = findValidator.validFindById(byId, id.toString());
        boardRepository.delete(board);

    }
}
