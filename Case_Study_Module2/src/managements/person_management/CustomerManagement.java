package managements.person_management;

import models.person.Customer;
import models.person.CustomerType;
import models.person.Gender;
import models.person.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerManagement implements PersonManagement {
    private final String targetPath = "src/data/Customer.csv";
    private final File customerFile = new File(targetPath);
    private static final String CSV_SEPARATOR = ",";
    private static final String FILE_HEADER = "fullName,address,birthDay,id,phoneNumber,email,gender,customerType";
    private List<Customer> list;

    public CustomerManagement() {
        list = new ArrayList<>();
    }

    @Override
    public void addPerson(Person person) {
        list = getDataFromFile();

        list.add((Customer) person);
        writeDataToFile();
    }

    @Override
    public void showInfoPerson() {
        list = getDataFromFile();

        if (list.isEmpty())
            return;

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++)
            System.out.println((i + 1) + ". " + list.get(i));
    }

    public Customer getCustomerByOrder(int index) {
        list = getDataFromFile();

        Collections.sort(list);

        return list.get(index);
    }


    private List<Customer> getDataFromFile() {
        List<Customer> newList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(customerFile))) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                var splitData = line.split(CSV_SEPARATOR);
                var customer = convertDataToObject(splitData);
                newList.add(customer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return newList;
    }

    private void writeDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(customerFile))) {
            writer.append(FILE_HEADER);
            writer.newLine();

            for (var customer : list) {

                String customerInfo = customer.getFullName() +
                        CSV_SEPARATOR +
                        customer.getAddress() +
                        CSV_SEPARATOR +
                        customer.getBirthDay() +
                        CSV_SEPARATOR +
                        customer.getId() +
                        CSV_SEPARATOR +
                        customer.getPhoneNumber() +
                        CSV_SEPARATOR +
                        customer.getEmail() +
                        CSV_SEPARATOR +
                        customer.getGender() +
                        CSV_SEPARATOR +
                        customer.getCustomerType();

                writer.write(customerInfo);
                writer.newLine();
            }

            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Customer convertDataToObject(String[] splitData) {
        var customer = new Customer();

        customer.setFullName(splitData[0]);
        customer.setAddress(splitData[1]);
        customer.setBirthDay(splitData[2]);
        customer.setId(splitData[3]);
        customer.setPhoneNumber(splitData[4]);
        customer.setEmail(splitData[5]);

        //setting gender
        var gender = Gender.UNKNOWN;
        switch (splitData[6]) {
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

        customer.setGender(gender);

        //setting customerType
        var customerType = CustomerType.MEMBER;
        switch (splitData[7]) {
            case "DIAMOND":
                customerType = CustomerType.DIAMOND;
                break;
            case "SILVER":
                customerType = CustomerType.SILVER;
                break;
            case "PLATINUM":
                customerType = CustomerType.PLATINUM;
                break;
            case "GOLD":
                customerType = CustomerType.GOLD;
                break;
            case "MEMBER":
                customerType = CustomerType.MEMBER;
                break;
        }

        customer.setCustomerType(customerType);

        return customer;

    }

    public static void main(String[] args) {
        var customer_1 = new Customer("customer_1","hue","13/12/1996","1","3123112","thanhcao@gmail.com",Gender.MALE,CustomerType.GOLD);
        var customer_2 = new Customer("customer_2","hue","13/12/1996","1","3123112","thanhcao@gmail.com",Gender.MALE,CustomerType.GOLD);
        var customer_3 = new Customer("customer_3","hue","13/12/1996","1","3123112","thanhcao@gmail.com",Gender.MALE,CustomerType.GOLD);
        var customer_4 = new Customer("customer_41","hue","13/12/1996","1","3123112","thanhcao@gmail.com",Gender.MALE,CustomerType.GOLD);

        var manager = new CustomerManagement();

        manager.addPerson(customer_1);
        manager.addPerson(customer_2);
        manager.addPerson(customer_3);
        manager.addPerson(customer_4);

        manager.showInfoPerson();
    }
}
