package lopvadoituong.bai_tap;

import java.util.Scanner;

public class QuandraticEquation {
    private int a, b, c;

    public QuandraticEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private double getDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    private double getRoot1() {
        var delta = getDiscriminant();
        return (b * (-1) + Math.sqrt(delta)) / (2 * a);
    }

    private double getRoot2() {
        var delta = getDiscriminant();
        return (b * (-1) - Math.sqrt(delta)) / (2 * a);
    }

    public void getRoots(){
        var delta = getDiscriminant();

        if(delta < 0)
            System.out.println("The equation has no root !");
        else if(delta == 0)
            System.out.println("The equation has 1 double-root : " + getRoot1());
        else
            System.out.println("The equation has 2 roots : " + getRoot1() + " and " + getRoot2());
    }

    // test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a,b,c : ");
        var a = scanner.nextInt();
        var b = scanner.nextInt();
        var c = scanner.nextInt();

        var equation = new QuandraticEquation(a, b, c);

        equation.getRoots();
    }
}
