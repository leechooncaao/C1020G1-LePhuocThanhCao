package mangVaPhuongThuc.thuc_hanh;

import java.util.Scanner;

public class SearchInArray {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna",
                            "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a student's name : ");
        var input = scanner.nextLine();

        boolean isExist = false;
        for(int i = 0; i < students.length; i++){
            if(students[i].equals(input)){
                System.out.println("The student is at position " + i + " in the list");
                isExist = true;
                break;
            }
        }

        if(!isExist)
            System.out.println("Not found !");
    }
}
