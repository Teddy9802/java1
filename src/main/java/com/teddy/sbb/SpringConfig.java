package com.teddy.sbb;

import com.teddy.sbb.repository.JdbcTemplateMemberRepository;
import com.teddy.sbb.repository.MemberRepository;
import com.teddy.sbb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //  return new MemoryMemberRepository();
        //  return new JdbcMemberRepository(dataSource);
        return  new JdbcTemplateMemberRepository(dataSource);
    }
}
