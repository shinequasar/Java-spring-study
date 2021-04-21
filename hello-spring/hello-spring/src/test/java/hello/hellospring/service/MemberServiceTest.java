package hello.hellospring.service;

import hello.hellospring.domain.Members;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void Signup() {
        //given(주어지는것)
        Members member = new Members();
        member.setName("hello");

        //when(언제)
        Long saveId = memberService.join(member);

        //then(검증)
        Members findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}