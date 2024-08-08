package io.everyonecodes.w1springbeans.mysterioussecretorder.repositories;

import io.everyonecodes.w1springbeans.mysterioussecretorder.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends MongoRepository<Member, String> {

    boolean existsByUsername(String username);
    Optional<Member> findOneByUsername(String username);


}
