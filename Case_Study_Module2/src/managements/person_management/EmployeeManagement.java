package managements.person_management;

import managements.DocumentEmployee;
import models.person.*;

import java.io.*;
import java.util.*;

public class EmployeeManagement implements PersonManagement {
    private final String targetPath = "src/data/Employee.csv";
    private final File employeeFile = new File(targetPath);
    private static final String CSV_SEPARATOR = ",";
    private static final String FILE_HEADER = "idEmployee,fullName,address,birthDay,id,phoneNumber,email,gender,level,position,salary,department";
    private Map<String, Employee> map;

    public EmployeeManagement() {
        map = new HashMap<>();
    }

    @Override
    public void addPerson(Person person) {
        map = getDataFromFile();

        var employee = (Employee) person;

        map.put(employee.getIdEmployee(), employee);
        writeDataToFile();
    }

    @Override
    public void showInfoPerson() {
        map = getDataFromFile();

        if (map.isEmpty())
            return;

        var i = 1;
        for (var employee : map.entrySet()) {
            System.out.println(i + ".  " + employee.getValue());
            i++;
        }
    }

    public Stack<Employee> createDocument(){
        var stack = new Stack<Employee>();

        var map = getDataFromFile();
        for(var entry : map.entrySet()){
            stack.push(entry.getValue());
        }

        return stack;
    }

