package dsa_stack_queue.bai_tap.tochuchoplidulieu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DemergingByQueue {
    public static void main(String[] args) throws ParseException {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Thanh Cao","Male",
                new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2010")));
        list.add(new Employee("Quang Duong","Male",
                new SimpleDateFormat("dd-MM-yyyy").parse("03-11-2012")));
        list.add(new Employee("Hong Thanh","Female",
                new SimpleDateFormat("dd-MM-yyyy").parse("15-02-1996")));
        list.add(new Employee("Thu Ha","Female",
                new SimpleDateFormat("dd-MM-yyyy").parse("13-12-2015")));
        list.add(new Employee("Hong Nhung","Female",
                new SimpleDateFormat("dd-MM-yyyy").parse("25-04-2008")));
        list.add(new Employee("Van Kien","Female",
                new SimpleDateFormat("dd-MM-yyyy").parse("22-10-2013")));

        System.out.println("Before sorting : ");
        for(var element : list)
            System.out.println(element.getFullName() + "; " + element.getGender() + "; " + element.getBirthDay());

        System.out.println();
        System.out.println("After sorting by birthDay : ");
        Collections.sort(list);
        for(var element : list)
            System.out.println(element.getFullName() + "; " + element.getGender() + "; " + element.getBirthDay());

        Queue<Employee> female = new ArrayDeque<>();
        Queue<Employee> male = new ArrayDeque<>();

        for(var employee : list){
            if(employee.getGender().equals("Female"))
                female.add(employee);
            else
                male.add(employee);
        }

        List<Employee> sortedList = new ArrayList<>();
        while (!female.isEmpty())
            sortedList.add(female.remove());

        while (!male.isEmpty())
            sortedList.add(male.remove());

        System.out.println();
        System.out.println("After sorting by gender and birthday :");
        for(var element : sortedList)
            System.out.println(element.getFullName() + "; " + element.getGender() + "; " + element.getBirthDay());



    }
}
