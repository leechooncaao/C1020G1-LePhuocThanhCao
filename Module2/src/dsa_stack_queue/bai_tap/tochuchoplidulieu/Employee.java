package dsa_stack_queue.bai_tap.tochuchoplidulieu;

import java.util.Date;

public class Employee implements Comparable<Employee>{
    private String fullName;
    private String gender;
    private Date birthDay;

    public Employee(String fullName, String gender, Date birthDay) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthDay = birthDay;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public int compareTo(Employee otherEmployee) {
//        if(this.birthDay.getTime() > otherEmployee.getBirthDay().getTime()) return 1;
//        else if(this.birthDay.getTime() < otherEmployee.getBirthDay().getTime()) return -1;
//        else return 1;
        return getBirthDay().compareTo(otherEmployee.getBirthDay());
    }
}
