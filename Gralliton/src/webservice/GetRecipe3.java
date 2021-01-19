
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getRecipe3 complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getRecipe3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="preparationTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cookingTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="likeNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="account" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="difficulty" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRecipe3", propOrder = {
    "id",
    "name",
    "preparationTime",
    "cookingTime",
    "likeNumber",
    "quantity",
    "account",
    "difficulty",
    "type"
})
public class GetRecipe3 {

    protected int id;
    protected String name;
    protected int preparationTime;
    protected int cookingTime;
    protected int likeNumber;
    protected int quantity;
    protected int account;
    protected int difficulty;
    protected int type;

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriété preparationTime.
     * 
     */
    public int getPreparationTime() {
        return preparationTime;
    }

    /**
     * Définit la valeur de la propriété preparationTime.
     * 
     */
    public void setPreparationTime(int value) {
        this.preparationTime = value;
    }

    /**
     * Obtient la valeur de la propriété cookingTime.
     * 
     */
    public int getCookingTime() {
        return cookingTime;
    }

    /**
     * Définit la valeur de la propriété cookingTime.
     * 
     */
    public void setCookingTime(int value) {
        this.cookingTime = value;
    }

    /**
     * Obtient la valeur de la propriété likeNumber.
     * 
     */
    public int getLikeNumber() {
        return likeNumber;
    }

    /**
     * Définit la valeur de la propriété likeNumber.
     * 
     */
    public void setLikeNumber(int value) {
        this.likeNumber = value;
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
     * Obtient la valeur de la propriété difficulty.
     * 
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Définit la valeur de la propriété difficulty.
     * 
     */
    public void setDifficulty(int value) {
        this.difficulty = value;
    }

    /**
     * Obtient la valeur de la propriété type.
     * 
     */
    public int getType() {
        return type;
    }

    /**
     * Définit la valeur de la propriété type.
     * 
     */
    public void setType(int value) {
        this.type = value;
    }

}
