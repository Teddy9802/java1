package com.teddy.sbb.repository;

import com.teddy.sbb.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository
        extends JpaRepository<Member, Long>, MemberRepository {

    //JPQL select m from Member m where m.name = ? => 이런식으로 쿼리를 짜준다.
    @Override
    Optional<Member> findByName(String name);
}
