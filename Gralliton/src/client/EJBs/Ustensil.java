package client.EJBs;

public class Ustensil {
	private int id;
	private String name;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Ustensil(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Ustensil() {
		super();
	}
	public Ustensil(int id) {
		super();
		this.id = id;
	}
	
}