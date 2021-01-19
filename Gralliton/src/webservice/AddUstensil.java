
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour addUstensil complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="addUstensil">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ustensil" type="{http://webservice/}ustensil" minOccurs="0"/>
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
@XmlType(name = "addUstensil", propOrder = {
    "ustensil",
    "quantity",
    "recipeId"
})
public class AddUstensil {

    protected Ustensil ustensil;
    protected int quantity;
    protected int recipeId;

    /**
     * Obtient la valeur de la propriété ustensil.
     * 
     * @return
     *     possible object is
     *     {@link Ustensil }
     *     
     */
    public Ustensil getUstensil() {
        return ustensil;
    }

    /**
     * Définit la valeur de la propriété ustensil.
     * 
     * @param value
     *     allowed object is
     *     {@link Ustensil }
     *     
     */
    public void setUstensil(Ustensil value) {
        this.ustensil = value;
    }

    /**
     * Obtient la valeur de la propriété quantity.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Définit la valeur de la propriété quantity.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

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
