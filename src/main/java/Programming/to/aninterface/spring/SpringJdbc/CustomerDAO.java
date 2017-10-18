package Programming.to.aninterface.spring.SpringJdbc;

public interface CustomerDAO {
	
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);

}