    private Map<String, Employee> getDataFromFile() {
        Map<String, Employee> newMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(employeeFile))) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                var splitData = line.split(CSV_SEPARATOR);
                var employee = convertDataToObject(splitData);
                newMap.put(employee.getIdEmployee(), employee);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return newMap;
    }

    private void writeDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(employeeFile))) {
            writer.append(FILE_HEADER);
            writer.newLine();

            for (Map.Entry<String, Employee> entry : map.entrySet()) {
                var builder = new StringBuilder();
                var employee = entry.getValue();

                builder.append(entry.getKey());
                builder.append(CSV_SEPARATOR);
                builder.append(employee.getFullName());
                builder.append(CSV_SEPARATOR);
                builder.append(employee.getAddress());
                builder.append(CSV_SEPARATOR);
                builder.append(employee.getBirthDay());
                builder.append(CSV_SEPARATOR);
                builder.append(employee.getId());
                builder.append(CSV_SEPARATOR);
                builder.append(employee.getPhoneNumber());
                builder.append(CSV_SEPARATOR);
                builder.append(employee.getEmail());
                builder.append(CSV_SEPARATOR);
                builder.append(employee.getGender());
                builder.append(CSV_SEPARATOR);
                builder.append(employee.getLevel());
                builder.append(CSV_SEPARATOR);
                builder.append(employee.getPosition());
                builder.append(CSV_SEPARATOR);
                builder.append(employee.getSalary());
                builder.append(CSV_SEPARATOR);
                builder.append(employee.getDepartment());
                builder.append(CSV_SEPARATOR);

                writer.write(builder.toString());
                writer.newLine();
            }

            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Employee convertDataToObject(String[] splitData) {
        var employee = new Employee();

        employee.setIdEmployee(splitData[0]);
        employee.setFullName(splitData[1]);
        employee.setAddress(splitData[2]);
        employee.setBirthDay(splitData[3]);
        employee.setId(splitData[4]);
        employee.setPhoneNumber(splitData[5]);
        employee.setEmail(splitData[6]);

        //setting gender
        var gender = Gender.UNKNOWN;
        switch (splitData[7]) {
            case "MALE":
                gender = Gender.MALE;
                break;
            case "FEMALE":
                gender = Gender.FEMALE;
                break;
            case "UNKNOWN":
                gender = Gender.UNKNOWN;
                break;
        }

        employee.setGender(gender);

        //setting employee level
        var level = LevelEmployee.UNIVERSITY;
        switch (splitData[8]) {
            case "INTERMEDIATE":
                level = LevelEmployee.INTERMEDIATE;
                break;
            case "COLLEGE":
                level = LevelEmployee.COLLEGE;
                break;
            case "UNIVERSITY":
                level = LevelEmployee.UNIVERSITY;
                break;
            case "POSTGRADUATE":
                level = LevelEmployee.POSTGRADUATE;
                break;
        }

        employee.setLevel(level);

        // setting position of employee
        var position = Position.WAITRESS;
        switch (splitData[9]) {
            case "RECEPTIONIST":
                position = Position.RECEPTIONIST;
                break;
            case "WAITRESS":
                position = Position.WAITRESS;
                break;
            case "SPECIALIST":
                position = Position.SPECIALIST;
                break;
            case "SUPERVISOR":
                position = Position.SUPERVISOR;
                break;
            case "MANAGER":
                position = Position.MANAGER;
                break;
            case "DIRECTOR":
                position = Position.DIRECTOR;
                break;
        }

        employee.setPosition(position);

        employee.setSalary(Double.parseDouble(splitData[10]));

        // setting department of employee
        var department = Department.SERVICE;
        switch (splitData[11]) {
            case "SALE_MARKETING":
                department = Department.SALE_MARKETING;
                break;
            case "ADMINISTRATION":
                department = Department.ADMINISTRATION;
                break;
            case "SERVICE":
                department = Department.SERVICE;
                break;
            case "MANAGEMENT":
                department = Department.MANAGEMENT;
                break;
        }

        employee.setDepartment(department);

        return employee;

    }

    public static void main(String[] args) {
        EmployeeManagement manager = new EmployeeManagement();

        Employee e1 = new Employee("A", "hue", "13/12/1996",
                "1", "31213", "abc@gmai.com", Gender.MALE,
                LevelEmployee.COLLEGE, Position.RECEPTIONIST, 1000,
                Department.SALE_MARKETING, "001");
        Employee e2 = new Employee("B", "hue", "13/12/1997",
                "2", "31213", "abc@gmai.com", Gender.FEMALE,
                LevelEmployee.INTERMEDIATE, Position.RECEPTIONIST, 1000,
                Department.SALE_MARKETING, "002");
        Employee e3 = new Employee("C", "hue", "13/12/1998",
                "3", "31213", "abc@gmai.com", Gender.MALE,
                LevelEmployee.COLLEGE, Position.RECEPTIONIST, 1000,
                Department.SALE_MARKETING, "003");
        Employee e4 = new Employee("D", "hue", "13/12/1999",
                "4", "31213", "abc@gmai.com", Gender.FEMALE,
                LevelEmployee.POSTGRADUATE, Position.DIRECTOR, 1000,
                Department.SALE_MARKETING, "004");
        Employee e5 = new Employee("E", "hue", "13/12/1990",
                "5", "31213", "abc@gmai.com", Gender.MALE,
                LevelEmployee.COLLEGE, Position.RECEPTIONIST, 1000,
                Department.SALE_MARKETING, "005");
        Employee e6 = new Employee("F", "hue", "13/12/1991",
                "6", "31213", "abc@gmai.com", Gender.MALE,
                LevelEmployee.COLLEGE, Position.RECEPTIONIST, 1000,
                Department.SALE_MARKETING, "006");
        Employee e7 = new Employee("G", "hue", "13/12/1992",
                "7", "31213", "abc@gmai.com", Gender.FEMALE,
                LevelEmployee.COLLEGE, Position.RECEPTIONIST, 1000,
                Department.SALE_MARKETING, "007");
        Employee e8 = new Employee("H", "hue", "13/12/1993",
                "8", "31213", "abc@gmai.com", Gender.FEMALE,
                LevelEmployee.COLLEGE, Position.RECEPTIONIST, 1000,
                Department.SALE_MARKETING, "008");
        Employee e9 = new Employee("I", "hue", "13/12/1994",
                "9", "31213", "abc@gmai.com", Gender.MALE,
                LevelEmployee.COLLEGE, Position.RECEPTIONIST, 1000,
                Department.SALE_MARKETING, "009");
        Employee e10 = new Employee("L", "hue", "13/12/1996",
                "11", "31213", "abc@gmai.com", Gender.FEMALE,
                LevelEmployee.COLLEGE, Position.RECEPTIONIST, 1000,
                Department.SALE_MARKETING, "011");

        manager.addPerson(e1);
        manager.addPerson(e2);
        manager.addPerson(e3);
        manager.addPerson(e4);
        manager.addPerson(e5);
        manager.addPerson(e6);
        manager.addPerson(e7);
        manager.addPerson(e8);
        manager.addPerson(e9);
        manager.addPerson(e10);

    }
}
