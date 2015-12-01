package net.noah.com.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import net.noah.com.constant.NameConstants;
import net.noah.com.entity.Member;
import net.noah.com.repository.MemberRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MemberRepository memberRepository;

    @RequestMapping(value = "/", method = { GET })
    public String main(Model model) throws Exception {
        return "pages/index";
    }

    @RequestMapping(value = "/createUsers/{numbers}", method = { GET })
    public String createUsers(Model model, @PathVariable int numbers) throws Exception {
        int lessThan = 10;
        memberRepository.deleteAll();

        // for (int i = 0; i < numbers; i++) {
        // memberRepository.save(createRandomUser());
        // }

        // faster than save(T) iterator
        List<Member> temp = new ArrayList<Member>();
        for (int i = 0; i < numbers; i++) {
            temp.add(createRandomUser());
        }
        memberRepository.save(temp);

        Iterable<Member> memberList = memberRepository.findAllByMemberNoIsNotNullOrderByAgeDesc();
        model.addAttribute("memberList", memberList);
        Iterable<Member> ageLessthanList = memberRepository.findByAgeLessThanOrderByAgeDesc(lessThan);
        model.addAttribute("lessThan", lessThan);
        model.addAttribute("ageLessthanList", ageLessthanList);

        return "pages/createUsers";
    }

    private Member createRandomUser() {
        Member member = new Member();
        member.setFirstName(NameConstants.FIRST_NAME_SET[(int) Math.floor(Math.random() * NameConstants.FIRST_NAME_SET.length)]);
        member.setLastName(NameConstants.LAST_NAME_SET[(int) Math.floor(Math.random() * NameConstants.LAST_NAME_SET.length)]);
        member.setAge((int) Math.floor(Math.random() * 100 + 1));
        member.setMemberYn(true);
        return member;
    }

}
