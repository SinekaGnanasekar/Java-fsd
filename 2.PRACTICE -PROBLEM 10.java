

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginLogoutServlet")
public class Login_logout extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            // User is already logged in; display a welcome message and logout link
            String username = (String) session.getAttribute("username");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>Welcome</title></head>");
            out.println("<body>");
            out.println("<h1>Welcome, " + username + "!</h1>");
            out.println("<p><a href='LogoutServlet'>Logout</a></p>");
            out.println("</body>");
            out.println("</html>");
        } else {
            // User is not logged in; display the login form
            response.sendRedirect("login.html");
        }
    }
}

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {
            // Invalidate (logout) the session
            session.invalidate();
        }

        // Redirect to the login page
        response.sendRedirect("login.html");
    }
}
