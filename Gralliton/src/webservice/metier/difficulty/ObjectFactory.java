
package webservice.metier.difficulty;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice.metier.difficulty package. 
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

    private final static QName _GetDifficultiesResponse_QNAME = new QName("http://difficulty.metier.webService/", "getDifficultiesResponse");
    private final static QName _Difficulty_QNAME = new QName("http://difficulty.metier.webService/", "difficulty");
    private final static QName _GetDifficulties_QNAME = new QName("http://difficulty.metier.webService/", "getDifficulties");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice.metier.difficulty
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Difficulty }
     * 
     */
    public Difficulty createDifficulty() {
        return new Difficulty();
    }

    /**
     * Create an instance of {@link GetDifficulties }
     * 
     */
    public GetDifficulties createGetDifficulties() {
        return new GetDifficulties();
    }

    /**
     * Create an instance of {@link GetDifficultiesResponse }
     * 
     */
    public GetDifficultiesResponse createGetDifficultiesResponse() {
        return new GetDifficultiesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDifficultiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://difficulty.metier.webService/", name = "getDifficultiesResponse")
    public JAXBElement<GetDifficultiesResponse> createGetDifficultiesResponse(GetDifficultiesResponse value) {
        return new JAXBElement<GetDifficultiesResponse>(_GetDifficultiesResponse_QNAME, GetDifficultiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Difficulty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://difficulty.metier.webService/", name = "difficulty")
    public JAXBElement<Difficulty> createDifficulty(Difficulty value) {
        return new JAXBElement<Difficulty>(_Difficulty_QNAME, Difficulty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDifficulties }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://difficulty.metier.webService/", name = "getDifficulties")
    public JAXBElement<GetDifficulties> createGetDifficulties(GetDifficulties value) {
        return new JAXBElement<GetDifficulties>(_GetDifficulties_QNAME, GetDifficulties.class, null, value);
    }

}
