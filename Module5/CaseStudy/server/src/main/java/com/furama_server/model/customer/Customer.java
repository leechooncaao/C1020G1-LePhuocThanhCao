package com.furama_server.model.customer;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.furama_server.model.contract.Contract;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "customer")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")
    private CustomerType customerType;

//    @Pattern(regexp = "^(KH-)\\d{4}$", message = "Code must be KH-XXXX")
    @Column(name = "customer_code", length = 45)
    private String code;

    @Column(name = "customer_name", length = 45, nullable = false)
    private String name;

    @Column(name = "customer_birthday", columnDefinition = "date",nullable = false)
    private String birthday;

    @Column(name = "customer_gender", length = 10, nullable = false)
    private String gender;

//    @Pattern(regexp = "(^\\d{9}$)|(^\\d{12}$)", message = "ID Card is not valid")
    @Column(name = "customer_id_card", length = 45, nullable = false)
    private String idCard;

//    @Pattern(regexp = "(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\+\\(84\\) 90)\\d{7}$)|(^(\\+\\(84\\) 91)\\d{7}$)", message = "Phone number is not valid")
    @Column(name = "customer_phone", length = 45, nullable = false)
    private String phoneNumber;

//    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message = "Email is not valid")
    @Column(name = "customer_email", length = 45)
    private String email;

    @Column(name = "customer_address", length = 45)
    private String address;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
//    private List<Contract> contracts;

    public Customer() {
    }

    public Customer(CustomerType customerType, String code, String name, String birthday, String gender, String idCard, String phoneNumber, String email, String address) {
        this.customerType = customerType;
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

//    public List<Contract> getContracts() {
//        return contracts;
//    }
//
//    public void setContracts(List<Contract> contracts) {
//        this.contracts = contracts;
//    }
}
