package com.cloneproject.demo.member.repository;

import com.cloneproject.demo.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberSpringDataJpaRepository /*extends JpaRepository<Member, Long>, MemberRepository */{
    List<Member> findByName(String name);
    Optional<Member> findByEmail(String email);
    List<Member> findByNameAndEmail(String name, String email);

    @Query(value = "SELECT COUNT(*) FROM member_wishlist WHERE member_id = :id", nativeQuery = true)
    int countWishlist(@Param("id") Long id);




} 
