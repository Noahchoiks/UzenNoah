package net.noah.com.repository;

import net.noah.com.entity.Member;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Integer> {
    long countByLastName(String lastname);

    Iterable<Member> findAllByMemberNoIsNotNullOrderByAgeDesc();

    Iterable<Member> findByAgeLessThan(int lessThan);

    Iterable<Member> findByAgeLessThanOrderByAgeDesc(int lessThan);

}
