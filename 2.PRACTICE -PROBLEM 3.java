

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class third
 */

public class third extends GenericServlet {

	    @Override
	    public void service(ServletRequest request, ServletResponse response) 
	            throws ServletException, IOException {

	        response.setContentType("text/html");
	        String userName = request.getParameter("name");
	        PrintWriter out = response.getWriter();

	        out.println("<html>");
	        out.println("<head><title>Generic Greeting Servlet</title></head>");
	        out.println("<body>");
	        out.println("<h2>Hello, " + userName + "!</h2>");
	        out.println("<p>Welcome to the Generic Servlet.</p>");
	        out.println("</body>");
	        out.println("</html>");

	     
	        out.close();
	    }
	}


