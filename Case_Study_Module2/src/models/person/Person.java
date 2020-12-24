package models.person;

import java.io.Serializable;

public class Person implements Serializable {
    private String fullName;
    private String address;
    private String birthDay;
    private String id;
    private String phoneNumber;
    private String email;
    private Gender gender;

    public Person(String fullName, String address,
                  String birthDay, String id, String phoneNumber, String email, Gender gender) {
        this.fullName = fullName;
        this.address = address;
        this.birthDay = birthDay;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }

    public Person() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
