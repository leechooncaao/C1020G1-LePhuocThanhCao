package xulingoaile_debug.bai_tap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter side1 : ");
        var side1 = scanner.nextInt();
        System.out.println("Enter side2 : ");
        var side2 = scanner.nextInt();
        System.out.println("Enter side3 : ");
        var side3 = scanner.nextInt();

        try{
            var triangle = new Triangle(side1,side2,side3);
            System.out.println(triangle);
        } catch (IllegalTriangleException e) {
            System.out.println("Invalid input !");
            e.printStackTrace();
        }


    }

}
