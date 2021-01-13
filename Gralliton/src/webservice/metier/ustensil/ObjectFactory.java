
package webservice.metier.ustensil;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice.metier.ustensil package. 
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

    private final static QName _AddUstensilResponse_QNAME = new QName("http://ustensil.metier.webService/", "addUstensilResponse");
    private final static QName _Ustensil_QNAME = new QName("http://ustensil.metier.webService/", "ustensil");
    private final static QName _GetUstensils_QNAME = new QName("http://ustensil.metier.webService/", "getUstensils");
    private final static QName _GetUstensilsResponse_QNAME = new QName("http://ustensil.metier.webService/", "getUstensilsResponse");
    private final static QName _AddUstensil_QNAME = new QName("http://ustensil.metier.webService/", "addUstensil");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice.metier.ustensil
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddUstensil }
     * 
     */
    public AddUstensil createAddUstensil() {
        return new AddUstensil();
    }

    /**
     * Create an instance of {@link GetUstensilsResponse }
     * 
     */
    public GetUstensilsResponse createGetUstensilsResponse() {
        return new GetUstensilsResponse();
    }

    /**
     * Create an instance of {@link Ustensil }
     * 
     */
    public Ustensil createUstensil() {
        return new Ustensil();
    }

    /**
     * Create an instance of {@link GetUstensils }
     * 
     */
    public GetUstensils createGetUstensils() {
        return new GetUstensils();
    }

    /**
     * Create an instance of {@link AddUstensilResponse }
     * 
     */
    public AddUstensilResponse createAddUstensilResponse() {
        return new AddUstensilResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUstensilResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ustensil.metier.webService/", name = "addUstensilResponse")
    public JAXBElement<AddUstensilResponse> createAddUstensilResponse(AddUstensilResponse value) {
        return new JAXBElement<AddUstensilResponse>(_AddUstensilResponse_QNAME, AddUstensilResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ustensil }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ustensil.metier.webService/", name = "ustensil")
    public JAXBElement<Ustensil> createUstensil(Ustensil value) {
        return new JAXBElement<Ustensil>(_Ustensil_QNAME, Ustensil.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUstensils }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ustensil.metier.webService/", name = "getUstensils")
    public JAXBElement<GetUstensils> createGetUstensils(GetUstensils value) {
        return new JAXBElement<GetUstensils>(_GetUstensils_QNAME, GetUstensils.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUstensilsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ustensil.metier.webService/", name = "getUstensilsResponse")
    public JAXBElement<GetUstensilsResponse> createGetUstensilsResponse(GetUstensilsResponse value) {
        return new JAXBElement<GetUstensilsResponse>(_GetUstensilsResponse_QNAME, GetUstensilsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUstensil }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ustensil.metier.webService/", name = "addUstensil")
    public JAXBElement<AddUstensil> createAddUstensil(AddUstensil value) {
        return new JAXBElement<AddUstensil>(_AddUstensil_QNAME, AddUstensil.class, null, value);
    }

}
