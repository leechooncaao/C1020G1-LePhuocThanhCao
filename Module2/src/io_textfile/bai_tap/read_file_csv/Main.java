package io_textfile.bai_tap.read_file_csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(
                new FileReader("src/io_textfile/bai_tap/read_file_csv/country.csv"))){

            String line;
            while ((line = reader.readLine()) != null){
                String[] country = line.split(",");
                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
