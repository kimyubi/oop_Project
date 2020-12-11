package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import valueObject.VSignupForm;

public class SignupService {

	public boolean saveAccount(VSignupForm vSignupForm) {
		
		int result = 0;
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "INSERT INTO ACCOUNT(USERID,USERPWD,EMAIL,NAME) SELECT ?,?,?,? FROM DUAL WHERE NOT EXISTS(SELECT USERID FROM ACCOUNT WHERE USERID = ?)";

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
				
			st.setString(1, vSignupForm.getUserId());
			st.setString(2, vSignupForm.getUserPwd());
			st.setString(3, vSignupForm.getEmail());
			st.setString(4, vSignupForm.getName());
			st.setString(5, vSignupForm.getUserId());
			
			result = st.executeUpdate();
		
			con.close();
			st.close();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		if(result == 0) {return false;}
		
		return true;
		
		
	}

	public boolean validateEmail(VSignupForm vSignupForm) {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT USERID FROM ACCOUNT WHERE EMAIL = ?";

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
				
			st.setString(1, vSignupForm.getEmail());
			
			ResultSet resultSet =  st.executeQuery();
			if(resultSet.next()) {
				return false;
			}
		
			con.close();
			st.close();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return true;
	}

}
