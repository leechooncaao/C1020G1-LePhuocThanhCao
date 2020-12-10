package io_textfile.bai_tap.copy_file_text;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, FileAlreadyExistsException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of source file : ");
        var source = scanner.nextLine();
        System.out.println("Enter the name of target file : ");
        var target = scanner.nextLine();

        scanner.close();

        var pathSource = "src/io_textfile/bai_tap/copy_file_text/" + source;
        var pathTarget = "src/io_textfile/bai_tap/copy_file_text/" + target;

        File sourceFile = new File(pathSource);
        if (!sourceFile.exists())
            throw new FileNotFoundException("Source file does not exist !");

        File targetFile = new File(pathTarget);
        if (targetFile.exists())
            throw new FileAlreadyExistsException(pathTarget);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathSource));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFile))) {

            int ch;
            int count = 0;
            while ((ch = bufferedReader.read()) != -1) {
                bufferedWriter.write(ch);
                count++;
            }

            bufferedWriter.write("\nNumber of characters in file : " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
