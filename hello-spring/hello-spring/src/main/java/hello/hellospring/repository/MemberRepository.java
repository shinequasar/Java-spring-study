package hello.hellospring.repository;

import hello.hellospring.domain.Members;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository {
    Members save(Members member);
    Optional<Members> findById(Long id);
    Optional<Members> findByName(String name);
    List<Members> findAll();
}
