package hello.hellospring.controller;

import hello.hellospring.domain.Members;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}