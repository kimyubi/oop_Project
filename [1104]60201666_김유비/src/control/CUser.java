package control;

import java.sql.SQLException;
import java.util.Vector;

import service.loginService;
import valueObject.VUser;

public class CUser {

	loginService loginService = new loginService();
	
	public VUser getUser(String userId) {
		VUser vuser = loginService.getUser(userId);
		
		return vuser;
	}

	public boolean ExistUserByEmail(String email) throws ClassNotFoundException, SQLException {
		return loginService.ExistUserByEmail(email);
	}

	public VUser getUserByEmail(String email) throws ClassNotFoundException, SQLException {
		return loginService.getUserByEmail(email);
	}

	public boolean ExistUserByEmailAndId(String email, String userId) throws ClassNotFoundException, SQLException {
		return loginService.ExistUserByEmailAndId(email, userId);
	}

	public VUser updateMyInfo(VUser currentUser) throws ClassNotFoundException, SQLException {
		currentUser.setSaved(1);
		loginService.updateMyInfo(currentUser);
		return loginService.getUserWithMyInfo(currentUser);
	}

	public VUser getUserWithMyInfo(VUser currentUser) {
		return loginService.getUserWithMyInfo(currentUser);
	}

	public int getMaxGrades(VUser currentUser) {
		return loginService.getMaxGrades(currentUser);
	}

	public Vector<VUser> getAccountData() {
		return loginService.getAccountData();
	}

	public int secessionAccountById(String userId) {
		loginService.secessionAccountByIdFromEnrollment(userId);
		loginService.secessionAccountByIdFromMiri(userId);
		return loginService.secessionAccountById(userId);
		
	}
}
