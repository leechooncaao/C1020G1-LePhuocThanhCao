import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/display-discount")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var desc = request.getParameter("description");
        var price = Float.parseFloat(request.getParameter("price"));
        var discount = Integer.parseInt(request.getParameter("discount"));

        var discount_amount = discount * price * 0.01;
        var discount_price = price - discount_amount;

        var writer = response.getWriter();

        writer.println("<html>");
        writer.println("<h3>Product : " + desc + "</h3>");
        writer.println("<h3>Price before discount : " + price + "</h3>");
        writer.println("<h3>Price after discount : " + discount_price + "</h3>");
        writer.println("</html>");
    }
}
