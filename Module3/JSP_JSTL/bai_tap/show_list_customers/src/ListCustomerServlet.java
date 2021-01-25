import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListCustomerServlet", urlPatterns = {"","/showList"})
public class ListCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();

        customerList.add(new Customer("Mai Văn Hoàn", "13-12-1995","Huế", "/images/pic_1.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam", "21-08-1983","Đà Nẵng", "/images/pic_2.jpg"));
        customerList.add(new Customer("Nguyễn Thái Hòa", "17-12-2001","Quảng Trị", "/images/pic_3.png"));
        customerList.add(new Customer("Trần Đăng Khoa", "22-11-1999","Quảng Nam", "/images/pic_4.jpg"));
        customerList.add(new Customer("Nguyễn Đình Thi", "04-05-1997","Vinh", "/images/pic_5.jpg"));

        request.setAttribute("listCustomer", customerList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
