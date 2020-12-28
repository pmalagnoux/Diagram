package client.EJBs;

public class RecipeType {
	private int id;
	private String name;
	
	public RecipeType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public RecipeType() {
		super();
	}
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
