package com.example.springjpamemo.Service;

import com.example.springjpamemo.Repository.MemberRepository;
import com.example.springjpamemo.dto.MemberResponseDto;
import com.example.springjpamemo.dto.SignupResponseDto;
import com.example.springjpamemo.entity.Member;
import com.example.springjpamemo.validator.FindValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final FindValidator findValidator;

    public MemberService(MemberRepository memberRepository, FindValidator findValidator) {
        this.memberRepository = memberRepository;
        this.findValidator = findValidator;
    }

    public SignupResponseDto signup(String userName, String password, Integer age){
        Member requestMember = new Member(userName, password, age);
        Member result = memberRepository.save(requestMember);
        return new SignupResponseDto(result.getId(), result.getUserName(), result.getAge());
    }

    @Transactional(readOnly = true)
    public MemberResponseDto findMemberById(Long id){
        Optional<Member> result = memberRepository.findById(id);
        Member findMember = findValidator.validFindById(result, id.toString());

        return new MemberResponseDto(findMember.getUserName(), findMember.getAge());
    }

    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword){
        Optional<Member> result = memberRepository.findById(id);
        Member findMember = findValidator.validFindById(result, id.toString());

        if(!findMember.getPassword().equals(oldPassword)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "password is incorrect");
        }
        findMember.updatePassword(newPassword);
    }


}
