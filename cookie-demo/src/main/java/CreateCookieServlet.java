import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@WebServlet("/createcookie")
public class CreateCookie extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        String ten = request.getParameter("ten");
        String holot = request.getParameter("holot");

        // Tạo cookie
        Cookie firstName = new Cookie("ten", ten);
        Cookie lastName = new Cookie("holot", holot);

        // Hạn 24h
        firstName.setMaxAge(60*60*24);
        lastName.setMaxAge(60*60*24);

        // Thêm cookie vào response
        response.addCookie(firstName);
        response.addCookie(lastName);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<h2>Cookie Created!</h2>");
        out.println("<p>First Name: " + ten + " - Last Name: " + holot + "</p>");
    }
}
