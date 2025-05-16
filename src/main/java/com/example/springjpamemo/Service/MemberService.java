package com.example.springjpamemo.Service;

import com.example.springjpamemo.Repository.MemberRepository;
import com.example.springjpamemo.dto.MemberResponseDto;
import com.example.springjpamemo.dto.SignupResponseDto;
import com.example.springjpamemo.entity.Member;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public SignupResponseDto signup(String userName, String password, Integer age){
        Member requestMember = new Member(userName, password, age);
        Member result = memberRepository.save(requestMember);
        return new SignupResponseDto(result.getId(), result.getUserName(), result.getAge());
    }

    public MemberResponseDto findMemberById(Long id){
        Optional<Member> result = memberRepository.findById(id);
        if(result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "does not exist id : " + id);
        }
        Member findMember = result.get();
        return new MemberResponseDto(findMember.getUserName(), findMember.getAge());
    }


}
