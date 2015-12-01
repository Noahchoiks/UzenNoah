package net.noah.com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    @GeneratedValue
    private int memberNo;
    private String firstName;
    private String lastName;
    private int age;
    private boolean memberYn;

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMemberYn() {
        return memberYn;
    }

    public void setMemberYn(boolean memberYn) {
        this.memberYn = memberYn;
    }

    @Override
    public String toString() {
        return "Member [memberNo=" + memberNo + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", memberYn=" + memberYn + "]";
    }

}
