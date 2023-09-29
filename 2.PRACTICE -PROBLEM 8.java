


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class urlrewriting
 */
@WebServlet("/urlrewriting")
public class urlrewriting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        // Get the current visit count from the session or initialize it to 0
	        Integer visitCount = (Integer) request.getSession().getAttribute("visitCount");
	        if (visitCount == null) {
	            visitCount = 0;
	        }

	        // Increment the visit count
	        visitCount++;
	        request.getSession().setAttribute("visitCount", visitCount);

	        // Encode the URL with session information
	        String urlWithSession = response.encodeURL("CounterServlet");

	        // Set the content type for the response
	        response.setContentType("text/html");

	        // Create a PrintWriter to write the response
	        PrintWriter out = response.getWriter();

	        // Generate the HTML response
	        out.println("<html>");
	        out.println("<head><title>Session Tracking with URL Rewrite</title></head>");
	        out.println("<body>");
	        out.println("<h1>Session Tracking with URL Rewrite</h1>");
	        out.println("<p>Visit Count: " + visitCount + "</p>");
	        out.println("<p><a href='" + urlWithSession + "'>Increment Visit Count</a></p>");
	        out.println("</body>");
	        out.println("</html>");
	    }
	}
