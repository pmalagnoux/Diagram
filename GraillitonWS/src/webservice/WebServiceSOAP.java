package webservice;

import java.util.List;

import metier.Authentication;
import metier.account.Account;
import metier.account.AccountManager;
import metier.difficulty.Difficulty;
import metier.difficulty.DifficultyManager;
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
	public boolean[] isAvailable(@WebParam(name = "email") String email, @WebParam(name = "login") String login) {
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
