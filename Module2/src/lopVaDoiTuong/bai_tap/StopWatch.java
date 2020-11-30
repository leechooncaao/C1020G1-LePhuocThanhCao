package lopVaDoiTuong.bai_tap;

import java.util.Date;
import java.util.Scanner;

public class StopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public StopWatch() {
//        startTime = System.currentTimeMillis();
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return (endTime - startTime);
    }

    public void countTimeProcess() {
        var result = algorithm();
        System.out.println("time implementation of algorithm : " + getElapsedTime() + " milliseconds ; sum = " + result);
    }

    private long algorithm() {
        start();
        long sum = 0;
        for (long i = 1; i <= 100000000L; i++) {
            if (i % 2 == 0)
                sum += i;
        }

        stop();
        return sum;
    }

    // test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var elapsed = new StopWatch();

//        System.out.println("1. Start");
//        System.out.println("2. Stop");
//        System.out.println("3. Exit");
//        System.out.println("Your choice : ");
//
//        int choice = 0;
//        while (choice != 3) {
//
//            choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    elapsed.start();
//                    break;
//                case 2:
//                    elapsed.stop();
//                    System.out.println("The elapsed time : " + elapsed.getElapsedTime() + " milliseconds");
//                    break;
//                case 3:
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid input !");
//            }
//        }


        elapsed.countTimeProcess();
    }
}
