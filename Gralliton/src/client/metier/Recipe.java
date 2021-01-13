package client.metier;

import java.util.List;

public class Recipe {
	private int id;
	private String name;
	private int preparationTime;
	private int cookingTime;
	private int likeNumber;
	private int quantity;
	private int account;
	private int difficulty;
	private int type;
	private List<Tag> tags;
	
	
	public Recipe() {
		super();
	}
	public Recipe(String name, int preparationTime, int cookingTime, int quantity, int account,
			int difficulty, int type) {
		super();
		this.name = name;
		this.preparationTime = preparationTime;
		this.cookingTime = cookingTime;
		this.quantity = quantity;
		this.account = account;
		this.difficulty = difficulty;
		this.type = type;
	}
	
	public Recipe(int id, String name, int preparationTime, int cookingTime, int likeNumber, int quantity, int account,
			int difficulty, int type) {
		super();
		this.id = id;
		this.name = name;
		this.preparationTime = preparationTime;
		this.cookingTime = cookingTime;
		this.likeNumber = likeNumber;
		this.quantity = quantity;
		this.account = account;
		this.difficulty = difficulty;
		this.type = type;
	}
	public Recipe(int id, String name, int preparationTime, int cookingTime, int likeNumber, int quantity, int account,
			int difficulty, int type, List<Tag> tagsID) {
		super();
		this.id = id;
		this.name = name;
		this.preparationTime = preparationTime;
		this.cookingTime = cookingTime;
		this.likeNumber = likeNumber;
		this.quantity = quantity;
		this.account = account;
		this.difficulty = difficulty;
		this.type = type;
		this.tags = tagsID;
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
	public int getPreparationTime() {
		return preparationTime;
	}
	public void setPreparationTime(int preparationTime) {
		this.preparationTime = preparationTime;
	}
	public int getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(int cookingTime) {
		this.cookingTime = cookingTime;
	}
	public int getLikeNumber() {
		return likeNumber;
	}
	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tagsID) {
		this.tags = tagsID;
	}
	
	
}
