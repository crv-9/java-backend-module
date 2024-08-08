package io.everyonecodes.w1springbeans.mysterioussecretorder.config;

import io.everyonecodes.w1springbeans.mysterioussecretorder.model.Member;
import io.everyonecodes.w1springbeans.mysterioussecretorder.repositories.MemberRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class PrepareMasterRunner {

    private Member member;

    // this will create a member(master) user if none exists at the moment of creating the app
    @Bean
    ApplicationRunner prepareMaster(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String username1 = "master1";
            if (memberRepository.existsByUsername(username1)) {
                return;
            }
                member = new Member();
                String password = "secret";
                String encryptedPassword = passwordEncoder.encode(password);
                Set<String> authorities = Set.of("ROLE_MASTER");
                member.setUsername(username1);
                member.setPassword(encryptedPassword);
                member.setAuthorities(authorities);
                memberRepository.save(member);
            };

    }



}
