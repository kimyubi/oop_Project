package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import valueObject.VLogin;
import valueObject.VUser;

public class loginService {

	public int validateUser(VLogin vLogin) {
		
		int result = 3;             // 존재하지 않는 계정입니다. 회원가입을 먼저 진행해주세요. (default)
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM ACCOUNT WHERE USERID = ?";

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
				
			st.setString(1, vLogin.getUserId());
		
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				
				if(vLogin.getPassword().equals(rs.getString("USERPWD"))) {
					// 로그인 성공 : 1
					result = 1;
				}
				else {
					//아이디 일치 & 비밀번호 불일치 : 2
					result = 2;
				}
				
			}
			else {
				// 아이디 불일치 => 계정 존재 x : 3
				result = 3; 
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
			
		return result;
		
	}

	public VUser getUser(String userId) {
	    
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM ACCOUNT WHERE USERID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
					
			st.setString(1, userId);
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				VUser vUser = new VUser(rs.getString("USERID"), rs.getString("USERPWD"), rs.getString("EMAIL"), rs.getString("NAME"),Integer.parseInt(rs.getString("SAVED")));
				return vUser;
			}
			
			con.close();
			st.close();
			rs.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		return null;
	}

	public boolean ExistUserByEmail(String email) throws ClassNotFoundException, SQLException {

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM ACCOUNT WHERE EMAIL = ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, email);
		
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			return true;
		}
		con.close();
		st.close();
		rs.close();
	
		return false;
	}

	public VUser getUserByEmail(String email)throws ClassNotFoundException, SQLException {

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM ACCOUNT WHERE EMAIL = ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, email);
		
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			VUser vUser = new VUser(rs.getString("USERID"), rs.getString("USERPWD"),rs.getString("EMAIL"), rs.getString("NAME"),Integer.parseInt(rs.getString("SAVED")));
			return vUser;
		}	

		con.close();
		st.close();
		rs.close();
		return null;
	}

	public boolean ExistUserByEmailAndId(String email, String userId)throws ClassNotFoundException, SQLException  {

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM ACCOUNT WHERE EMAIL = ? AND USERID = ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, email);
		st.setString(2, userId);
		
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			return true;
		}
		con.close();
		st.close();
		rs.close();
	
		return false;
	}

	public void updateMyInfo(VUser currentUser) throws ClassNotFoundException, SQLException {

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "UPDATE ACCOUNT SET HAKBEON = ?, COLLEAGE =?, SAVED =?  WHERE USERID = ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, String.valueOf(currentUser.getHakbeon()));
		st.setString(2, currentUser.getColleage());
		st.setString(3, String.valueOf(currentUser.getSaved()));
		st.setString(4, currentUser.getUserId());
		
		st.executeUpdate();
		
		con.close();
		st.close();
		
	}

	public VUser getUserWithMyInfo(VUser currentUser) {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM ACCOUNT WHERE USERID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
					
			st.setString(1, currentUser.getUserId());
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				currentUser.setHakbeon(Integer.parseInt(rs.getString("HAKBEON")));
				currentUser.setColleage(rs.getString("COLLEAGE"));
				currentUser.setSaved(Integer.parseInt(rs.getString("SAVED")));
				return currentUser;
			}
			con.close();
			st.close();
			rs.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		return null;
	}

	public int getMaxGrades(VUser currentUser) {
		int result = 0;
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT MAXGRADES FROM ACCOUNT JOIN COLLEAGE ON ACCOUNT.COLLEAGE = COLLEAGE.COLLEAGE WHERE USERID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
					
			st.setString(1, currentUser.getUserId());
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				result = Integer.parseInt(rs.getString("MAXGRADES"));
			}
			con.close();
			st.close();
			rs.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		return result;
	}

	public Vector<VUser> getAccountData() {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM ACCOUNT";
		Vector<VUser> vUsers = new Vector<VUser>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				VUser vUser = new VUser(rs.getString("USERID"), rs.getString("USERPWD"), rs.getString("EMAIL"), rs.getString("NAME"), Integer.parseInt(rs.getString("SAVED")));
				vUsers.add(vUser);
			}
			con.close();
			st.close();
			rs.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		return vUsers;
	}

	public int secessionAccountById(String userId) {
		int result = 0;
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE FROM ACCOUNT WHERE USERID = ? ";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
					
			st.setString(1, userId);
			
			result = st.executeUpdate();
			
			con.close();
			st.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		return result;
	}

	public int secessionAccountByIdFromEnrollment(String userId) {
	int result = 0;
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE FROM ENROLLMENT WHERE USERID = ? ";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
					
			st.setString(1, userId);
			
			result = st.executeUpdate();
			
			con.close();
			st.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		return result;
		
	}

	public int secessionAccountByIdFromMiri(String userId) {
	int result = 0;
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE FROM MIRI WHERE USERID = ? ";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
					
			st.setString(1, userId);
			
			result = st.executeUpdate();
			
			con.close();
			st.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		return result;
		
	}

	
}
