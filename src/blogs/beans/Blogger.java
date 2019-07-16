package blogs.beans;

public class Blogger {
	private String registrationId = null;
	private String fullName = null;
	private String email = null;
	
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegistrationId() {
		return this.registrationId;
	}
	public String getFullName() {
		return this.fullName;
	}
	public String getEmail() {
		return this.email;
	}

}
