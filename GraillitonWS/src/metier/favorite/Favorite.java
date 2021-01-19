package metier.favorite;

public class Favorite {
	private int account;
	private int recipe;
	
	//Constructeur
	
	public Favorite() {
		super();
	}

	public Favorite(int account, int recipe) {
		super();
		this.account = account;
		this.recipe = recipe;
	}

	//Geyyet & Setter
	
	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public int getRecipe() {
		return recipe;
	}

	public void setRecipe(int recipe) {
		this.recipe = recipe;
	}
	
}
