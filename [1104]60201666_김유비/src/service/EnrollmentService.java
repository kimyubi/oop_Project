package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import valueObject.VLecture;
import valueObject.VPlan;
import valueObject.VSearch;
import valueObject.VUser;

public class EnrollmentService {

	public Vector<VLecture> getInitailData() {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM LECTURE";
		Vector<VLecture> vLectures = new Vector<VLecture>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				VLecture vLecture = new VLecture(rs.getString("CODE"),rs.getString("NAME"),rs.getString("LOCATION"),rs.getString("PERSONNEL"),rs.getString("PROFESSOR"),rs.getString("GRADES"),rs.getString("TIME"),rs.getString("CAMPUS"));
				vLectures.add(vLecture);
			}
			
			con.close();
			st.close();
			rs.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return vLectures;
	}

	public Vector<VLecture> getSearchData(VSearch vSearch) {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM LECTURE WHERE CAMPUS LIKE ? AND CODE LIKE ? AND NAME LIKE ? AND GRADES LIKE ? AND PROFESSOR LIKE ?";
		Vector<VLecture> vLectures = new Vector<VLecture>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "%"+vSearch.getCampus()+"%");
			st.setString(2, "%"+vSearch.getCode()+"%");
			st.setString(3, "%"+vSearch.getLectureName()+"%");
			st.setString(4, "%"+vSearch.getCredit()+"%");
			st.setString(5, "%"+vSearch.getProfessor()+"%");
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				VLecture vLecture = new VLecture(rs.getString("CODE"),rs.getString("NAME"),rs.getString("LOCATION"),rs.getString("PERSONNEL"),rs.getString("PROFESSOR"),rs.getString("GRADES"),rs.getString("TIME"),rs.getString("CAMPUS"));
				vLectures.add(vLecture);
			}
			con.close();
			st.close();
			rs.close();
			
		} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return vLectures;
	}

	public int getMaxGrades(VUser currentUser) {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT MAXGRADES FROM ACCOUNT JOIN COLLEAGE ON ACCOUNT.COLLEAGE = COLLEAGE.COLLEAGE WHERE USERID = ?";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
				
			st.setString(1,currentUser.getUserId());
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				if(rs.getString("MAXGRADES") == null) {
					return result;
				}
				result = Integer.parseInt(rs.getString("MAXGRADES"));
			}
			
			con.close();
			st.close();
			rs.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

	public int enrollment(VUser currentUser, String code) {
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "INSERT INTO ENROLLMENT(USERID, CODE) SELECT ?,? FROM DUAL WHERE NOT EXISTS(SELECT USERID FROM ENROLLMENT WHERE USERID = ? AND CODE = ?)";
		
	try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
				
			st.setString(1, currentUser.getUserId());
			st.setString(2, code);
			st.setString(3, currentUser.getUserId());
			st.setString(4, code);
			
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
		
		return result;
			

	}

	public int miridamgi(VUser currentUser, String code) {
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "INSERT INTO MIRI(USERID, CODE) SELECT ?,? FROM DUAL WHERE NOT EXISTS(SELECT USERID FROM MIRI WHERE USERID = ? AND CODE = ?)";
		
	try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
				
			st.setString(1, currentUser.getUserId());
			st.setString(2, code);
			st.setString(3, currentUser.getUserId());
			st.setString(4, code);
			
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
		
		return result;
			
	}

	public int getEnrolledGrades(VUser currentUser) {
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT SUM(GRADES) GRADES FROM ENROLLMENT JOIN LECTURE ON ENROLLMENT.CODE = LECTURE.CODE WHERE USERID = ?";
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
				
			st.setString(1,currentUser.getUserId());
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				if(rs.getString("GRADES") == null) {
					return result;
				}
				result = Integer.parseInt(rs.getString("GRADES"));
			}
			con.close();
			st.close();
			rs.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public int getCreditByCode(String code) {
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT GRADES FROM LECTURE WHERE CODE = ?";
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
				
			st.setString(1,code);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				if(rs.getString("GRADES") == null) {
					return result;
				}
				result = Integer.parseInt(rs.getString("GRADES"));
			}
			con.close();
			st.close();
			rs.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public Vector<VLecture> getDataFromMiri(VUser currentUser) {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM MIRI JOIN LECTURE ON MIRI.CODE = LECTURE.CODE WHERE USERID = ? ";
		Vector<VLecture> vLectures = new Vector<VLecture>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,currentUser.getUserId());
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				VLecture vLecture = new VLecture(rs.getString("CODE"),rs.getString("NAME"),rs.getString("PERSONNEL"),rs.getString("GRADES"), rs.getString("PROFESSOR"),rs.getString("TIME"),rs.getString("CAMPUS"));
				vLectures.add(vLecture);
			}
			
			con.close();
			st.close();
			rs.close();
			} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return vLectures;
	}

	public int deleteLectureFromMiri(VUser currentUser, String code) {
		int result = 0;
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE FROM MIRI WHERE USERID = ? AND CODE = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,currentUser.getUserId());
			st.setString(2,code);
			result = st.executeUpdate();
			
			con.close();
			st.close();
					
			} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return result;
	}

	public int deleteLectureFromEnrollment(VUser currentUser, String code) {
		int result = 0;
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE FROM ENROLLMENT WHERE USERID = ? AND CODE = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,currentUser.getUserId());
			st.setString(2,code);
			result = st.executeUpdate();
		
			con.close();
			st.close();
			} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return result;
	}

	public Vector<VLecture> getDataFromEnrollment(VUser currentUser) {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM ENROLLMENT JOIN LECTURE ON ENROLLMENT.CODE = LECTURE.CODE WHERE USERID = ? ";
		Vector<VLecture> vLectures = new Vector<VLecture>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,currentUser.getUserId());
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				VLecture vLecture = new VLecture(rs.getString("CODE"),rs.getString("NAME"),rs.getString("PERSONNEL"),rs.getString("GRADES"), rs.getString("PROFESSOR"),rs.getString("TIME"),rs.getString("CAMPUS"));
				vLectures.add(vLecture);
			}
			
			con.close();
			st.close();
			rs.close();
			} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return vLectures;
	}

	public VPlan getLectureByCode(String code) throws SQLException, ClassNotFoundException {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM LECTURE JOIN LECTUREDETAIL ON LECTURE.CODE = LECTUREDETAIL.CODE JOIN WEEKLYPROGRESS ON LECTURE.CODE = WEEKLYPROGRESS.CODE WHERE LECTURE.CODE = ?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,code);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
		 VPlan vPlan = new VPlan(rs.getString("NAME"), rs.getString("CODE"), rs.getString("PROFESSOR"), rs.getString("TIME"), rs.getString("PERSONNEL"), rs.getString("GOAL"), rs.getString("BOOK"), rs.getString("GRADEEVALUATION"), rs.getString("GRADES"), rs.getString("EMAIL"), rs.getString("WEEK1"), rs.getString("WEEK2"), rs.getString("WEEK3"), rs.getString("WEEK4"), rs.getString("WEEK5"), rs.getString("WEEK6"), rs.getString("WEEK7"), rs.getString("WEEK8"), rs.getString("WEEK9"), rs.getString("WEEK10"), rs.getString("WEEK11"), rs.getString("WEEK12"), rs.getString("WEEK13"), rs.getString("WEEK14"), rs.getString("WEEK15"), rs.getString("WEEK16"));
		 return vPlan;
		}
		
		con.close();
		st.close();
		rs.close();
		
		return null;
	}

	public int deleteLectureByCode(String code) {
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE FROM LECTURE WHERE CODE = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
	
			st.setString(1,code);
			result = st.executeUpdate();
		
			con.close();
			st.close();
			} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}

	public int deleteLectureDetailByCode(String code) {
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE FROM LECTUREDETAIL WHERE CODE = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
	
			st.setString(1,code);
			result = st.executeUpdate();
		
			con.close();
			st.close();
			} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
		
	}

	public int deleteWeeklyProgressByCode(String code) {
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE FROM WEEKLYPROGRESS WHERE CODE = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
	
			st.setString(1,code);
			result = st.executeUpdate();
		
			con.close();
			st.close();
			} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
		
	}

	public int registerLecture(VLecture vLecture) {
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "INSERT INTO LECTURE(CODE,NAME,PERSONNEL,PROFESSOR,GRADES,TIME,CAMPUS) VALUES(?,?,?,?,?,?,?) ";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
	
			st.setString(1,vLecture.getCode());
			st.setString(2, vLecture.getLectureName());
			st.setString(3, vLecture.getPersonnel());
			st.setString(4, vLecture.getProfessor());
			st.setString(5, vLecture.getCredit());
			st.setString(6, vLecture.getTime());
			st.setString(7, vLecture.getCampus());
			
			
			
			result = st.executeUpdate();
		
			con.close();
			st.close();
			} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}

	public boolean existByCode(String code) {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM LECTURE WHERE CODE = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "hidb!");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,code);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
			 return true;
			}
			
			con.close();
			st.close();
			rs.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
}

