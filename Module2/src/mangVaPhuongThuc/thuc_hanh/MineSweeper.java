package mangVaPhuongThuc.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class MineSweeper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a size of map : ");
        var size = scanner.nextInt();

        char[][] map = new char[size][size];
        for (int i = 0; i < size; i++)
            Arrays.fill(map[i], '.');

        showMap(map);

        // creating random mines "*" in map
        var numberMine = (int) (Math.random() * size); // maximum "size" mines in map
        int rowRandom;
        int colRandom;
        while (numberMine > 0) {
            // create random coordinates in map to store "*"
            rowRandom = (int) (Math.random() * (size - 1));
            colRandom = (int) (Math.random() * (size - 1));

            map[rowRandom][colRandom] = '*';
            numberMine--;
        }

        boolean check = true;
        int x;
        int y;
        while (check){
            // Entering choices of player
            System.out.println("Your choice in position (sequentially x and y coordinates) : ");
            x = scanner.nextInt();
            y = scanner.nextInt();

            // check if in that position has mine or not
            if(map[x][y] == '*'){
                check = false;
                System.out.println("You lose !");
            }else {
                map[x][y] = (char) (Math.random()*9);
            }

            showMap(map);

        }




    }

    public static void showMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++)
                System.out.print(map[i][j] + " ");

            System.out.println();
        }

        System.out.println();
    }

}
