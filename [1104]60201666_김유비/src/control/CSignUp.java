package control;

import service.SignupService;
import valueObject.VSignupForm;

public class CSignUp {

	private SignupService signupService = new SignupService(); 
	
	public boolean saveAccount(VSignupForm vSignupForm) {
		return signupService.saveAccount(vSignupForm);
	}

	public boolean validateEmail(VSignupForm vSignupForm) {
		return signupService.validateEmail(vSignupForm);
	}
	

}
