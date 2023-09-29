

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookies")
public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get the current session ID or create a new one
        String sessionId = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {
                    sessionId = cookie.getValue();
                    break;
                }
            }
        }
        if (sessionId == null) {
            sessionId = java.util.UUID.randomUUID().toString();
            Cookie sessionIdCookie = new Cookie("sessionId", sessionId);
            response.addCookie(sessionIdCookie);
        }
        
        // Get the visit count from the session
        Integer visitCount = (Integer) request.getSession().getAttribute("visitCount");
        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }
        request.getSession().setAttribute("visitCount", visitCount);
        
        // Set the content type for the response
        response.setContentType("text/html");
        
        // Create a PrintWriter to write the response
        PrintWriter out = response.getWriter();
        
        // Generate the HTML response
        out.println("<html>");
        out.println("<head><title>Session Tracking with Cookies</title></head>");
        out.println("<body>");
        out.println("<h1>Session Tracking with Cookies</h1>");
        out.println("<p>Session ID: " + sessionId + "</p>");
        out.println("<p>Visit Count: " + visitCount + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}










       
