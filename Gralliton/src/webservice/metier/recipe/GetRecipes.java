
package webservice.metier.recipe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getRecipes complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getRecipes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="maxDifficulty" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recipeType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxCookingTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRecipes", propOrder = {
    "maxDifficulty",
    "recipeType",
    "maxCookingTime"
})
public class GetRecipes {

    protected int maxDifficulty;
    protected int recipeType;
    protected int maxCookingTime;

    /**
     * Obtient la valeur de la propri�t� maxDifficulty.
     * 
     */
    public int getMaxDifficulty() {
        return maxDifficulty;
    }

    /**
     * D�finit la valeur de la propri�t� maxDifficulty.
     * 
     */
    public void setMaxDifficulty(int value) {
        this.maxDifficulty = value;
    }

    /**
     * Obtient la valeur de la propri�t� recipeType.
     * 
     */
    public int getRecipeType() {
        return recipeType;
    }

    /**
     * D�finit la valeur de la propri�t� recipeType.
     * 
     */
    public void setRecipeType(int value) {
        this.recipeType = value;
    }

    /**
     * Obtient la valeur de la propri�t� maxCookingTime.
     * 
     */
    public int getMaxCookingTime() {
        return maxCookingTime;
    }

    /**
     * D�finit la valeur de la propri�t� maxCookingTime.
     * 
     */
    public void setMaxCookingTime(int value) {
        this.maxCookingTime = value;
    }

}
