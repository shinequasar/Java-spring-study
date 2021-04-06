package hello.hellospring.repository;

import hello.hellospring.domain.Members;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Members member = new Members();
        member.setName("spring");

        repository.save(member);

        Members result = repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Members member1 = new Members();
        member1.setName("spring1");
        repository.save(member1);

        Members member2 = new Members(); //shift + F6 하면 여러변수명 한번에 바꿀 수 있음.
        member2.setName("spring1");
        repository.save(member2);

        Members result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Members member1 = new Members();
        member1.setName("string1");
        repository.save(member1);

        Members member2 = new Members();
        member2.setName("string2");
        repository.save(member2);

        List<Members> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}