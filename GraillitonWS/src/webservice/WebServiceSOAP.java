package webservice;

import java.util.List;

import metier.Authentication;
import metier.account.Account;
import metier.account.AccountManager;
import metier.difficulty.Difficulty;
import metier.difficulty.DifficultyManager;
import metier.favorite.Favorite;
import metier.favorite.FavoriteManager;
import metier.ingredient.Ingredient;
import metier.ingredient.IngredientManager;
import metier.recipe.Recipe;
import metier.recipe.RecipeManager;
import metier.recipeType.RecipeType;
import metier.recipeType.RecipeTypeManager;
import metier.step.Step;
import metier.step.StepManager;
import metier.tag.Tag;
import metier.tag.TagManager;
import metier.ustensil.Ustensil;
import metier.ustensil.UstensilManager;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "WS")
public class WebServiceSOAP {
	
	
	// --- Constructeurs ---
	
	//Account
	
	@WebMethod(operationName = "getAccount1")
	public Account getAccount1(@WebParam(name = "login")String login) {
		return new Account(login);
	}
	
	@WebMethod(operationName = "getAccount2")
	public Account getAccount2(@WebParam(name = "id")int id, @WebParam(name = "login")String login) {
		return new Account(id, login);
	}
	
	@WebMethod(operationName = "getAccount3")
	public Account getAccount3(@WebParam(name = "password")String password, @WebParam(name = "login")String login, @WebParam(name = "email")String email) {
		return new Account(password, login, email);
	}
	
	//Difficulty
	
	@WebMethod(operationName = "getDifficulty")
	public Difficulty getDifficulty(@WebParam(name = "id")int id, @WebParam(name = "name")String name) {
		return new Difficulty(id, name);
	}
	
	//Favorite
	
	@WebMethod(operationName = "getFavorite")
	public Favorite getFavorite(@WebParam(name = "account")int account, @WebParam(name = "recipe")int recipe) {
		return new Favorite(account, recipe);
	}
	
	//Ingredient
	
	@WebMethod(operationName = "getIngredient1")
	public Ingredient getIngredient1(@WebParam(name = "id")int id) {
		return new Ingredient(id);
	}
	
	@WebMethod(operationName = "getIngredient2")
	public Ingredient getIngredient2(@WebParam(name = "name")String name) {
		return new Ingredient(name);
	}
	
	@WebMethod(operationName = "getIngredient3")
	public Ingredient getIngredient3(@WebParam(name = "id")int id, @WebParam(name = "name")String name) {
		return new Ingredient(id,name);
	}
	
	@WebMethod(operationName = "getIngredient4")
	public Ingredient getIngredient4(@WebParam(name = "name")String name, @WebParam(name = "quantity")double quantity) {
		return new Ingredient(name,quantity);
	}
	
	@WebMethod(operationName = "getIngredient5")
	public Ingredient getIngredient5(@WebParam(name = "id")int id, @WebParam(name = "name")String name, @WebParam(name = "quantity")double quantity) {
		return new Ingredient(id, name, quantity);
	}
	
	//Recipe
	
	@WebMethod(operationName = "getRecipe1")
	public Recipe getRecipe1(@WebParam(name = "id")int id, @WebParam(name = "name")String name) {
		return new Recipe(id, name);
	}
	
	@WebMethod(operationName = "getRecipe2")
	public Recipe getRecipe2(@WebParam(name = "name")String name, @WebParam(name = "preparationTime")int preparationTime, @WebParam(name = "cookingTime")int cookingTime, @WebParam(name = "quantity")int quantity, @WebParam(name = "account")int account,
			@WebParam(name = "difficulty")int difficulty, @WebParam(name = "type")int type) {
		return new Recipe(name, preparationTime, cookingTime, quantity, account,
				difficulty, type);
	}
	
	@WebMethod(operationName = "getRecipe3")
	public Recipe getRecipe3(@WebParam(name = "id")int id, @WebParam(name = "name")String name, @WebParam(name = "preparationTime")int preparationTime, @WebParam(name = "cookingTime")int cookingTime, @WebParam(name = "likeNumber")int likeNumber, @WebParam(name = "quantity")int quantity, @WebParam(name = "account")int account,
			@WebParam(name = "difficulty")int difficulty, @WebParam(name = "type")int type) {
		return new Recipe(id, name, preparationTime, cookingTime, likeNumber, quantity, account,
				difficulty, type);
	}
	
	@WebMethod(operationName = "getRecipe4")
	public Recipe getRecipe4(@WebParam(name = "id")int id, @WebParam(name = "name")String name, @WebParam(name = "preparationTime")int preparationTime, @WebParam(name = "cookingTime")int cookingTime, @WebParam(name = "likeNumber")int likeNumber, @WebParam(name = "quantity")int quantity, @WebParam(name = "account")int account,
			@WebParam(name = "difficulty")int difficulty, @WebParam(name = "type")int type, @WebParam(name = "tagsID")List<Tag> tagsID) {
		return new Recipe(id, name, preparationTime, cookingTime, likeNumber, quantity, account,
				difficulty, type, tagsID);
	}
	
