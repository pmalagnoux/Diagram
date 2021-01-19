
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getFavorite complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getFavorite">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="account" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recipe" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFavorite", propOrder = {
    "account",
    "recipe"
})
public class GetFavorite {

    protected int account;
    protected int recipe;

    /**
     * Obtient la valeur de la propriété account.
     * 
     */
    public int getAccount() {
        return account;
    }

    /**
     * Définit la valeur de la propriété account.
     * 
     */
    public void setAccount(int value) {
        this.account = value;
    }

    /**
     * Obtient la valeur de la propriété recipe.
     * 
     */
    public int getRecipe() {
        return recipe;
    }

    /**
     * Définit la valeur de la propriété recipe.
     * 
     */
    public void setRecipe(int value) {
        this.recipe = value;
    }

}
