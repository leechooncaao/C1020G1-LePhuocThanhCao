package thuattoantimkiem.bai_tap.chuoi_tangdan_lonnhat;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word : ");
        var input = scanner.nextLine();


        // input : w e l c o m e -> output : elo, co -> elo
        //             C A
        // if C < A -> list.add(C,A)
        // C = A; A++

        Map<String,Integer> map = new HashMap<>();
        var ch = input.toCharArray();
        for(int i = 0; i < ch.length; i++){
            StringBuilder builder = new StringBuilder();
            builder.append(ch[i]);
            var count = 1;

            for(int j = i; j < ch.length; j++){
                var lastElement = builder.toString().charAt(builder.length() -1);
                if(ch[j] > lastElement){
                    builder.append(ch[j]);
                    count++;
                }
            }

            map.put(builder.toString(), count);
        }

        Map.Entry<String, Integer> entryWithMaxValue = null;

        for(Map.Entry<String, Integer> currentEntry : map.entrySet()){
            if(entryWithMaxValue == null || currentEntry.getValue() > entryWithMaxValue.getValue())
                entryWithMaxValue = currentEntry;
        }

        System.out.println(entryWithMaxValue.getKey());

        scanner.close();

        // O(n^2) :  (have 2 loops)
    }
}
