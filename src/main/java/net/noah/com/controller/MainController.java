package net.noah.com.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import net.noah.com.entity.Member;
import net.noah.com.repository.MemberRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MemberRepository memberRepository;

    @RequestMapping(value = { "/", "" }, method = { GET })
    public String main(Model model) throws Exception {
        Member member = new Member();
        member.setMemberNo(1);
        member.setFirstName("noah");
        member.setLastName("choi");
        member.setAge(30);
        member.setMemberYn(true);

        memberRepository.save(member);

        Member returnMember = memberRepository.findOne(1);
        model.addAttribute("member", returnMember.getFirstName());
        return "index";
    }
}
