package managements.booking_management;

import managements.person_management.CustomerManagement;
import models.person.Customer;
import models.person.CustomerType;
import models.person.Gender;

import java.io.*;
import java.util.*;

public class BookingMovieTicketManagement {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String TARGET_PATH = "src/data/Ticket.csv";
    private static final File TICKET_FILE = new File(TARGET_PATH);
    private static final String CSV_SEPARATOR = ",";
    private static final String FILE_HEADER = "fullName,address,birthDay,id,phoneNumber,email,gender,customerType";
    private static final int NUMBER_TICKET = 2;
    private static Queue<Customer> LIST_TICKET = new ArrayDeque<>();

    public static void bookMovieTicket() {
        LIST_TICKET = getDataFromFile();

        if(LIST_TICKET.size() >= NUMBER_TICKET){
            System.out.println("Tickets are sold out !");
            showListTicket();
            return;
        }

        var customerManager = new CustomerManagement();

        customerManager.showInfoPerson();
        System.out.println("Choose a customer to book the ticket : ");
        var choice = Integer.parseInt(SCANNER.nextLine());

        var customer = customerManager.getCustomerByOrder(choice - 1);
        LIST_TICKET.add(customer);

        writeDataToFile();
    }

    private static void showListTicket() {
        LIST_TICKET = getDataFromFile();

        System.out.println("List of customer who bought ticket by order buying");
        int i = 1;
        for (var customer : LIST_TICKET)
            System.out.println(i + ". " + customer);
    }

    private static Queue<Customer> getDataFromFile() {
        Queue<Customer> newQueue = new ArrayDeque<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(TICKET_FILE))) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                var splitData = line.split(CSV_SEPARATOR);
                var customer = convertDataToObject(splitData);
                newQueue.add(customer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return newQueue;
    }

    private static void writeDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TICKET_FILE))) {
            writer.append(FILE_HEADER);
            writer.newLine();

            for (var customer : LIST_TICKET) {

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

    private static Customer convertDataToObject(String[] splitData) {
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
}
