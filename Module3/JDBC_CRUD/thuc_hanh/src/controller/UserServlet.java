package controller;

import model.bean.User;
import model.service.IUserService;
import model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"", "/userServlet"})
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null)
            action = "";

        switch (action){
            case "create":
                createUser(request, response);
                break;
            case "edit":
                editUser(request,response);
                break;
            default:
                showListUser(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("action");

        if(action == null)
            action = "";

        switch (action){
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                deleteUser(request,response);
                break;
            case "search":
                search(request,response);
                break;
            case "sortByName":
                sortByName(request,response);
                break;
            default:
                showListUser(request,response);
                break;
        }

    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response){
        try {
            var listUser = userService.selectAllUsers();

            request.setAttribute("listUser", listUser);
            request.getRequestDispatcher("user/trialList.jsp").forward(request,response);
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("user/trialCreate.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User newUser = new User(name,email,country);

        try {
            userService.insertUser(newUser);
            request.getRequestDispatcher("user/trialCreate.jsp").forward(request,response);
        } catch (SQLException | IOException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response){
        try {
            User user = userService.selectUser(Integer.parseInt(request.getParameter("id")));

            request.setAttribute("user",user);
            request.getRequestDispatcher("user/trialEdit.jsp").forward(request,response);
        } catch (ServletException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response){
        try {
            var user = userService.selectUser(Integer.parseInt(request.getParameter("id")));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String country = request.getParameter("country");

            user.setName(name);
            user.setEmail(email);
            user.setCountry(country);

            if(!userService.updateUser(user))
                request.getRequestDispatcher("error.jsp").forward(request,response);
            else
                request.getRequestDispatcher("user/trialEdit.jsp").forward(request,response);
        } catch (SQLException | IOException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }

    private void deleteUser (HttpServletRequest request, HttpServletResponse response){
        try {
            if(!userService.deleteUser(Integer.parseInt(request.getParameter("id"))))
                request.getRequestDispatcher("error.jsp").forward(request,response);
            else
                showListUser(request,response);
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response){
        var country = request.getParameter("search-data");
        try {
            List<User> searchList =  userService.searchByCountry(country);
            if(searchList.isEmpty())
                request.getRequestDispatcher("notFound.jsp").forward(request,response);
            else {
                request.setAttribute("listUser", searchList);
                request.getRequestDispatcher("user/trialList.jsp").forward(request,response);
            }
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response){
        try {
            var sortedList = userService.sortByName();
            request.setAttribute("listUser", sortedList);
            request.getRequestDispatcher("user/trialList.jsp").forward(request,response);
        } catch (SQLException | IOException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }
}
