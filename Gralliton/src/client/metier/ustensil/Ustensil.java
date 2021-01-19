package client.metier.ustensil;

public class Ustensil {
	private int id;
	private String name;
	
	//Constructeur
	
	public Ustensil() {
		super();
	}
	
	public Ustensil(int id) {
		super();
		this.id = id;
	}
	
	public Ustensil(String name) {
		super();
		this.name = name;
	}
	
	public Ustensil(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	//Getter & Setter
	
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

}
