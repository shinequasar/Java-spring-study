package hello.hellospring.service;

import hello.hellospring.domain.Members;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {
    //Ctrl+Shift+T
    private final MemberRepository memberRepository;


    //DI 구조( MemberServiceTest 클래스랑 연관됨.)
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /* 회원가입 */

    public Long join(Members member){
        // 같은 이름이 있는 중복 회원 X
    //        Optional<Members> result = memberRepository.findByName(member.getName());
    //        result.ifPresent(m->{
    //            throw new IllegalStateException("이미 존재하는 회원입니다.");
    //        });
    //위의 코드를 다음과 같은 형태로 더 깔끔히 짤 수 있음. 어차피 result는 optional로 감싸진 형태니까!
            //메소드 추출하기 : Ctrl + Alt + M
        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Members member) {
        memberRepository.findByName(member.getName())
                //Optional.ifPresent()는 Optional 객체 안에 값이 있는 경우 실행할 람다를 인자로 받습니다.
                // 값이 있는 경우에 실행되고 값이 없는 경우에는 실행되지 않는 로직에 ifPresent를 활용할 수 있습니다.
            .ifPresent(m->{
                throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /* 전체회원조회 */

    public List<Members> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Members> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
