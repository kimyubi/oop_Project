package control;

import service.loginService;
import valueObject.VLogin;

public class CLogin {

	public int validateUser(VLogin vLogin) {
		loginService loginService = new loginService();
		
		return loginService.validateUser(vLogin);
	}

}
