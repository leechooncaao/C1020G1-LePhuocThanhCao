package controller;

import model.bean.Customer;
import model.service.IService;
import model.service.serviceManipulators.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customerServlet")
public class CustomerServlet extends HttpServlet {
    IService<Customer> customerService = new CustomerService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null)
            action = "";

        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            default:
                showListCustomer(request, response);
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
                deleteCustomer(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "sortByName":
                sortByName(request, response);
                break;
            default:
                showListCustomer(request, response);
                break;
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Customer> listCustomer = customerService.findAll();

            request.setAttribute("listCustomer", listCustomer);
            request.getRequestDispatcher("customer/listCustomer.jsp").forward(request, response);
        } catch (ServletException | IOException | SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("customer/registerCustomer.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        gender = (gender.equals("1")) ? "Male" : "Female";

        Customer customer = new Customer(code, type,name,birthday,gender,idCard,phone,email,address);

        try {
            String message = customerService.add(customer);
            if(message.equals("OK"))
                showListCustomer(request,response);
            else {
                request.setAttribute("message",message);
                request.setAttribute("customer",customer);
                request.getRequestDispatcher("customer/registerCustomer.jsp").forward(request,response);
            }
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            Customer customer = customerService.findById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("customer/editCustomer.jsp").forward(request, response);
        } catch (ServletException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Customer customer = customerService.findById(id);
            String code = request.getParameter("code");
            String type = request.getParameter("type");
            String name = request.getParameter("name");
            String birthday = request.getParameter("birthday");
            String idCard = request.getParameter("idCard");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");

            gender = (gender.equals("1")) ? "Male" : "Female";

            customer.setCode(code);
            customer.setName(name);
            customer.setBirthday(birthday);
            customer.setGender(gender);
            customer.setIdCard(idCard);
            customer.setEmail(email);
            customer.setAddress(address);
            customer.setPhone(phone);
            customer.setType(type);

            String message = customerService.update(customer);
            if(message.equals("OK"))
                showListCustomer(request,response);
            else {
                request.setAttribute("message",message);
                request.setAttribute("customer",customer);
                request.getRequestDispatcher("customer/editCustomer.jsp").forward(request,response);
            }

        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            customerService.deleteById(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        showListCustomer(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        var name = request.getParameter("search-data");
        try {
            List<Customer> searchList =  customerService.searchByName(name);
            if(searchList.isEmpty())
                request.getRequestDispatcher("notFound.jsp").forward(request,response);
            else {
                request.setAttribute("listCustomer", searchList);
                request.getRequestDispatcher("customer/listCustomer.jsp").forward(request,response);
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
