package controller;

import model.bean.Employee;
import model.service.IService;
import model.service.serviceManipulators.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employeeServlet")
public class EmployeeServlet extends HttpServlet {
    private IService<Employee> employeeService = new EmployeeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null)
            action = "";

        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
            default:
                showListEmployee(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null)
            action = "";

        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "sortByName":
                sortByName(request, response);
                break;
            default:
                showListEmployee(request, response);
                break;
        }
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Employee> listEmployee = employeeService.findAll();

            request.setAttribute("listEmployee", listEmployee);
            request.getRequestDispatcher("employee/listEmployee.jsp").forward(request, response);
        } catch (ServletException | IOException | SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("employee/registerEmployee.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        Double salary = Double.valueOf(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String position = request.getParameter("position");
        String degree = request.getParameter("degree");
        String division = request.getParameter("division");
        String userName = request.getParameter("username");

        Employee employee = new Employee(name,birthday,idCard,salary,phone,email,address,position,degree,division,userName);

        try {
            String message = employeeService.add(employee);
            if(message.equals("OK"))
                showListEmployee(request,response);
            else {
                request.setAttribute("message",message);
                request.setAttribute("employee",employee);
                request.getRequestDispatcher("employee/registerEmployee.jsp").forward(request,response);
            }
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            Employee employee = employeeService.findById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("employee/editEmployee.jsp").forward(request, response);
        } catch (ServletException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            var employee = employeeService.findById(Integer.parseInt(request.getParameter("id")));
            String name = request.getParameter("name");
            String birthday = request.getParameter("birthday");
            String idCard = request.getParameter("idCard");
            Double salary = Double.valueOf(request.getParameter("salary"));
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String position = request.getParameter("position");
            String degree = request.getParameter("degree");
            String division = request.getParameter("division");
            String userName = request.getParameter("username");

            employee.setName(name);
            employee.setBirthday(birthday);
            employee.setIdCard(idCard);
            employee.setSalary(salary);
            employee.setPhone(phone);
            employee.setEmail(email);
            employee.setAddress(address);
            employee.setPosition(position);
            employee.setDegree(degree);
            employee.setDivision(division);
            employee.setUserName(userName);

            String message = employeeService.update(employee);
            if(message.equals("OK"))
                showListEmployee(request,response);
            else {
                request.setAttribute("message",message);
                request.setAttribute("employee",employee);
                request.getRequestDispatcher("employee/editEmployee.jsp").forward(request,response);
            }

        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            employeeService.deleteById(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        showListEmployee(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        var name = request.getParameter("search-data");
        try {
            List<Employee> searchList =  employeeService.searchByName(name);
            if(searchList.isEmpty())
                request.getRequestDispatcher("notFound.jsp").forward(request,response);
            else {
                request.setAttribute("listEmployee", searchList);
                request.getRequestDispatcher("employee/listEmployee.jsp").forward(request,response);
            }
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            var sortedList = userService.sortByName();
//            request.setAttribute("listUser", sortedList);
//            request.getRequestDispatcher("user/trialList.jsp").forward(request,response);
//        } catch (SQLException | IOException | ServletException throwables) {
//            throwables.printStackTrace();
//        }
    }
}
