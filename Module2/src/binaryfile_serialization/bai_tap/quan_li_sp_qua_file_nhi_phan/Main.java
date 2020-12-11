package binaryfile_serialization.bai_tap.quan_li_sp_qua_file_nhi_phan;

import java.io.EOFException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ProductManagement products = new ProductManagement();

    private static void displayAll() {
        products.display();
    }

    private static void searchProduct() {
        System.out.print("Enter the id : " + "\n");
        var id = Integer.parseInt(scanner.nextLine());

        var product = products.searchById(id);
        System.out.println(product);
    }

    private static void addProduct(){
        System.out.print("The name of product : " + "\n");
        var name = scanner.nextLine();
        System.out.print("ID : " + "\n");
        var id = Integer.parseInt(scanner.nextLine());
        System.out.print("Price : " + "\n");
        var price = Double.parseDouble(scanner.nextLine());
        System.out.println("Description : ");
        var desc = scanner.nextLine();

        products.add(new Product(name, id, price, desc));
    }

    private static void showMenu() {
        System.out.println("1. Add new product");
        System.out.println("2. Search product by id");
        System.out.println("3. Display all products");
        System.out.println("4. Exit");
    }

    public static void main(String[] args){

        products.add(new Product("apple",1,1000,"red"));
        products.add(new Product("oppo",2,3000,"blue"));
        products.add(new Product("sony",4,1500,"new 99%"));
        products.add(new Product("samsung",5,2000,"nothing"));
        products.add(new Product("xiaomi",3,700,"nothing"));
        products.add(new Product("xiaomi",10,800,"version2"));

        showMenu();

        while (true) {
            System.out.print("Your choice : ");
            var choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    searchProduct();
                    break;
                case 3:
                    displayAll();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
            }
        }

    }
}
