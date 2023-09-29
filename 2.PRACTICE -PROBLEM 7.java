

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class session
 */
@WebServlet("/session")
public class session extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        // Get the current session or create a new one
	        HttpSession session = request.getSession(true);

	        // Get the visit count from the session or initialize it to 0
	        Integer visitCount = (Integer) session.getAttribute("visitCount");
	        if (visitCount == null) {
	            visitCount = 0;
	        }

	        // Increment the visit count
	        visitCount++;
	        session.setAttribute("visitCount", visitCount);

	        // Set the content type for the response
	        response.setContentType("text/html");

	        // Create a PrintWriter to write the response
	        PrintWriter out = response.getWriter();

	        // Generate the HTML response
	        out.println("<html>");
	        out.println("<head><title>Session Tracking with Hidden Form Fields</title></head>");
	        out.println("<body>");
	        out.println("<h1>Session Tracking with Hidden Form Fields</h1>");
	        out.println("<p>Visit Count: " + visitCount + "</p>");
	        out.println("<form method='post' action='CounterServlet'>");
	        out.println("<input type='hidden' name='visitCount' value='" + visitCount + "'>");
	        out.println("<input type='submit' value='Increment Visit Count'>");
	        out.println("</form>");
	        out.println("</body>");
	        out.println("</html>");
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        // Get the visit count from the hidden form field
	        int visitCount = Integer.parseInt(request.getParameter("visitCount"));

	        // Increment the visit count
	        visitCount++;

	        // Set the updated visit count in the hidden form field
	        HttpSession session = request.getSession();
	        session.setAttribute("visitCount", visitCount);

	        // Redirect back to the GET request
	        response.sendRedirect(request.getRequestURI());
	    }
	}
