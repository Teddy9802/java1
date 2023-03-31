package com.teddy.sbb.repository;

import com.teddy.sbb.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트하나 끝나고 AfterEach 를 실행(callback 비슷함)
    // 하나의 테스트가 끝날때 마다 저장소를 다 지운다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
//Test 코드의 관례 => 테스트하려는 클래스명 + TEST
//중복되는 이름 다 바꾸고 싶을 때 시프트 + f6
//전체 테스트는 순서가 보장이 되지 않는다.즉, 하나의 테스트가 끝나면 공용데이터들을 지워주는 역할 필요.
//테스트 코드는 (테스트주도개발(TDD)) 테스트를 먼저 하고 코드를 짜는 순서도 가능.