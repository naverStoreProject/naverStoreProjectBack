package com.cloneproject.demo.member.repository;

import com.cloneproject.demo.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findById(Long id);
    Member save(Member member);
    List<Member> findAll();

    Optional<Member> findByEmail(String email);
    List<Member> findByName(String name);
    List<Member> findByNameAndEmail(String name, String email);
    int countWishlist(Long id);
}
