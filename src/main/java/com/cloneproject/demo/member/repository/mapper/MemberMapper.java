package com.cloneproject.demo.member.repository.mapper;

import com.cloneproject.demo.member.Member;
import com.cloneproject.demo.member.repository.MemberRepository;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper extends MemberRepository {

    Optional<Member> findById(Long id);

    Member save(Member member);

    List<Member> findAll();

    Optional<Member> findByEmail(String email);
    List<Member> findByName(String name);
    List<Member> findByNameAndEmail(String name, String email);
    int countWishlist(Long id);

}
