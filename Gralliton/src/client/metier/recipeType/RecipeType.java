package client.metier.recipeType;

public class RecipeType {
	private int id;
	private String name;
	
	//Constructeur
	public RecipeType() {
		super();
	}
	
	public RecipeType(String name) {
		super();
		this.name = name;
	}
	
	public RecipeType(int id, String name) {
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