	//RecipeType
	
	@WebMethod(operationName = "getRecipeType1")
	public RecipeType getRecipeType1(@WebParam(name = "name")String name) {
		return new RecipeType(name);
	}
	
	@WebMethod(operationName = "getRecipeType2")
	public RecipeType getRecipeType2(@WebParam(name = "id")int id, @WebParam(name = "name")String name) {
		return new RecipeType(id,name);
	}
	
	//Step
	
    @WebMethod(operationName = "getStep1")
    public Step getStep1(@WebParam(name = "content") String content) {
        return new Step(content);
    }
    
    @WebMethod(operationName = "getStep2")
    public Step getStep2(@WebParam(name = "id") int id, @WebParam(name = "content") String content) {
        return new Step(id, content);
    }
    
    //Tag
    
    @WebMethod(operationName = "getTag1")
    public Tag getTag1(@WebParam(name = "id") int id) {
        return new Tag(id);
    }
    
    @WebMethod(operationName = "getTag2")
    public Tag getTag2(@WebParam(name = "name") String name) {
        return new Tag(name);
    }
    
    @WebMethod(operationName = "getTag3")
    public Tag getTag3(@WebParam(name = "id") int id, @WebParam(name = "name") String name) {
        return new Tag(id, name);
    }
    
    //Ustensil
    
    @WebMethod(operationName = "getUstensil1")
    public Ustensil getUstensil1(@WebParam(name = "id") int id) {
        return new Ustensil(id);
    }
    
    @WebMethod(operationName = "getUstensil2")
    public Ustensil getUstensil2(@WebParam(name = "name") String name) {
        return new Ustensil(name);
    }
    
    @WebMethod(operationName = "getUstensil3")
    public Ustensil getUstensil3(@WebParam(name = "id") int id, @WebParam(name = "name") String name) {
        return new Ustensil(id, name);
    }
    
    // --- Fin Constructeurs ---
    
    // --- Managers ---
    
	//AccountManager
    
	@WebMethod(operationName = "addAccount")
	public void addAccount(@WebParam(name = "account") Account account) {
		AccountManager.addAccount(account);
	}
	
	@WebMethod(operationName = "getCurrentAccountId")
	public int getCurrentAccountId(@WebParam(name = "userLogin") String userLogin) {
		return AccountManager.getCurrentAccountId(userLogin);
	}
	
	@WebMethod(operationName = "getAccounts")
	public List<Account> getAccounts(){
		return AccountManager.getAccounts();
	}
	
	@WebMethod(operationName = "isAvailable")
	public List<Boolean> isAvailable(@WebParam(name = "email") String email, @WebParam(name = "login") String login) {
		return AccountManager.isAvailable(email, login);
	}
	
	@WebMethod(operationName = "getAccountById")
	public Account getAccountById(@WebParam(name = "recipeId") int recipeId) {
		return AccountManager.getAccountById(recipeId);
	}
	
	//DifficultyManager
	
	@WebMethod(operationName = "getDifficulties")
	public List<Difficulty> getDifficulties(){
		return DifficultyManager.getDifficulties();
	}
	
	@WebMethod(operationName = "getDifficultyById")
	public Difficulty getDifficultyById(@WebParam(name = "recipeId") int recipeId) {
		return DifficultyManager.getDifficultyById(recipeId);
	}
	
	//FavoriteManager
	
	@WebMethod(operationName = "addFavorite")
	public void addFavorite(@WebParam(name = "accountId") int accountId, @WebParam(name = "recipeId") int recipeId) {
		FavoriteManager.addFavorite(accountId, recipeId);
	}
	
	@WebMethod(operationName = "removeFavorite")
	public void removeFavorite(@WebParam(name = "accountId") int accountId, @WebParam(name = "recipeId") int recipeId) {
		FavoriteManager.removeFavorite(accountId, recipeId);
	}
	
	@WebMethod(operationName = "getFavorites")
	public List<Recipe> getFavorites(@WebParam(name = "accountId") int accountId){
		return FavoriteManager.getFavorites(accountId);
	}
	
	@WebMethod(operationName = "isFavorite")
	public boolean isFavorite(@WebParam(name = "accountId") int accountId, @WebParam(name = "recipeId") int recipeId){
		return FavoriteManager.isFavorite(accountId, recipeId);
	}
	
	//IngredientManager
	
	@WebMethod(operationName = "getIngredients")
	public List<Ingredient> getIngredients(){
		return IngredientManager.getIngredients();
	}
	
