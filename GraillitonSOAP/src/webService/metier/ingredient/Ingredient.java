package webService.metier.ingredient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ingredient {
	private int id;
	private String name;
	
	
	public Ingredient(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Ingredient(int id) {
		super();
		this.id = id;
	}
	public Ingredient(String name) {
		super();
		this.name = name;
	}
	public Ingredient() {
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
