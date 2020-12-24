package controllers;

import commons.exceptions.BirthDayException;
import commons.exceptions.EmailException;
import commons.exceptions.IdCardException;
import commons.exceptions.NameException;
import commons.validation.CustomerValidator;
import managements.person_management.CustomerManagement;
import models.person.Customer;
import models.person.CustomerType;
import models.person.Gender;

import java.util.Scanner;

public class CustomerController {
    private static final Scanner scannerCustomer = new Scanner(System.in);
    private static final CustomerManagement customerManager = new CustomerManagement();

    public static void addCustomer(){
        boolean isValid;

        // fullName
        String fullName;
        do{
            System.out.println("FullName : ");
            fullName = scannerCustomer.nextLine();
            try {
                CustomerValidator.validateName(fullName);
                isValid = true;
            } catch (NameException e) {
                System.out.println(e.getMessage());
                isValid = false;
            }
        }while (!isValid);

        // Address
        System.out.println("Address : ");
        var address = scannerCustomer.nextLine();

        //Birthday
        String birthDay;
        do{
            System.out.println("Birthday : ");
            birthDay = scannerCustomer.nextLine();

            try {
                CustomerValidator.validateBirthDay(birthDay);
                isValid = true;
            } catch (BirthDayException e) {
                System.out.println(e.getMessage());
                isValid = false;
            }
        }while (!isValid);


        // id
        String id;
        do{
            System.out.println("ID Card number : ");
            id = scannerCustomer.nextLine();

            try {
                CustomerValidator.validateIdCard(id);
                isValid = true;
            } catch (IdCardException e) {
                System.out.println(e.getMessage());
                isValid = false;
            }
        }while (!isValid);

        // phone number
        System.out.println("Phone Number : ");
        var phoneNumber = scannerCustomer.nextLine();

        // Email
        String email;
        do{
            System.out.println("Email :");
            email = scannerCustomer.nextLine();

            try{
                CustomerValidator.validateEmail(email);
                isValid = true;
            } catch (EmailException e) {
                System.out.println(e.getMessage());
                isValid = false;
            }
        }while (!isValid);

        // Gender
        System.out.println("Gender : ");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Unknown");
        System.out.println("Your choice :");
        var choice = Integer.parseInt(scannerCustomer.nextLine());

        Gender gender = Gender.UNKNOWN;
        switch (choice){
            case 1:
                gender =  Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.UNKNOWN;
                break;
            default:
                System.out.println("Invalid input");
        }

        // customer type
        System.out.println("Type of customer :");
        System.out.println("1. Diamond");
        System.out.println("2. Silver");
        System.out.println("3. Platinum");
        System.out.println("4. Gold");
        System.out.println("5. Member");
        System.out.println("Your choice :");
        var input = Integer.parseInt(scannerCustomer.nextLine());
        CustomerType customerType = CustomerType.MEMBER;
        switch (input){
            case 1:
                customerType = CustomerType.DIAMOND;
                break;
            case 2:
                customerType = CustomerType.SILVER;
                break;
            case 3:
                customerType = CustomerType.PLATINUM;
                break;
            case 4:
                customerType = CustomerType.GOLD;
                break;
            case 5:
                customerType = CustomerType.MEMBER;
                break;
            default:
                System.out.println("Invalid input");
        }

        Customer newCustomer = new Customer(fullName,address,birthDay,
                id,phoneNumber,email,gender,customerType);

        customerManager.addPerson(newCustomer);
    }

    public static void showCustomer(){
        customerManager.showInfoPerson();
    }
}
