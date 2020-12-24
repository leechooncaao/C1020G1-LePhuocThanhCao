package managements;

import managements.person_management.EmployeeManagement;
import models.person.Employee;

import java.util.Scanner;
import java.util.Stack;

public class DocumentEmployee {
    private final Stack<Employee> stack;

    public DocumentEmployee() {
        var employeeManager = new EmployeeManagement();
        stack = employeeManager.createDocument();
    }

    public void searchEmployeeById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of employee : ");
        var idEmployee = scanner.nextLine();

        Employee searchingEmployee = null;
        var iterator = stack.stream().iterator();
        while (iterator.hasNext()){
            var employee = iterator.next();
            if(employee.getIdEmployee().equals(idEmployee)){
                searchingEmployee = employee;
                break;
            }
        }

        if(searchingEmployee == null)
            System.out.println("Not found !");
        else
            System.out.println(searchingEmployee);

    }
}
