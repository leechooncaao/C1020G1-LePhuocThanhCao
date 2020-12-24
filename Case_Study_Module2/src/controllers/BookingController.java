package controllers;

import managements.booking_management.BookingRentalServiceManagement;
import managements.person_management.CustomerManagement;
import managements.rental_service_management.HouseManagement;
import managements.rental_service_management.RentalServiceManagement;
import managements.rental_service_management.RoomManagement;
import managements.rental_service_management.VillaManagement;
import models.contracts.Contract;
import models.person.Customer;
import models.services.accompanied_services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingController {
    private static final Scanner scannerBooking = new Scanner(System.in);
    private static final BookingRentalServiceManagement bookingManager = new BookingRentalServiceManagement();
    private static RentalServiceManagement serviceManager;
    private static int choice;

    public static void createNewContract(){
        // choosing a customer to create contract
        CustomerController.showCustomer();
        System.out.println("Choose the customer you want to create a new booking");
        choice = Integer.parseInt(scannerBooking.nextLine());
        var customerManager = new CustomerManagement();
        var customer = customerManager.getCustomerByOrder(choice -1);

        // choosing rental service to create contract
        displayMenuBooking();
        choice = Integer.parseInt(scannerBooking.nextLine());
        switch (choice){
            case 1:
                createVillaContract(customer);
                break;
            case 2:
                createHouseContract(customer);
                break;
            case 3:
                createRoomContract(customer);
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    private static void displayMenuBooking(){
        System.out.println("--------------");
        System.out.println("1. Booking Villa");
        System.out.println("2. Booking House");
        System.out.println("3. Booking Room");
        System.out.println("Your choice : ");
    }

    private static void createVillaContract(Customer customer){
        // choosing villa
        serviceManager = new VillaManagement();
        serviceManager.showInfoService();
        System.out.println("Choose the villa you want to rent");
        choice = Integer.parseInt(scannerBooking.nextLine());
        var villa = serviceManager.getServiceByOrder(choice - 1);

        // get list of accompanied services
        var list = getListAccompaniedServices();

        var startDay = getStartDay();

        var endDay = getEndDay();

        var newContract = new Contract(customer,villa,list,startDay,endDay);

        bookingManager.addNewBooking(newContract);
        bookingManager.showListBooking();
    }

    private static void createHouseContract(Customer customer){
        // choosing house
        serviceManager = new HouseManagement();
        serviceManager.showInfoService();
        System.out.println("Choose the house you want to rent");
        choice = Integer.parseInt(scannerBooking.nextLine());
        var house = serviceManager.getServiceByOrder(choice - 1);

        // get list of accompanied services
        var list = getListAccompaniedServices();

        var startDay = getStartDay();

        var endDay = getEndDay();

        var newContract = new Contract(customer,house,list,startDay,endDay);

        bookingManager.addNewBooking(newContract);
        bookingManager.showListBooking();
    }

    private static void createRoomContract(Customer customer){
        // choosing room
        serviceManager = new RoomManagement();
        serviceManager.showInfoService();
        System.out.println("Choose the house you want to rent");
        choice = Integer.parseInt(scannerBooking.nextLine());
        var room = serviceManager.getServiceByOrder(choice - 1);

        // get list of accompanied services
        var list = getListAccompaniedServices();

        var startDay = getStartDay();

        var endDay = getEndDay();

        var newContract = new Contract(customer,room,list,startDay,endDay);

        bookingManager.addNewBooking(newContract);
        bookingManager.showListBooking();
    }

    private static List<AccompaniedService> getListAccompaniedServices(){
        // display menu of accompanied services
        System.out.println("1. Beverage");
        System.out.println("2. Food");
        System.out.println("3. CarRental");
        System.out.println("4. Karaoke");
        System.out.println("5. Massage");
        System.out.println("6. Finish");
        System.out.println("Your choice : ");

        List<AccompaniedService> list = new ArrayList<>();

        while (choice != 6){
            choice = Integer.parseInt(scannerBooking.nextLine());
            switch (choice){
                case 1 :
                    System.out.println("Beverage");
                    list.add(new Beverage());
                    break;
                case 2:
                    System.out.println("Food");
                    list.add(new Food());
                    break;
                case 3:
                    System.out.println("Car rental");
                    list.add(new CarRental());
                    break;
                case 4:
                    System.out.println("Karaoke");
                    list.add(new Karaoke());
                    break;
                case 5:
                    System.out.println("Massage");
                    list.add(new Massage());
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid input");


            }
        }

        return list;
    }

    private static String getStartDay(){
        System.out.println("Enter the start day in format dd/mm/yyyy : ");
        return scannerBooking.nextLine();
    }

    private static String getEndDay(){
        System.out.println("Enter the end day in format dd/mm/yyyy : ");
        return scannerBooking.nextLine();
    }

    public static void main(String[] args) {
        createNewContract();
    }
}
