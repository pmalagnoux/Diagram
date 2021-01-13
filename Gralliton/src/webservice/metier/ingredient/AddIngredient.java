
package webservice.metier.ingredient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour addIngredient complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="addIngredient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ingredient" type="{http://ingredient.metier.webService/}ingredient" minOccurs="0"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "addIngredient", propOrder = {
    "ingredient",
    "quantity",
    "recipeId"
})
public class AddIngredient {

    protected Ingredient ingredient;
    protected int quantity;
    protected int recipeId;

    /**
     * Obtient la valeur de la propri�t� ingredient.
     * 
     * @return
     *     possible object is
     *     {@link Ingredient }
     *     
     */
    public Ingredient getIngredient() {
        return ingredient;
    }

    /**
     * D�finit la valeur de la propri�t� ingredient.
     * 
     * @param value
     *     allowed object is
     *     {@link Ingredient }
     *     
     */
    public void setIngredient(Ingredient value) {
        this.ingredient = value;
    }

    /**
     * Obtient la valeur de la propri�t� quantity.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * D�finit la valeur de la propri�t� quantity.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * Obtient la valeur de la propri�t� recipeId.
     * 
     */
    public int getRecipeId() {
        return recipeId;
    }

    /**
     * D�finit la valeur de la propri�t� recipeId.
     * 
     */
    public void setRecipeId(int value) {
        this.recipeId = value;
    }

}
