package test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        var result = random.ints(0,5).limit(10).sorted().toArray();
        for(var e : result)
            System.out.println(e);
    }
}
