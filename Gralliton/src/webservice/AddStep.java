
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour addStep complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="addStep">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="step" type="{http://webservice/}step" minOccurs="0"/>
 *         &lt;element name="order" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "addStep", propOrder = {
    "step",
    "order",
    "recipeId"
})
public class AddStep {

    protected Step step;
    protected int order;
    protected int recipeId;

    /**
     * Obtient la valeur de la propri�t� step.
     * 
     * @return
     *     possible object is
     *     {@link Step }
     *     
     */
    public Step getStep() {
        return step;
    }

    /**
     * D�finit la valeur de la propri�t� step.
     * 
     * @param value
     *     allowed object is
     *     {@link Step }
     *     
     */
    public void setStep(Step value) {
        this.step = value;
    }

    /**
     * Obtient la valeur de la propri�t� order.
     * 
     */
    public int getOrder() {
        return order;
    }

    /**
     * D�finit la valeur de la propri�t� order.
     * 
     */
    public void setOrder(int value) {
        this.order = value;
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
