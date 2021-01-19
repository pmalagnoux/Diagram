package client.metier.tag;

public class Tag {
	private int id;
	private String name;
	
	//Constructeur
	
	public Tag() {
		super();
	}
	
	public Tag(int id) {
		super();
		this.id = id;
	}
	
	public Tag(String name) {
		super();
		this.name = name;
	}
	
	public Tag(int id, String name) {
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
