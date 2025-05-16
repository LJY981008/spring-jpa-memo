package com.example.springjpamemo.Service;

import com.example.springjpamemo.Repository.MemberRepository;
import com.example.springjpamemo.dto.SignupResponseDto;
import com.example.springjpamemo.entity.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public SignupResponseDto signup(String userName, String password, Integer age){
        Member member = new Member(userName, password, age);
        Member save = memberRepository.save(member);
        return new SignupResponseDto(save.getId(), save.getUserName(), save.getAge());
    }
}
