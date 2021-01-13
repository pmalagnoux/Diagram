
package webservice.metier.recipetype;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice.metier.recipetype package. 
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

    private final static QName _RecipeType_QNAME = new QName("http://recipeType.metier.webService/", "recipeType");
    private final static QName _GetRecipeTypes_QNAME = new QName("http://recipeType.metier.webService/", "getRecipeTypes");
    private final static QName _GetRecipeTypesResponse_QNAME = new QName("http://recipeType.metier.webService/", "getRecipeTypesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice.metier.recipetype
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRecipeTypes }
     * 
     */
    public GetRecipeTypes createGetRecipeTypes() {
        return new GetRecipeTypes();
    }

    /**
     * Create an instance of {@link RecipeType }
     * 
     */
    public RecipeType createRecipeType() {
        return new RecipeType();
    }

    /**
     * Create an instance of {@link GetRecipeTypesResponse }
     * 
     */
    public GetRecipeTypesResponse createGetRecipeTypesResponse() {
        return new GetRecipeTypesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecipeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://recipeType.metier.webService/", name = "recipeType")
    public JAXBElement<RecipeType> createRecipeType(RecipeType value) {
        return new JAXBElement<RecipeType>(_RecipeType_QNAME, RecipeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecipeTypes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://recipeType.metier.webService/", name = "getRecipeTypes")
    public JAXBElement<GetRecipeTypes> createGetRecipeTypes(GetRecipeTypes value) {
        return new JAXBElement<GetRecipeTypes>(_GetRecipeTypes_QNAME, GetRecipeTypes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecipeTypesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://recipeType.metier.webService/", name = "getRecipeTypesResponse")
    public JAXBElement<GetRecipeTypesResponse> createGetRecipeTypesResponse(GetRecipeTypesResponse value) {
        return new JAXBElement<GetRecipeTypesResponse>(_GetRecipeTypesResponse_QNAME, GetRecipeTypesResponse.class, null, value);
    }

}
