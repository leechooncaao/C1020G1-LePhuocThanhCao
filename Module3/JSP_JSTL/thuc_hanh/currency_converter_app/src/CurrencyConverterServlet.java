import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CurrencyConverterServlet", urlPatterns = "/converter")
public class CurrencyConverterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));

        var res = rate * usd;

        request.setAttribute("result", res);
        request.setAttribute("rate", rate);
        request.setAttribute("usd", usd);
        request.getRequestDispatcher("converter.jsp").forward(request,response);
    }
}
