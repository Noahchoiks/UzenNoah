package net.noah.com.controller;

import net.noah.com.constant.NameConstants;
import net.noah.com.entity.Address;
import net.noah.com.entity.Member;
import net.noah.com.repository.AddressRepository;
import net.noah.com.repository.MemberRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class MainController {
    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    AddressRepository addressRepository;

    @PersistenceContext
    EntityManager entityManager;

    @RequestMapping(value = "/", method = { GET })
    public String main(Model model) throws Exception {
        return "pages/index";
    }

    @RequestMapping(value = "/entity", method = { GET })
    public String entity(Model model) throws Exception {
//        QMember member = QMember.member;
//        JPAQuery jpaQuery = new JPAQuery(entityManager);
//        List<Member> memberList = jpaQuery.from(member).list(QMember.member);
//        model.addAttribute("memberList", memberList);
        // rskeksfsdfsdfssfsdfsfssdfsdfssfsdfds
        return "pages/entity";
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

        return "pages/createMembers";
    }

    @RequestMapping(value = "/memberList", method = { GET })
    public String memberList(Model model, @RequestParam int pageNo, @RequestParam int size) throws Exception {

        Page<Member> memberList = memberRepository.findAll(new PageRequest(pageNo, size));

        model.addAttribute("memberList", memberList);
        return "pages/memberList";
    }

    private Member createRandomUser() {
        Member member = new Member();
        member.setFirstName(NameConstants.FIRST_NAME_SET[getRandomInteger(NameConstants.FIRST_NAME_SET.length, true)]);
        member.setLastName(NameConstants.LAST_NAME_SET[getRandomInteger(NameConstants.LAST_NAME_SET.length, true)]);
        member.setAge(getRandomInteger(100, false));
        member.setMemberYn(true);

        String memberLastName = member.getLastName();

        Address address = new Address();

        address.setAddress1(memberLastName + "'s Address1");
        address.setAddress2(memberLastName + "'s Address2");
        address.setAddress3(memberLastName + "'s Address3");
        address.setAddressDetail(memberLastName + "'s Address Detail");
        address.setZipCodeNo1(100 + getRandomInteger(100, false));
        address.setZipCodeNo2(100 + getRandomInteger(100, false));

        addressRepository.save(address);

        member.setAddress(address);
        return member;
    }

    private int getRandomInteger(int arange, boolean allowZeroValue) {
        return (int) Math.floor(Math.random() * arange + (allowZeroValue ? 0 : 1));
    }

}
