package io.everyonecodes.w1springbeans.mysterioussecretorder.logic;

import io.everyonecodes.w1springbeans.mysterioussecretorder.model.Member;
import io.everyonecodes.w1springbeans.mysterioussecretorder.repositories.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public OrderService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }


    // here i am setting and saving an encrypted password

    public Member createMember(Member member) {
        String password = member.getPassword();
        String encryptedPassword = passwordEncoder.encode(password);
        member.setPassword(encryptedPassword);
        return memberRepository.save(member);
    }

    public List<Member> getAllSavedMembers(){
        return memberRepository.findAll();
    }

    public List<Member> getAllApprentices(){
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .filter(member -> member.getAuthorities().contains("ROLE_APPRENTICE"))
                .toList();
    }

}
