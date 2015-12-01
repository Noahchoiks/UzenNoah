package net.noah.com.repository;

import net.noah.com.entity.Member;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Integer> {

}
