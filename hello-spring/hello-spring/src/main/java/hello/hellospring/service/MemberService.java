package hello.hellospring.service;

import hello.hellospring.domain.Members;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    //Ctrl+Shift+T
    private final MemberRepository memberRepository = new MemoryMemberRepository();

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
