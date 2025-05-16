package com.example.springjpamemo.Controller;

import com.example.springjpamemo.Service.MemberService;
import com.example.springjpamemo.dto.SignupRequestDto;
import com.example.springjpamemo.dto.SignupResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto requestDto) {
        SignupResponseDto signup = memberService.signup(requestDto.getUserName(), requestDto.getPassword(), requestDto.getAge());
        return ResponseEntity.ok(signup);
    }
}
