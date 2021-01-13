
package webservice.metier.ingredient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice.metier.ingredient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetIngredients_QNAME = new QName("http://ingredient.metier.webService/", "getIngredients");
    private final static QName _GetIngredientsResponse_QNAME = new QName("http://ingredient.metier.webService/", "getIngredientsResponse");
    private final static QName _AddIngredientResponse_QNAME = new QName("http://ingredient.metier.webService/", "addIngredientResponse");
    private final static QName _Ingredient_QNAME = new QName("http://ingredient.metier.webService/", "ingredient");
    private final static QName _AddIngredient_QNAME = new QName("http://ingredient.metier.webService/", "addIngredient");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice.metier.ingredient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddIngredientResponse }
     * 
     */
    public AddIngredientResponse createAddIngredientResponse() {
        return new AddIngredientResponse();
    }

    /**
     * Create an instance of {@link Ingredient }
     * 
     */
    public Ingredient createIngredient() {
        return new Ingredient();
    }

    /**
     * Create an instance of {@link AddIngredient }
     * 
     */
    public AddIngredient createAddIngredient() {
        return new AddIngredient();
    }

    /**
     * Create an instance of {@link GetIngredientsResponse }
     * 
     */
    public GetIngredientsResponse createGetIngredientsResponse() {
        return new GetIngredientsResponse();
    }

    /**
     * Create an instance of {@link GetIngredients }
     * 
     */
    public GetIngredients createGetIngredients() {
        return new GetIngredients();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIngredients }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ingredient.metier.webService/", name = "getIngredients")
    public JAXBElement<GetIngredients> createGetIngredients(GetIngredients value) {
        return new JAXBElement<GetIngredients>(_GetIngredients_QNAME, GetIngredients.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIngredientsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ingredient.metier.webService/", name = "getIngredientsResponse")
    public JAXBElement<GetIngredientsResponse> createGetIngredientsResponse(GetIngredientsResponse value) {
        return new JAXBElement<GetIngredientsResponse>(_GetIngredientsResponse_QNAME, GetIngredientsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddIngredientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ingredient.metier.webService/", name = "addIngredientResponse")
    public JAXBElement<AddIngredientResponse> createAddIngredientResponse(AddIngredientResponse value) {
        return new JAXBElement<AddIngredientResponse>(_AddIngredientResponse_QNAME, AddIngredientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ingredient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ingredient.metier.webService/", name = "ingredient")
    public JAXBElement<Ingredient> createIngredient(Ingredient value) {
        return new JAXBElement<Ingredient>(_Ingredient_QNAME, Ingredient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddIngredient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ingredient.metier.webService/", name = "addIngredient")
    public JAXBElement<AddIngredient> createAddIngredient(AddIngredient value) {
        return new JAXBElement<AddIngredient>(_AddIngredient_QNAME, AddIngredient.class, null, value);
    }

}
