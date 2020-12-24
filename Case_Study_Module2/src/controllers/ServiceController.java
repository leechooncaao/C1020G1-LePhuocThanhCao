package controllers;

import commons.validation.ServiceValidator;
import managements.rental_service_management.HouseManagement;
import managements.rental_service_management.RentalServiceManagement;
import managements.rental_service_management.RoomManagement;
import managements.rental_service_management.VillaManagement;
import models.services.rental_services.*;

import java.util.Scanner;

public class ServiceController {
    private static final Scanner scannerService = new Scanner(System.in);
    private static RentalServiceManagement serviceManager;

    // adding new rental service
    public static void addNewService() {
        displayServiceAddingMenu();
        var input = -1;
        while (true) {
            input = Integer.parseInt(scannerService.nextLine());
            switch (input) {
                case 1:
                    addNewVilla();
                    displayServiceAddingMenu();
                    break;
                case 2:
                    addNewHouse();
                    displayServiceAddingMenu();
                    break;
                case 3:
                    addNewRoom();
                    displayServiceAddingMenu();
                    break;
                case 4:
                    MainController.main(new String[]{});
                    break;
                case 5:
                    System.exit(1);
                default:
                    System.out.println("Invalid input");
                    displayServiceAddingMenu();
            }
        }

    }

    private static void displayServiceAddingMenu() {
        System.out.println("--------------------------------------");
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Back to Menu");
        System.out.println("5. Exit");
    }

    private static void showMenuRentalType() {
        System.out.println("Rental type : ");
        System.out.println("1. By Hour");
        System.out.println("2. By Day");
        System.out.println("3. By Month");
        System.out.println("4. By Year");
        System.out.println("Your choice : ");
    }

    private static void addNewVilla() {
        var nameService = getNameService();

        var price = getPriceService();

        var areaUsing = getAreaUsing();

        RentalType rentalType = getRentalType();

        String otherAmenities = getOtherAmenities();

        int numberTenants = getNumberTenants();

        boolean isValid;

        // floor number
        int floorNumber;
        do {
            System.out.println("floor number :");
            floorNumber = Integer.parseInt(scannerService.nextLine());
            if (!ServiceValidator.validateFloorNumber(floorNumber)) {
                System.out.println("floor number must be greater than 0");
                isValid = false;
            } else isValid = true;
        } while (!isValid);

        // pool area
        int poolArea;
        do {
            System.out.println("Pool Area : ");
            poolArea = Integer.parseInt(scannerService.nextLine());
            if (!ServiceValidator.validateFloorNumber(poolArea)) {
                System.out.println("Pool area must be greater than 0");
                isValid = false;
            } else isValid = true;
        } while (!isValid);

        //id villa
        String idService;
        do {
            System.out.println("ID service : ");
            idService = scannerService.nextLine();
            if (!ServiceValidator.validateIdVilla(idService)) {
                System.out.println("ID villa must be in format SVVL-XXXX");
                isValid = false;
            } else isValid = true;
        } while (!isValid);

        Villa newVilla = new Villa(nameService, price, areaUsing, floorNumber,
                rentalType, otherAmenities, poolArea, numberTenants, idService);

        serviceManager = new VillaManagement();
        serviceManager.addService(newVilla);

    }

    private static void addNewHouse() {
        var nameService = getNameService();

        var price = getPriceService();

        var areaUsing = getAreaUsing();

        RentalType rentalType = getRentalType();

        String otherAmenities = getOtherAmenities();

        int numberTenants = getNumberTenants();

        boolean isValid;
        // floor number
        int floorNumber;
        do {
            System.out.println("floor number :");
            floorNumber = Integer.parseInt(scannerService.nextLine());
            if (!ServiceValidator.validateFloorNumber(floorNumber)) {
                System.out.println("floor number must be greater than 0");
                isValid = false;
            } else isValid = true;
        } while (!isValid);

        //id house
        String idService;
        do {
            System.out.println("ID service : ");
            idService = scannerService.nextLine();
            if (!ServiceValidator.validateIdHouse(idService)) {
                System.out.println("ID house must be in format SVHO-XXXX");
                isValid = false;
            } else isValid = true;
        } while (!isValid);

        House newHouse = new House(nameService, price, areaUsing,
                numberTenants, rentalType, otherAmenities, floorNumber, idService);

        serviceManager = new HouseManagement();
        serviceManager.addService(newHouse);
    }

    private static void addNewRoom() {
        var nameService = getNameService();

        var price = getPriceService();

        var areaUsing = getAreaUsing();

        RentalType rentalType = getRentalType();

        String otherAmenities = getOtherAmenities();

        int numberTenants = getNumberTenants();

        // choosing type of room
        System.out.println("Types of room");
        System.out.println("1. Vip");
        System.out.println("2. Luxurious");
        System.out.println("3. Standard");
        System.out.println("4. President");
        System.out.println("5. Single");
        System.out.println("6. Double");
        System.out.println("Your choice :");
        var roomType = RoomType.STANDARD;
        var choice = Integer.parseInt(scannerService.nextLine());
        switch (choice) {
            case 1:
                roomType = RoomType.VIP;
                break;
            case 2:
                roomType = RoomType.LUXURIOUS;
                break;
            case 3:
                roomType = RoomType.STANDARD;
                break;
            case 4:
                roomType = RoomType.PRESIDENT;
                break;
            case 5:
                roomType = RoomType.SINGLE;
                break;
            case 6:
                roomType = RoomType.DOUBLE;
                break;
            default:
                System.out.println("Invalid input");

        }

        //id room
        boolean isValid;
        String idService;
        do {
            System.out.println("ID service : ");
            idService = scannerService.nextLine();
            if (!ServiceValidator.validateIdRoom(idService)) {
                System.out.println("ID house must be in format SVRO-XXXX");
                isValid = false;
            } else isValid = true;
        } while (!isValid);

        Room newRoom = new Room(nameService, price, areaUsing, rentalType,
                otherAmenities, idService, numberTenants, roomType);

        serviceManager = new RoomManagement();
        serviceManager.addService(newRoom);
    }

