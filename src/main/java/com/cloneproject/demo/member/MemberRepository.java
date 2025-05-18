package com.cloneproject.demo.member;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA 기본 제공 메소드
 *
 * 1. findAll() 메소드
 * - Member 테이블에서 레코드 전체 목록을 조회
 * - List<Member> 객체가 리턴
 *
 * 2. findById(id)
 * - Member 테이블에서 기본키 필드 값이 id인 레코드를 조회
 * - Optional<Member> 타입의 객체가 리턴
 * - 이 객체의 get 메서드를 호출하면 Member 객체가 리턴 예) Member m = memberRepository.findById(id).get();
 *
 * 3. save(member)
 * - Member 객체를 Member 테이블에 저장
 *
 * 4. saveAll(memberList)
 * - Member 객체 목록을 Member 테이블에 저장
 *
 * 5. delete(member)
 * - Member 객체의 id(기본키) 속성값과 일치하는 레코드를 삭제
 *
 * 6. deleteAll(memberList)
 * - Member 객체 목록을 테이블에서 삭제
 *
 * 7. count()
 * - Member 테이블의 전체 레코드 수를 리턴
 *
 * 8. exists(id)
 * - Member 테이블에서 id에 해당하는 레코드가 있는지 true/false를 리턴
 *
 * 9. flush()
 * - 지금까지 Member 테이블에 대한 데이터 변경 작업들이 디스크에 모두 기록
 *
 *
 * 만약 다른 컬럼을 통해 조회, 수정, 삭제를 하고 싶으면 해당 컬럼명을 포함해서 메서드를 정의 하면 됨.
 * ex) Optional<Member> findByEmail(String email);
 *
 * 참고: https://priming.tistory.com/114
 */

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);
    Optional<Member> findByEmail(String email);
    List<Member> findByNameAndEmail(String name, String email);
} 