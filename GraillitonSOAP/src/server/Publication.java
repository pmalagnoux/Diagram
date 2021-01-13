package server;

import javax.xml.ws.Endpoint;

import webService.ConnectionToDB;
import webService.Securite;
import webService.metier.difficulty.DifficultyManager;
import webService.metier.ingredient.IngredientManager;
import webService.metier.recipe.RecipeManager;
import webService.metier.recipeType.RecipeTypeManager;
import webService.metier.step.StepManager;
import webService.metier.tag.TagManager;
import webService.metier.ustensil.UstensilManager;

public class Publication {
	public static void main(String[] args) {
		String url = "http://localhost:8686/Securite/";
		Endpoint.publish(url, new Securite());
		System.out.println(url);
		
		String url1 = "http://localhost:8686/DifficultyManager/";
		Endpoint.publish(url1, new DifficultyManager());
		System.out.println(url1);
		
		String url2 = "http://localhost:8686/IngredientManager/";
		Endpoint.publish(url2, new IngredientManager());
		System.out.println(url2);
		
		String url3 = "http://localhost:8686/RecipeManager/";
		Endpoint.publish(url3, new RecipeManager());
		System.out.println(url3);
		
		String url4 = "http://localhost:8686/RecipeTypeManager/";
		Endpoint.publish(url4, new RecipeTypeManager());
		System.out.println(url4);
		
		String url5 = "http://localhost:8686/StepManager/";
		Endpoint.publish(url5, new StepManager());
		System.out.println(url5);
		
		String url6 = "http://localhost:8686/TagManager/";
		Endpoint.publish(url6, new TagManager());
		System.out.println(url6);
		
		String url7 = "http://localhost:8686/UstensilManager/";
		Endpoint.publish(url7, new UstensilManager());
		System.out.println(url7);
		
		/*
		String url8 = "http://localhost:8686/ConnectionToDB/";
		Endpoint.publish(url8, new ConnectionToDB());
		System.out.println(url8);
		*/
	}
}
