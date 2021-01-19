
package webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getRecipe4 complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getRecipe4">
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
 *         &lt;element name="tagsID" type="{http://webservice/}tag" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRecipe4", propOrder = {
    "id",
    "name",
    "preparationTime",
    "cookingTime",
    "likeNumber",
    "quantity",
    "account",
    "difficulty",
    "type",
    "tagsID"
})
public class GetRecipe4 {

    protected int id;
    protected String name;
    protected int preparationTime;
    protected int cookingTime;
    protected int likeNumber;
    protected int quantity;
    protected int account;
    protected int difficulty;
    protected int type;
    protected List<Tag> tagsID;

    /**
     * Obtient la valeur de la propri�t� id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * D�finit la valeur de la propri�t� id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propri�t� name.
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
     * D�finit la valeur de la propri�t� name.
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
     * Obtient la valeur de la propri�t� preparationTime.
     * 
     */
    public int getPreparationTime() {
        return preparationTime;
    }

    /**
     * D�finit la valeur de la propri�t� preparationTime.
     * 
     */
    public void setPreparationTime(int value) {
        this.preparationTime = value;
    }

    /**
     * Obtient la valeur de la propri�t� cookingTime.
     * 
     */
    public int getCookingTime() {
        return cookingTime;
    }

    /**
     * D�finit la valeur de la propri�t� cookingTime.
     * 
     */
    public void setCookingTime(int value) {
        this.cookingTime = value;
    }

    /**
     * Obtient la valeur de la propri�t� likeNumber.
     * 
     */
    public int getLikeNumber() {
        return likeNumber;
    }

    /**
     * D�finit la valeur de la propri�t� likeNumber.
     * 
     */
    public void setLikeNumber(int value) {
        this.likeNumber = value;
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
     * Obtient la valeur de la propri�t� account.
     * 
     */
    public int getAccount() {
        return account;
    }

    /**
     * D�finit la valeur de la propri�t� account.
     * 
     */
    public void setAccount(int value) {
        this.account = value;
    }

    /**
     * Obtient la valeur de la propri�t� difficulty.
     * 
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * D�finit la valeur de la propri�t� difficulty.
     * 
     */
    public void setDifficulty(int value) {
        this.difficulty = value;
    }

    /**
     * Obtient la valeur de la propri�t� type.
     * 
     */
    public int getType() {
        return type;
    }

    /**
     * D�finit la valeur de la propri�t� type.
     * 
     */
    public void setType(int value) {
        this.type = value;
    }

    /**
     * Gets the value of the tagsID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tagsID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTagsID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tag }
     * 
     * 
     */
    public List<Tag> getTagsID() {
        if (tagsID == null) {
            tagsID = new ArrayList<Tag>();
        }
        return this.tagsID;
    }

}
