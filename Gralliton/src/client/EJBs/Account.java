package client.EJBs;

public class Account {
	private String password;
	private String login;
	private String email;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Account(String password, String login, String email) {
		super();
		this.password = password;
		this.login = login;
		this.email = email;
	}
	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "Account [password=" + password + ", login=" + login + ", email=" + email + "]";
	}
	
	
}
