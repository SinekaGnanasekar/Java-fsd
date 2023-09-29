

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionTracking")
public class SessionTracking extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the current session or create a new one if it doesn't exist
        HttpSession session = request.getSession(true);

        // Get or initialize the visit count attribute in the session
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }

        // Store the updated visit count in the session
        session.setAttribute("visitCount", visitCount);

        // Set the content type for the response
        response.setContentType("text/html");

        // Create a PrintWriter to write the response
        PrintWriter out = response.getWriter();

        // Generate the HTML response
        out.println("<html>");
        out.println("<head><title>Session Tracking with HTTP Session</title></head>");
        out.println("<body>");
        out.println("<h1>Session Tracking with HTTP Session</h1>");
        out.println("<p>Visit Count: " + visitCount + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
