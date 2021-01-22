import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var userName = request.getParameter("username");
        var password = request.getParameter("password");

        var writer = response.getWriter();
        writer.println("<html>");

        if (userName.equals("admin") && password.equals("admin"))
            writer.println("<h1>Welcome " + userName + " to website</h1>");
        else writer.println("<h1>Login Error</h1>");

        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
