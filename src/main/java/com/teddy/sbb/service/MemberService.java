package com.teddy.sbb.service;

import com.teddy.sbb.domain.Member;
import com.teddy.sbb.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
//커맨드 + 시프트 + t = 새 테스트 생성
    private  final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복회원은 가입불가
        //커멘드 + 옵션 + v = 자동 리턴
        //컨트롤 + t = 관련 리팩터링 생성
        //ifPresent => 어떤 값이 있으면 얘가 동작함(옵셔널이기 떄문에 가능)
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
