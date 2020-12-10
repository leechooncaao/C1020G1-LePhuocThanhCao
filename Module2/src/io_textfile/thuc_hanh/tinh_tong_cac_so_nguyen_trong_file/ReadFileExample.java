package io_textfile.thuc_hanh.tinh_tong_cac_so_nguyen_trong_file;

import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of file : ");
        var fileName = scanner.nextLine();
        var filePath = "src/io_textfile/thuc_hanh/tinh_tong_cac_so_nguyen_trong_file/" + fileName;

        scanner.close();

        countSumInFile(filePath);
    }

    private static void countSumInFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if(!file.exists())
            throw new FileNotFoundException();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

            String line;
            int sum = 0;
            while ((line = reader.readLine()) != null){
                sum += Integer.parseInt(line);
            }

            System.out.println("Sum= " + sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private static File createFile(String fileName){
//        String filePath = "src/io_textfile/thuc_hanh/tinh_tong_cac_so_nguyen_trong_file/" + fileName;
//        File file = new File(filePath);
//
//        if(!file.exists())
//    }
}
