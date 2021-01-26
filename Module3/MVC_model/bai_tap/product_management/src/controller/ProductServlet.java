package controller;

import model.bean.Product;
import model.service.ProductService;
import model.service.impl.ProductServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = {"", "/productServlet"})
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null)
            action = "";

        switch (action) {
            case "update":
                update(request, response);
                break;
            case "create":
                createProduct(request,response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null)
            action = "";

        switch (action) {
            case "update":
                showUpdateForm(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "create":
                showCreateForm(request, response);
                break;
            case "showDetailInfo":
                showDetailProduct(request,response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var listProduct = productService.findAll();

        request.setAttribute("productListFromServlet", listProduct);
        request.getRequestDispatcher("product_pages/home_page.jsp").forward(request,response);

    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        var product = productService.findById(id);

        request.setAttribute("productInfo", product);
        var dispatcher = request.getRequestDispatcher("/product_pages/product_update.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");

        var product = productService.findById(id);

        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setProducer(producer);
        productService.updateById(id,product);

        showList(request,response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));

        productService.deleteById(id);

        showList(request,response);
    }

    private void showDetailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        var detailProduct = productService.findById(id);

        request.setAttribute("detailProduct", detailProduct );
        request.getRequestDispatcher("product_pages/product_detail.jsp").forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("product_pages/product_create.jsp").forward(request,response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        Integer id = productService.findAll().size() + 1;

        var newProduct = new Product(id,name,price,description,producer);

        productService.create(newProduct);

        showList(request,response);
    }
}
