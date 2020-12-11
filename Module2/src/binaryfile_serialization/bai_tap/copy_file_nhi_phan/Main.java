package binaryfile_serialization.bai_tap.copy_file_nhi_phan;

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
        var rootPath = "src/binaryfile_serialization/bai_tap/copy_file_nhi_phan/";
        var pathSource = rootPath + source;
        var pathTarget = rootPath + target;

        File sourceFile = new File(pathSource);
        if (!sourceFile.exists())
            throw new FileNotFoundException("Source file does not exist !");

        File targetFile = new File(pathTarget);
        if (targetFile.exists())
            throw new FileAlreadyExistsException(pathTarget);

        try (BufferedInputStream bufferReader = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bufferWriter = new BufferedOutputStream(new FileOutputStream(targetFile))) {

            int ch;
            int count = 0;
            while ((ch = bufferReader.read()) != -1) {
                bufferWriter.write(ch);
                count++;
            }

            String counter = "\nThe number of byte in file : " + count;

            bufferWriter.write(counter.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
