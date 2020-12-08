package javacollectionframework.bai_tap.arraylistvslinkedlist;

import java.util.Scanner;

public class Main {
//    private static ProductManagerByArrayList products = new ProductManagerByArrayList();
    private static ProductManagerByLinkedList products = new ProductManagerByLinkedList();
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("-------MENU---------");
        System.out.println("1. Add New Product");
        System.out.println("2. Edit Product By ID");
        System.out.println("3. Remove Product By ID");
        System.out.println("4. Display All Products");
        System.out.println("5. Search Product By Name");
        System.out.println("6. Sort By Ascending Order");
        System.out.println("7. Sort By Descending Order");
        System.out.println("8. Exit");
        System.out.println("Your choice : ");
    }

    public static void searchProduct() {
        System.out.println("Enter name of product : ");
        var name = scanner.nextLine();
        var product = products.searchByName(name);
        System.out.println(product);
    }

    public static void sortByAscending() {
        products.sortByAscending();
        displayAll();
    }

    public static void sortByDescending() {
        products.sortByDescending();
        displayAll();
    }

    public static void displayAll() {
        products.display();
    }

    public static void removeProduct() {
        System.out.println("Enter ID : ");
        var id = Integer.parseInt(scanner.nextLine());
        products.delete(id);
        displayAll();
    }

    public static void editProduct() {
        System.out.println("Enter ID : ");
        var id = Integer.parseInt(scanner.nextLine());
        products.edit(id,scanner);
        displayAll();
    }

    public static void addProduct() {
        System.out.println("Enter name of product :");
        var name = scanner.nextLine();
        System.out.println("Enter id : ");
        var id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter price of product : ");
        var price = Double.parseDouble(scanner.nextLine());

        Product product = new Product(name, id, price);
        products.add(product);
    }

    public static void main(String[] args) {

        int choice = -1;
        while (choice != 8) {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    displayAll();
                    break;
                case 5:
                    searchProduct();
                    break;
                case 6:
                    sortByAscending();
                    break;
                case 7:
                    sortByDescending();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
            }
        }

        scanner.close();

    }
}
