package valueObject;

public class VUser {
	private String userId;
	private String userpwd;
	private String email;
	private String name;
	private int hakbeon;
	private String colleage;
	private int saved;
	
	
	public VUser(String userId, String userpwd, String email, String name, int saved) {
		this.userId = userId;
		this.userpwd = userpwd;
		this.email = email;	
		this.name = name;	
		this.saved = saved;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}
	
	public int getHakbeon() {
		return hakbeon;
	}
	
	public String getColleage() {
		return colleage;
	}
	
	public void setColleage(String colleage) {
		this.colleage = colleage;
	}
	
	public void setHakbeon(int hakbeon) {
		this.hakbeon = hakbeon;
	}

	public void setSaved(int saved) {
		this.saved = saved;
	}
	
	public int getSaved() {
		return saved;
	}
	
   


}
