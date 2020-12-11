package control;

import java.sql.SQLException;
import java.util.Vector;

import service.EnrollmentService;
import valueObject.VLecture;
import valueObject.VPlan;
import valueObject.VSearch;
import valueObject.VUser;

public class CEnrollment {

	private EnrollmentService enrollmentService = new EnrollmentService();

	public Vector<VLecture> getInitailData() {
		return enrollmentService.getInitailData();
	}

	public Vector<VLecture> getSearchData(VSearch vSearch) {
		return enrollmentService.getSearchData(vSearch);
	}

	public int getMaxGrades(VUser currentUser) {
		return enrollmentService.getMaxGrades(currentUser);
	}

	public int enrollment(VUser currentUser, String code) {
		return enrollmentService.enrollment(currentUser,code);
		
	}

	public int miridamgi(VUser currentUser, String code) {
		return enrollmentService.miridamgi(currentUser,code);
	}

	public int getEnrolledGrades(VUser currentUser) {
		return enrollmentService.getEnrolledGrades(currentUser);
	}

	public int getCreditByCode(String code) {
		return enrollmentService.getCreditByCode(code);
	}

	public int deleteLectureFromMiri(VUser currentUser, String code) {
		return enrollmentService.deleteLectureFromMiri(currentUser,code);
	}

	public Vector<VLecture> getDataFromMiri(VUser currentUser) {
		return enrollmentService.getDataFromMiri(currentUser);
	}

	public int deleteLectureFromEnrollment(VUser currentUser, String code) {
		return enrollmentService.deleteLectureFromEnrollment(currentUser,code);
	}

	public Vector<VLecture> getDataFromEnrollment(VUser currentUser) {
		return enrollmentService.getDataFromEnrollment(currentUser);
	}


	public VPlan getLectureByCode(String code) throws ClassNotFoundException, SQLException {
		return enrollmentService.getLectureByCode(code);
	}

	public int deleteLectureByCode(String code) {
		enrollmentService.deleteLectureDetailByCode(code);
		enrollmentService.deleteWeeklyProgressByCode(code);
		return enrollmentService.deleteLectureByCode(code);
		
	}

	public int registerLecture(VLecture vLecture) {
		return enrollmentService.registerLecture(vLecture);
	}

	public boolean existByCode(String code) {
		return enrollmentService.existByCode(code);
	}

}