	@WebMethod(operationName = "addIngredient")
	public void addIngredient(@WebParam(name = "ingredient") Ingredient ingredient, @WebParam(name = "quantity") int quantity, @WebParam(name = "recipeId") int recipeId) {
		IngredientManager.addIngredient(ingredient, quantity, recipeId);
	}
	
	@WebMethod(operationName = "getIngredientsById")
	public List<Ingredient> getIngredientsById(@WebParam(name = "recipeId") int recipeId) {
		return IngredientManager.getIngredientsById(recipeId);
	}
	
	//RecipeManager
	
	@WebMethod(operationName = "addRecipe")
	public void addRecipe(@WebParam(name = "recipe") Recipe recipe) {
		RecipeManager.addRecipe(recipe);
	}
	
	@WebMethod(operationName = "getLastRecipeId")
	public int getLastRecipeId() {
		return RecipeManager.getLastRecipeId();
	}
	
	@WebMethod(operationName = "getRecipeById")
	public Recipe getRecipeById(@WebParam(name = "recipeId") int recipeId) {
		return RecipeManager.getRecipeById(recipeId);
	}
	
	@WebMethod(operationName = "getRecipes")
	public List<Recipe> getRecipes(@WebParam(name = "maxDifficulty") int maxDifficulty, @WebParam(name = "recipeType") int recipeType, @WebParam(name = "maxCookingTime") int maxCookingTime, @WebParam(name = "keyWord") String keyWord){
		return RecipeManager.getRecipes(maxDifficulty, recipeType, maxCookingTime, keyWord);
	}
	
	@WebMethod(operationName = "getRandomRecipes")
	public List<Recipe> getRandomRecipes(@WebParam(name = "recipeNumber") int recipeNumber){
		return RecipeManager.getRandomRecipes(recipeNumber);
	}
	
	@WebMethod(operationName = "getRecipesbyAccountId")
	public List<Recipe> getRecipesbyAccountId(@WebParam(name = "accountId") int accountId){
		return RecipeManager.getRecipesbyAccountId(accountId);
	}
	
	//RecipeTypeIngredient
	
	@WebMethod(operationName = "getRecipeTypes")
	public List<RecipeType> getRecipeTypes(){
		return RecipeTypeManager.getRecipeTypes();
	}
	
	@WebMethod(operationName = "getTypeById")
	public RecipeType getTypeById(@WebParam(name = "recipeId") int recipeId) {
		return RecipeTypeManager.getTypeById(recipeId);
	}
	
	//StepManager
	
	@WebMethod(operationName = "addStep")
	public void addStep(@WebParam(name = "step") Step step, @WebParam(name = "order") int order, @WebParam(name = "recipeId") int recipeId) {
		StepManager.addStep(step, order, recipeId);
	}
	
	@WebMethod(operationName = "getLastStepId")
	public int getLastStepId() {
		return StepManager.getLastStepId();
	}
	
	@WebMethod(operationName = "getStepsById")
	public List<Step> getStepsById(@WebParam(name = "recipeId") int recipeId) {
		return StepManager.getStepsById(recipeId);
	}
	
	//TagManager
	
	@WebMethod(operationName = "getTags")
	public List<Tag> getTags(){
		return TagManager.getTags();
	}
	
	@WebMethod(operationName = "addTag")
	public void addTag(@WebParam(name = "tag") Tag tag, @WebParam(name = "recipeId") int recipeId) {
		TagManager.addTag(tag, recipeId);
	}
	
	@WebMethod(operationName = "getTagsById")
	public List<Tag> getTagsById(@WebParam(name = "recipeId") int recipeId) {
		return TagManager.getTagsById(recipeId);
	}
	
	//UstensilManager
	
	@WebMethod(operationName = "getUstensils")
	public List<Ustensil> getUstensils(){
		return UstensilManager.getUstensils();
	}
	
	@WebMethod(operationName = "addUstensil")
	public void addUstensil(@WebParam(name = "ustensil") Ustensil ustensil, @WebParam(name = "quantity") int quantity, @WebParam(name = "recipeId") int recipeId) {
		UstensilManager.addUstensil(ustensil, quantity, recipeId);
	}
	
	@WebMethod(operationName = "getUstensilsById")
	public List<Ustensil> getUstensilsById(@WebParam(name = "recipeId") int recipeId) {
		return UstensilManager.getUstensilsById(recipeId);
	}
	
	//Authentication
	
	@WebMethod(operationName = "access")
	public boolean access(@WebParam(name = "userLogin") String userLogin, @WebParam(name = "password") String password) {
		return Authentication.access(userLogin, password);
	}
	
	@WebMethod(operationName = "encrypt")
	public String encrypt(@WebParam(name = "password") String password) {
		return Authentication.encrypt(password);
	}
	
	@WebMethod(operationName = "mailIsValid")
	public boolean mailIsValid(@WebParam(name = "email") String email) {
		return Authentication.mailIsValid(email);
	}
}
