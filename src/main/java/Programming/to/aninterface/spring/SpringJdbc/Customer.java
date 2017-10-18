package Programming.to.aninterface.spring.SpringJdbc;

public class Customer {
	
	public Customer(int custId, String name, int age) {
		System.out.println(custId+name+age);
		this.custId=custId;
		this.name=name;
		this.age=age;
	}
	
	int custId;
	String name;
	int age;
	//getter and setter methods
	public int getCustId() {
		
		System.out.println("getCustID is:" + custId);
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		System.out.println("getName is:" + custId);
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		System.out.println("getAge is:" + custId);
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
