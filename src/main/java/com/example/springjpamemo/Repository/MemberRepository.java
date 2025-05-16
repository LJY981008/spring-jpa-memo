package com.example.springjpamemo.Repository;

import com.example.springjpamemo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
