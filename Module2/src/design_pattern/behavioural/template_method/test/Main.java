package design_pattern.behavioural.template_method.test;

import design_pattern.behavioural.template_method.GenerateReportTask;
import design_pattern.behavioural.template_method.Task;
import design_pattern.behavioural.template_method.TransferMoneyTask;

public class Main {
    public static void main(String[] args) {
        Task task1 = new TransferMoneyTask();
        task1.execute();
        System.out.println();
        Task task2 = new GenerateReportTask();
        task2.execute();

        task2.execute();
    }
}
