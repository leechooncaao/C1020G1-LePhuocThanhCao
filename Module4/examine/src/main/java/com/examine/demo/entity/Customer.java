package com.examine.demo.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

//    @Pattern(regexp = "^(KH-)\\d{4}$", message = "Code must be KH-XXXX")
//    @Column(name = "customer_code", length = 45)
//    private String code;

    @Column(name = "customer_name", length = 45, nullable = false)
    private String name;

//    @Pattern(regexp = "(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\+\\(84\\) 90)\\d{7}$)|(^(\\+\\(84\\) 91)\\d{7}$)", message = "Phone number is not valid")
    @Column(name = "customer_phone", length = 45, nullable = false)
    private String phoneNumber;

//    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message = "Email is not valid")
    @Column(name = "customer_email", length = 45)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Contract> contracts;

    public Customer() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
