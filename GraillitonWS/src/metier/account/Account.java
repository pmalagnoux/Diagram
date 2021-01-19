package metier.account;

public class Account {
	private int id;
	private String password;
	private String login;
	private String email;
	
	//Constructeur 
	public Account() {
		super();
	}
	
	public Account(String login) {
		super();
		this.login = login;
	}
	
	public Account(int id, String login) {
		super();
		this.id = id;
		this.login = login;
	}
	
	public Account(String password, String login, String email) {
		super();
		this.password = password;
		this.login = login;
		this.email = email;
	}
	
	//Getter & Setter
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
}
