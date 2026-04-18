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
            // Create 4 cookies
            Cookie c1 = new Cookie("Username", username);
            Cookie c2 = new Cookie("Password", password);
            Cookie c3 = new Cookie("Site", "MyWebsite");
            Cookie c4 = new Cookie("Role", "User");
            // Add cookies to response
            rs.addCookie(c1);
            rs.addCookie(c2);
            rs.addCookie(c3);
            rs.addCookie(c4);
            // Get cookies back
            Cookie cookies[] = r.getCookies();
            out.println("<h2>Cookies Stored:</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>Cookie Name</th><th>Cookie Value</th></tr>");
            if(cookies != null)
            {
                for(int i = 0; i < cookies.length; i++)
                {
                    out.println("<tr>");
                    out.println("<td>" + cookies[i].getName() + "</td>");
                    out.println("<td>" + cookies[i].getValue() + "</td>");
                    out.println("</tr>");
                }
            }

            out.println("</table>");
        }
        else
        {
            out.println("<h3>Invalid Username or Password</h3>");
        }
        out.println("</body></html>");
        out.close();
    }
}
