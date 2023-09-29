
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Filters")
public class Filters implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        
        System.out.println("Request received at " + new java.util.Date());

   
        chain.doFilter(request, response);

        long processingTime = System.currentTimeMillis() - startTime;
        System.out.println("Request processing time: " + processingTime + " ms");
    }

    @Override
    public void destroy() {
        
    }
}
