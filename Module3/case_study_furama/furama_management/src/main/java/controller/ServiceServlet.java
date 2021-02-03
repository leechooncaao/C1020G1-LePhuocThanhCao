package controller;

import model.bean.Employee;
import model.bean.Service;
import model.service.IService;
import model.service.serviceManipulators.SerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/serviceServlet")
public class ServiceServlet extends HttpServlet {
    private IService<Service> serService = new SerService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null)
            action = "";

        switch (action) {
            case "create":
                createService(request, response);
                break;
            case "edit":
                editService(request, response);
                break;
            default:
                showListService(request, response);
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
                deleteService(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "sortByName":
                sortByName(request, response);
                break;
            default:
                showListService(request, response);
                break;
        }
    }

    private void showListService(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Service> listService = serService.findAll();

            request.setAttribute("listService", listService);
            request.getRequestDispatcher("service/listService.jsp").forward(request, response);
        } catch (ServletException | IOException | SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("service/registerService.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        Double cost = Double.valueOf(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        String rentType = request.getParameter("rentType");
        String serviceType = request.getParameter("serviceType");
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        Double poolArea = Double.valueOf(request.getParameter("poolArea"));
        int numberFloor = Integer.parseInt(request.getParameter("numberFloor"));

        var service = new Service(name,area,cost,maxPeople,rentType,serviceType,standardRoom,description,poolArea,numberFloor);

        try {
            String message = serService.add(service);
            if(message.equals("OK"))
                showListService(request,response);
            else {
                request.setAttribute("message",message);
                request.setAttribute("service",service);
                request.getRequestDispatcher("service/registerService.jsp").forward(request,response);
            }
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            Service service = serService.findById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("service", service);
            request.getRequestDispatcher("service/editService.jsp").forward(request, response);
        } catch (ServletException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void editService(HttpServletRequest request, HttpServletResponse response) {
        try {
            var service = serService.findById(Integer.parseInt(request.getParameter("id")));
            String name = request.getParameter("service_name");
            int area = Integer.parseInt(request.getParameter("service_area"));
            Double cost = Double.valueOf(request.getParameter("service_cost"));
            int maxPeople = Integer.parseInt(request.getParameter("service_max_people"));
            String rentType = request.getParameter("rent_type_name");
            String serviceType = request.getParameter("service_type_name");
            String standardRoom = request.getParameter("standard_room");
            String description = request.getParameter("description_other_convenience");
            Double poolArea = Double.valueOf(request.getParameter("pool_area"));
            int numberFloor = Integer.parseInt(request.getParameter("number_of_floors"));

            service.setName(name);
            service.setArea(area);
            service.setCost(cost);
            service.setMaxPeople(maxPeople);
            service.setRentType(rentType);
            service.setServiceType(serviceType);
            service.setStandardRoom(standardRoom);
            service.setDescription(description);
            service.setPoolArea(poolArea);
            service.setNumberFloor(numberFloor);

            String message = serService.update(service);
            if(message.equals("OK"))
                showListService(request,response);
            else {
                request.setAttribute("message",message);
                request.setAttribute("service",service);
                request.getRequestDispatcher("service/editService.jsp").forward(request,response);
            }

        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) {
        try {
            serService.deleteById(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        showListService(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        var name = request.getParameter("search-data");
        try {
            List<Service> searchList =  serService.searchByName(name);
            if(searchList.isEmpty())
                request.getRequestDispatcher("notFound.jsp").forward(request,response);
            else {
                request.setAttribute("listService", searchList);
                request.getRequestDispatcher("service/listService.jsp").forward(request,response);
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
