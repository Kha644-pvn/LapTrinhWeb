import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
        throws ServletException, IOException {
        
        resp.setContentType("text/html");
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        if(user.equals("trung") && pass.equals("123")) {
            Cookie cookie = new Cookie("username", user);
            cookie.setMaxAge(30); // cookie tồn tại 30s
            resp.addCookie(cookie);

            resp.sendRedirect("hello");
        } else {
            resp.sendRedirect("login.html");
        }
    }
}
