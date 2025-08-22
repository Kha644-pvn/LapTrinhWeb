import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@WebServlet("/deletecookie")
public class DeleteCookie extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("ten")) {   // ví dụ xóa cookie "ten"
                    c.setMaxAge(0); // xóa cookie
                    response.addCookie(c);
                    out.println("Deleted cookie: " + c.getName() + "<br/>");
                }
            }
        }
    }
}
