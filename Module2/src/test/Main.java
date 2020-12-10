package test;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        try (FileWriter fileWriter = new FileWriter("E:\\IT\\C1020G1_Le_Phuoc_Thanh_Cao\\Module2\\src\\test\\output.txt");){
//            String s="Welcome to javaTpoints.";
//            fileWriter.write(s);
//            System.out.println("success...");
//        } catch (Exception e) {
//            System.out.println(e);
//        }


        try (FileReader fileReader = new FileReader("src/test/output.txt");
             BufferedReader bReader = new BufferedReader(fileReader)) {

            String i;
            while ((i = bReader.readLine()) != null) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}