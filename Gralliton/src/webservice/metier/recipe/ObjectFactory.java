
package webservice.metier.recipe;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice.metier.recipe package. 
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

    private final static QName _GetRecipesResponse_QNAME = new QName("http://recipe.metier.webService/", "getRecipesResponse");
    private final static QName _AddRecipe_QNAME = new QName("http://recipe.metier.webService/", "addRecipe");
    private final static QName _AddRecipeResponse_QNAME = new QName("http://recipe.metier.webService/", "addRecipeResponse");
    private final static QName _GetRecipes_QNAME = new QName("http://recipe.metier.webService/", "getRecipes");
    private final static QName _GetLastRecipeIdResponse_QNAME = new QName("http://recipe.metier.webService/", "getLastRecipeIdResponse");
    private final static QName _GetLastRecipeId_QNAME = new QName("http://recipe.metier.webService/", "getLastRecipeId");
    private final static QName _Recipe_QNAME = new QName("http://recipe.metier.webService/", "recipe");
    private final static QName _Tag_QNAME = new QName("http://recipe.metier.webService/", "tag");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice.metier.recipe
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddRecipe }
     * 
     */
    public AddRecipe createAddRecipe() {
        return new AddRecipe();
    }

    /**
     * Create an instance of {@link GetRecipesResponse }
     * 
     */
    public GetRecipesResponse createGetRecipesResponse() {
        return new GetRecipesResponse();
    }

    /**
     * Create an instance of {@link GetLastRecipeId }
     * 
     */
    public GetLastRecipeId createGetLastRecipeId() {
        return new GetLastRecipeId();
    }

    /**
     * Create an instance of {@link Recipe }
     * 
     */
    public Recipe createRecipe() {
        return new Recipe();
    }

    /**
     * Create an instance of {@link GetLastRecipeIdResponse }
     * 
     */
    public GetLastRecipeIdResponse createGetLastRecipeIdResponse() {
        return new GetLastRecipeIdResponse();
    }

    /**
     * Create an instance of {@link Tag }
     * 
     */
    public Tag createTag() {
        return new Tag();
    }

    /**
     * Create an instance of {@link AddRecipeResponse }
     * 
     */
    public AddRecipeResponse createAddRecipeResponse() {
        return new AddRecipeResponse();
    }

    /**
     * Create an instance of {@link GetRecipes }
     * 
     */
    public GetRecipes createGetRecipes() {
        return new GetRecipes();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecipesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://recipe.metier.webService/", name = "getRecipesResponse")
    public JAXBElement<GetRecipesResponse> createGetRecipesResponse(GetRecipesResponse value) {
        return new JAXBElement<GetRecipesResponse>(_GetRecipesResponse_QNAME, GetRecipesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRecipe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://recipe.metier.webService/", name = "addRecipe")
    public JAXBElement<AddRecipe> createAddRecipe(AddRecipe value) {
        return new JAXBElement<AddRecipe>(_AddRecipe_QNAME, AddRecipe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRecipeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://recipe.metier.webService/", name = "addRecipeResponse")
    public JAXBElement<AddRecipeResponse> createAddRecipeResponse(AddRecipeResponse value) {
        return new JAXBElement<AddRecipeResponse>(_AddRecipeResponse_QNAME, AddRecipeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecipes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://recipe.metier.webService/", name = "getRecipes")
    public JAXBElement<GetRecipes> createGetRecipes(GetRecipes value) {
        return new JAXBElement<GetRecipes>(_GetRecipes_QNAME, GetRecipes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastRecipeIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://recipe.metier.webService/", name = "getLastRecipeIdResponse")
    public JAXBElement<GetLastRecipeIdResponse> createGetLastRecipeIdResponse(GetLastRecipeIdResponse value) {
        return new JAXBElement<GetLastRecipeIdResponse>(_GetLastRecipeIdResponse_QNAME, GetLastRecipeIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastRecipeId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://recipe.metier.webService/", name = "getLastRecipeId")
    public JAXBElement<GetLastRecipeId> createGetLastRecipeId(GetLastRecipeId value) {
        return new JAXBElement<GetLastRecipeId>(_GetLastRecipeId_QNAME, GetLastRecipeId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Recipe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://recipe.metier.webService/", name = "recipe")
    public JAXBElement<Recipe> createRecipe(Recipe value) {
        return new JAXBElement<Recipe>(_Recipe_QNAME, Recipe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tag }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://recipe.metier.webService/", name = "tag")
    public JAXBElement<Tag> createTag(Tag value) {
        return new JAXBElement<Tag>(_Tag_QNAME, Tag.class, null, value);
    }

}
