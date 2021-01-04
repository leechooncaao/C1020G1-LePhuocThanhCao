package controllers;

import managements.DocumentEmployee;
import managements.booking_management.BookingMovieTicketManagement;
import managements.person_management.EmployeeManagement;

import java.util.Scanner;

public class MainController {
    private static final Scanner scanner = new Scanner(System.in);

    public static void showMainMenu(){
        System.out.println("--------------------------------");
        System.out.println("1. Add New Service");
        System.out.println("2. Show Services");
        System.out.println("3. Add New Customer");
        System.out.println("4. Show Information of Customer");
        System.out.println("5. Add New Booking");
        System.out.println("6. Show Information of Employee");
        System.out.println("7. Book movie ticket");
        System.out.println("8. Search Employee by IDEmployee");
        System.out.println("9. Exit");
        System.out.println("Your choice : ");
    }

    private static void addNewService(){
        ServiceController.addNewService();
    }

    private static void showServices(){
        ServiceController.showServices();
    }

    private static void addNewCustomer(){
        CustomerController.addCustomer();
    }

    private static void showInfoCustomer(){
        CustomerController.showCustomer();
    }

    private static void showInfoEmployee(){
        EmployeeManagement employeeManager = new EmployeeManagement();
        employeeManager.showInfoPerson();
    }

    private static void addNewBooking(){
        BookingController.createNewContract();
    }

    private static void bookMovieTicket(){
        BookingMovieTicketManagement.bookMovieTicket();
    }

    private static void searchEmployeeById(){
        var document = new DocumentEmployee();
        document.searchEmployeeById();
    }

    public static void main(String[] args) {
        showMainMenu();
        var choice = -1;
        while (true){
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addNewService();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addNewCustomer();
                    main(new String[]{});
                    break;
                case 4:
                    showInfoCustomer();
                    main(new String[]{});
                    break;
                case 5:
                    addNewBooking();
                    main(new String[]{});
                    break;
                case 6:
                    showInfoEmployee();
                    main(new String[]{});
                    break;
                case 7:
                    bookMovieTicket();
                    main(new String[]{});
                    break;
                case 8:
                    searchEmployeeById();
                    main(new String[]{});
                    break;
                case 9:
                    System.exit(1);
                default:
                    System.out.println("Invalid input !");
                    showMainMenu();
            }

        }
    }
}
