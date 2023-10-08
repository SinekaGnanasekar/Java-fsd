
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.apache.log4j.Logger;

	public class practice {
	    private static final Logger logger = Logger.getLogger(practice.class);
	    
	    public static void main(String[] args) {
	        org.apache.log4j.BasicConfigurator.configure(); // Configure Log4j
	       
	    		Student s1=new Student();
	    		s1.setId(100);
	    		s1.setName("mani");
	    		
	    		Configuration c =new Configuration().configure().addAnnotatedClass(Student.class);
	    				
	    		ServiceRegistry reg =new StandardServiceRegistryBuilder().applySettings(c.getProperties()).getBootstrapServiceRegistry();
	    		
	    		SessionFactory sf=c.buildSessionFactory(reg);
	    	    
	    	    Session  s= sf.openSession();
	    		
	    		Transaction t=s.beginTransaction();
	    	
	    		s.save(s1);
	    		
	    		t.commit();
	    		
	    		
	    	}
}
