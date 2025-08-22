import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@WebServlet({"/hello","/xin-chao"})
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
        throws ServletException, IOException {
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = "";
        Cookie[] cookies = req.getCookies();
        if(cookies != null) {
            for(Cookie c : cookies) {
                if(c.getName().equals("username")) {
                    name = c.getValue();
                }
            }
        }

        if(name.equals("")) {
            resp.sendRedirect("login.html");
        } else {
            out.println("Xin chào " + name);
        }
    }
}
