
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
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

    private final static QName _EncryptResponse_QNAME = new QName("http://webService/", "encryptResponse");
    private final static QName _Encrypt_QNAME = new QName("http://webService/", "encrypt");
    private final static QName _MailIsValid_QNAME = new QName("http://webService/", "mailIsValid");
    private final static QName _MailIsValidResponse_QNAME = new QName("http://webService/", "mailIsValidResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EncryptResponse }
     * 
     */
    public EncryptResponse createEncryptResponse() {
        return new EncryptResponse();
    }

    /**
     * Create an instance of {@link Encrypt }
     * 
     */
    public Encrypt createEncrypt() {
        return new Encrypt();
    }

    /**
     * Create an instance of {@link MailIsValid }
     * 
     */
    public MailIsValid createMailIsValid() {
        return new MailIsValid();
    }

    /**
     * Create an instance of {@link MailIsValidResponse }
     * 
     */
    public MailIsValidResponse createMailIsValidResponse() {
        return new MailIsValidResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EncryptResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "encryptResponse")
    public JAXBElement<EncryptResponse> createEncryptResponse(EncryptResponse value) {
        return new JAXBElement<EncryptResponse>(_EncryptResponse_QNAME, EncryptResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Encrypt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "encrypt")
    public JAXBElement<Encrypt> createEncrypt(Encrypt value) {
        return new JAXBElement<Encrypt>(_Encrypt_QNAME, Encrypt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MailIsValid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "mailIsValid")
    public JAXBElement<MailIsValid> createMailIsValid(MailIsValid value) {
        return new JAXBElement<MailIsValid>(_MailIsValid_QNAME, MailIsValid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MailIsValidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "mailIsValidResponse")
    public JAXBElement<MailIsValidResponse> createMailIsValidResponse(MailIsValidResponse value) {
        return new JAXBElement<MailIsValidResponse>(_MailIsValidResponse_QNAME, MailIsValidResponse.class, null, value);
    }

}