    private static int getNumberTenants() {
        boolean isValid;
        int numberTenants;
        do {
            System.out.println("Number of tenants  : ");
            numberTenants = Integer.parseInt(scannerService.nextLine());
            if (!ServiceValidator.validateNumberTenants(numberTenants)) {
                System.out.println("number of tenants must be greater than 0 and smaller than 20 !");
                isValid = false;
            } else isValid = true;
        } while (!isValid);

        return numberTenants;
    }

    private static String getOtherAmenities() {
        System.out.println("Other amenities : ");
        return scannerService.nextLine();
    }

    private static RentalType getRentalType() {
        RentalType rentalType = RentalType.BY_DAY;
        showMenuRentalType();
        var input = Integer.parseInt(scannerService.nextLine());
        switch (input) {
            case 1:
                rentalType = RentalType.BY_HOUR;
                break;
            case 2:
                rentalType = RentalType.BY_DAY;
                break;
            case 3:
                rentalType = RentalType.BY_MONTH;
                break;
            case 4:
                rentalType = RentalType.BY_YEAR;
                break;
            default:
                System.out.println("Invalid input");
        }
        return rentalType;
    }

    private static int getAreaUsing() {
        boolean isValid;
        int areaUsing;
        do {
            System.out.println("areaUsing : ");
            areaUsing = Integer.parseInt(scannerService.nextLine());
            if (!ServiceValidator.validateArea(areaUsing)) {
                System.out.println("Area must be greater than 30");
                isValid = false;
            } else isValid = true;
        } while (!isValid);

        return areaUsing;
    }

    private static Double getPriceService() {
        boolean isValid;
        double price;
        do {
            System.out.println("price: ");
            price = Double.parseDouble(scannerService.nextLine());
            if (!ServiceValidator.validatePrice(price)) {
                System.out.println("Price must be greater than 0, try again !");
                isValid = false;
            } else isValid = true;
        } while (!isValid);

        return price;
    }

    private static String getNameService() {
        boolean isValid;
        String nameService;
        do {
            System.out.println("name: ");
            nameService = scannerService.nextLine();
            if (!ServiceValidator.validateServiceName(nameService)) {
                System.out.println("Only the first letter must be uppercase, try again !");
                isValid = false;
            } else isValid = true;
        } while (!isValid);

        return nameService;
    }

    // showing rental services
    public static void showServices() {
        displayMenuShowing();
        var choice = -1;
        while (true) {
            choice = Integer.parseInt(scannerService.nextLine());
            switch (choice) {
                case 1:
                    showAllVilla();
                    displayMenuShowing();
                    break;
                case 2:
                    showAllHouse();
                    displayMenuShowing();
                    break;
                case 3:
                    showAllRoom();
                    displayMenuShowing();
                    break;
                case 4:
                    showAllVillaNotDuplicate();
                    displayMenuShowing();
                    break;
                case 5:
                    showAllHouseNotDuplicate();
                    displayMenuShowing();
                    break;
                case 6:
                    showAllRoomNotDuplicate();
                    displayMenuShowing();
                    break;
                case 7:
                    MainController.main(new String[]{});
                    break;
                case 8:
                    System.exit(1);
                default:
                    System.out.println("Invalid input");
                    displayMenuShowing();
            }
        }
    }

    private static void displayMenuShowing() {
        System.out.println("--------------------------------------");
        System.out.println("1. Show all Villa");
        System.out.println("2. Show all House");
        System.out.println("3. Show all room");
        System.out.println("4. Show all name Villa not duplicate");
        System.out.println("5. Show all name House not duplicate");
        System.out.println("6. Show all name Room not duplicate");
        System.out.println("7. Back to menu");
        System.out.println("8. Exit");
        System.out.println("Your choice : ");
    }

    private static void showAllVilla() {
        serviceManager = new VillaManagement();
        serviceManager.showInfoService();
    }

    private static void showAllHouse() {
        serviceManager = new HouseManagement();
        serviceManager.showInfoService();
    }

    private static void showAllRoom() {
        serviceManager = new RoomManagement();
        serviceManager.showInfoService();
    }

    private static void showAllVillaNotDuplicate() {
        serviceManager = new VillaManagement();
        serviceManager.showInfoServiceNotDuplicate();
    }

    private static void showAllHouseNotDuplicate() {
        serviceManager = new HouseManagement();
        serviceManager.showInfoServiceNotDuplicate();
    }

    private static void showAllRoomNotDuplicate() {
        serviceManager = new RoomManagement();
        serviceManager.showInfoServiceNotDuplicate();
    }


}
