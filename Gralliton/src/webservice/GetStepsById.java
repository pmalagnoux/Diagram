
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getStepsById complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getStepsById">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recipeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStepsById", propOrder = {
    "recipeId"
})
public class GetStepsById {

    protected int recipeId;

    /**
     * Obtient la valeur de la propriété recipeId.
     * 
     */
    public int getRecipeId() {
        return recipeId;
    }

    /**
     * Définit la valeur de la propriété recipeId.
     * 
     */
    public void setRecipeId(int value) {
        this.recipeId = value;
    }

}
