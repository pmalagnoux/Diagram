package client.metier.difficulty;

public class Difficulty {
	private int id;
	private String name;
	
	//Constructeur 
	public Difficulty() {
		super();
	}
	
	public Difficulty(int id, String name) {
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
	public Difficulty(String name) {
		super();
		this.name = name;
	}
}
