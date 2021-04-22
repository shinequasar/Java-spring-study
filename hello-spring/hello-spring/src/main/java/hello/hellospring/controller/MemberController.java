package hello.hellospring.controller;

import com.sun.source.tree.MemberSelectTree;
import hello.hellospring.domain.Members;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //@GetMapping 은 조회할 때 주로 씀
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    //@PostMapping 은 등록할 때 주로 씀
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Members member = new Members();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
}