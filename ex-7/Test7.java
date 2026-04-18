import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Test extends HttpServlet
{
    public void doGet(HttpServletRequest r, HttpServletResponse rs) throws IOException, ServletException
    {
        rs.setContentType("text/html");
        PrintWriter out = rs.getWriter();
        String username = r.getParameter("username");
        String password = r.getParameter("password");
        out.println("<html><body>");
        // Simple validation
        if("admin".equals(username) && "1234".equals(password))
        {
            // Create / get session
            HttpSession session = r.getSession();
            Integer count = (Integer) session.getAttribute("count");
            if(count == null)
            {
                count = 1; // first login
            }
            else
            {
                count = count + 1; // increment
            }
            session.setAttribute("count", count);
            out.println("<h2>Welcome, " + username + "</h2>");
            out.println("<h3>Login Count: " + count + "</h3>");
        }
        else
        {
            out.println("<h3>Invalid Username or Password</h3>");
        }
        out.println("</body></html>");
        out.close();
    }
}
