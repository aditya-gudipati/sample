import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Test extends HttpServlet
{
    public void doGet(HttpServletRequest r, HttpServletResponse rs) throws IOException, ServletException
    {
        rs.setContentType("text/html");
        PrintWriter out = rs.getWriter();
        // Get parameters
        String username = r.getParameter("username");
        String password = r.getParameter("password");
        String firstname = r.getParameter("firstname");
        String dob = r.getParameter("dob");
        out.println("<html><body>");
        // Simple validation
        if(username.equals("admin") && password.equals("1234"))
        {
            // Generate key
            String key;
            if(firstname.length() >= 2)
            {
                key = firstname.substring(0,2).toLowerCase() + dob;
            }
            else
            {
                key = firstname.toLowerCase() + dob;
            }

            out.println("<h2>Welcome, " + firstname + "</h2>");
            out.println("<h3>Your Key: " + key + "</h3>");
        }
        else
        {
            out.println("<h3>Invalid Username or Password</h3>");
        }
        out.println("</body></html>");
        out.close();
    }
}
