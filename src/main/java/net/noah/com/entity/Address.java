package net.noah.com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private int addressNo;
    private int zipCodeNo1;
    private int zipCodeNo2;
    private String address1;
    private String address2;
    private String address3;
    private String addressDetail;

    public int getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(int addressNo) {
        this.addressNo = addressNo;
    }

    public int getZipCodeNo1() {
        return zipCodeNo1;
    }

    public void setZipCodeNo1(int zipCodeNo1) {
        this.zipCodeNo1 = zipCodeNo1;
    }

    public int getZipCodeNo2() {
        return zipCodeNo2;
    }

    public void setZipCodeNo2(int zipCodeNo2) {
        this.zipCodeNo2 = zipCodeNo2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    @Override
    public String toString() {
        return "Address [addressNo=" + addressNo + ", zipCodeNo1=" + zipCodeNo1 + ", zipCodeNo2=" + zipCodeNo2 + ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3 + ", addressDetail=" + addressDetail + "]";
    }
}
