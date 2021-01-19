
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getRecipes complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getRecipes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="maxDifficulty" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recipeType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxCookingTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keyWord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "maxCookingTime",
    "keyWord"
})
public class GetRecipes {

    protected int maxDifficulty;
    protected int recipeType;
    protected int maxCookingTime;
    protected String keyWord;

    /**
     * Obtient la valeur de la propriété maxDifficulty.
     * 
     */
    public int getMaxDifficulty() {
        return maxDifficulty;
    }

    /**
     * Définit la valeur de la propriété maxDifficulty.
     * 
     */
    public void setMaxDifficulty(int value) {
        this.maxDifficulty = value;
    }

    /**
     * Obtient la valeur de la propriété recipeType.
     * 
     */
    public int getRecipeType() {
        return recipeType;
    }

    /**
     * Définit la valeur de la propriété recipeType.
     * 
     */
    public void setRecipeType(int value) {
        this.recipeType = value;
    }

    /**
     * Obtient la valeur de la propriété maxCookingTime.
     * 
     */
    public int getMaxCookingTime() {
        return maxCookingTime;
    }

    /**
     * Définit la valeur de la propriété maxCookingTime.
     * 
     */
    public void setMaxCookingTime(int value) {
        this.maxCookingTime = value;
    }

    /**
     * Obtient la valeur de la propriété keyWord.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * Définit la valeur de la propriété keyWord.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyWord(String value) {
        this.keyWord = value;
    }

}
