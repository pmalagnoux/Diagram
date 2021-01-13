package client.metier.favorite;

public class Favorite {
	private int account;
	private int recipe;
	
	public Favorite() {
		super();
	}

	public Favorite(int account, int recipe) {
		super();
		this.account = account;
		this.recipe = recipe;
	}

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