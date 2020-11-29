import java.util.Scanner;

public class PrintShapes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        showMenu();

        var choice = -1;
        while (choice != 4) {
            System.out.println("Your choice : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the width : ");
                    var width = scanner.nextInt();

                    System.out.println("Enter the height : ");
                    var heightRec = scanner.nextInt();

                    printRect(width, heightRec);

                    break;
                case 2:
                    System.out.println("Enter the edge : ");
                    var edge = scanner.nextInt();

                    System.out.println("Enter position of square corner : \n 1. top-left \n " +
                            "2. top-right \n 3. bottom-left \n 4. bottom-right");
                    var positionCorner = scanner.nextInt();

                    printSquareTriangle(edge, positionCorner);

                    break;
                case 3:
                    System.out.println("Enter the bottom edge (only odd number !) :");
                    var bottomEdge = scanner.nextInt();
                    if(bottomEdge % 2 == 0){
                        System.out.println("Invalid input");
                        break;
                    }

                    printIsoscelesTriangle(bottomEdge);

                    break;
                default:
                    System.out.println("No choice !");
            }
        }

        scanner.close();


    }

    public static void showMenu() {
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
    }

    public static void printRect(int width, int height) {
        for (int row = 1; row <= height; row++) {
            for (int col = 1; col <= width; col++)
                System.out.print("* ");

            System.out.println();
        }
    }

    public static void printSquareTriangle(int edge, int positionCorner) {
        switch (positionCorner) {
            // top - left
            case 1:
                for (int i = edge; i >= 1; i--) {
                    for (int j = 1; j <= i; j++)
                        System.out.print("* ");

                    System.out.println();
                }

                break;
            // top - right
            case 2:
                for (int i = edge; i >= 1; i--) {
                    // print spaces
                    for (int j = 1; j <= edge - i; j++)
                        System.out.print("  ");

                    // print *
                    for (int k = 1; k <= i; k++)
                        System.out.print("* ");

                    System.out.println();
                }

                break;

            // bottom - left
            case 3:
                for (int i = 1; i <= edge; i++) {
                    for (int j = 1; j <= i; j++)
                        System.out.print("* ");

                    System.out.println();
                }

                break;

            //bottom - right
            case 4:
                for (int i = 1; i <= edge; i++) {
                    //print spaces
                    for (int j = 1; j <= edge - i; j++)
                        System.out.print("  ");

                    // print *
                    for (int k = 1; k <= i; k++)
                        System.out.print("* ");

                    System.out.println();
                }

                break;
            default:
                System.out.println("Invalid position !");
        }
    }

    public static void printIsoscelesTriangle(int bottomEdge) {
        int mid = bottomEdge / 2 + 1;

        // print the upper triangle
        for(int i = 1; i < mid; i++){
            for(int j = 1; j <= i; j++)
                System.out.print("* ");

            System.out.println();
        }

        // print the middle line
        for(int k = 1; k <= mid; k++)
            System.out.print("* ");

        System.out.println();

        // print the lower triangle
        for(int m = mid - 1; m >= 1; m--){
            for(int n = 1; n <= m; n++)
                System.out.print("* ");

            System.out.println();
        }
    }

}
