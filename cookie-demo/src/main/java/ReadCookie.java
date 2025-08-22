import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@WebServlet("/readcookie")
public class ReadCookie extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            out.println("<h2>Found Cookies:</h2>");
            for (Cookie c : cookies) {
                out.println("Name: " + c.getName() + " - Value: " + c.getValue() + "<br/>");
            }
        } else {
            out.println("<h2>No cookies found!</h2>");
        }
    }
}
