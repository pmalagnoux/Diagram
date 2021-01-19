
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getRandomRecipes complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getRandomRecipes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recipeNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRandomRecipes", propOrder = {
    "recipeNumber"
})
public class GetRandomRecipes {

    protected int recipeNumber;

    /**
     * Obtient la valeur de la propriété recipeNumber.
     * 
     */
    public int getRecipeNumber() {
        return recipeNumber;
    }

    /**
     * Définit la valeur de la propriété recipeNumber.
     * 
     */
    public void setRecipeNumber(int value) {
        this.recipeNumber = value;
    }

}
