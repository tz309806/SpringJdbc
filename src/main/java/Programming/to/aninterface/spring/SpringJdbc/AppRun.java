package Programming.to.aninterface.spring.SpringJdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppRun {

	public static void main(String[] args) {
    	ApplicationContext context =
        		new ClassPathXmlApplicationContext("Spring-Module.xml");

            CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
//            Customer customer = new Customer(1, "Teng Zhang",28);
//            customerDAO.insert(customer);

            Customer customer1 = customerDAO.findByCustomerId(33);
            System.out.println(customer1);
	}

}
