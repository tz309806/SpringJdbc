package Programming.to.aninterface.spring.SpringJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class JdbcCustomerDao implements CustomerDAO {

	private DataSource dataSource;
	private String sql;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	

	public void setSql(String sql) {
		this.sql = sql;
	}


	public void insert(Customer customer) {

//		String createTable = "CREATE TABLE `customer2`"
//				+ "(`CUST_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,`NAME` varchar(100) NOT NULL,`AGE` int(10) unsigned NOT NULL,PRIMARY KEY (`CUST_ID`)) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;";

//		String sql = "INSERT INTO CUSTOMER2" + "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		Connection conn = null;

//		try {
//			conn = dataSource.getConnection();
////			PreparedStatement ps2 = conn.prepareStatement(createTable);
////			ps2.executeUpdate(createTable);
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, customer.getCustId());
//			System.out.println(customer.getName());
//			ps.setString(2, customer.getName());
//			ps.setInt(3, customer.getAge());
//			ps.executeUpdate();
//			ps.close();
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//				}
//			}
//		}
	}

	public Customer findByCustomerId(int custId) {

//		String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";

		

		Connection conn = null;
		
		List myList = new ArrayList();

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
			customer = new Customer(rs.getInt("CUSTOMER_ID"), rs.getString("FIRST_NAME"), rs.getInt("store_id"));
			myList.add(0, rs.getInt("CUSTOMER_ID"));
			myList.add(1, rs.getString("FIRST_NAME"));
			myList.add(2, rs.getInt("store_id"));
			System.out.println(myList);
			for (Object ele: myList) {
				if((Integer) myList.get(0)!=1) {
					System.out.println("Result is wrong!!!");
				}
			}
			
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
