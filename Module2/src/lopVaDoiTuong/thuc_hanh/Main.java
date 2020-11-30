package lopVaDoiTuong.thuc_hanh;

import lopVaDoiTuong.bai_tap.QuandraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the width and the height of rectangle sequentially : ");
        var width = scanner.nextDouble();
        var height = scanner.nextDouble();

        var rectangle = new Rectangle(width,height);

        System.out.println("Your Rectangle \n"+ rectangle.display());
        System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+ rectangle.getArea());


    }
}
