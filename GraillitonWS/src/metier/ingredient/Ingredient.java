package metier.ingredient;

public class Ingredient {
	private int id;
	private String name;
	private double quantity;
	
	//Constructeur
	
	public Ingredient() {
		super();
	}
	
	public Ingredient(int id) {
		super();
		this.id = id;
	}
	
	public Ingredient(String name) {
		super();
		this.name = name;
	}
	
	public Ingredient(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Ingredient(String name, double quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}
	
	public Ingredient(int id, String name, double quantity) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
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
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	
}
