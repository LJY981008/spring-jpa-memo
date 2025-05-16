package com.example.springjpamemo.Controller;

import com.example.springjpamemo.Service.MemberService;
import com.example.springjpamemo.dto.MemberResponseDto;
import com.example.springjpamemo.dto.SignupRequestDto;
import com.example.springjpamemo.dto.SignupResponseDto;
import com.example.springjpamemo.dto.UpdatePasswordRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.status(HttpStatus.CREATED).body(signup);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findMemberById(@PathVariable Long id) {
        MemberResponseDto result = memberService.findMemberById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestBody UpdatePasswordRequestDto requestDto
    ){
        memberService.updatePassword(id, requestDto.getOldPassword(), requestDto.getNewPassword());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
