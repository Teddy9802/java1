package com.teddy.sbb.repository;

import com.teddy.sbb.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
// null 을 Optional 로 감싸서 반환해준다.
