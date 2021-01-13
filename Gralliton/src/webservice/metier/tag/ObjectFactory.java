
package webservice.metier.tag;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice.metier.tag package. 
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

    private final static QName _GetTagsResponse_QNAME = new QName("http://tag.metier.webService/", "getTagsResponse");
    private final static QName _Tag_QNAME = new QName("http://tag.metier.webService/", "tag");
    private final static QName _GetTags_QNAME = new QName("http://tag.metier.webService/", "getTags");
    private final static QName _AddTagResponse_QNAME = new QName("http://tag.metier.webService/", "addTagResponse");
    private final static QName _AddTag_QNAME = new QName("http://tag.metier.webService/", "addTag");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice.metier.tag
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTagsResponse }
     * 
     */
    public GetTagsResponse createGetTagsResponse() {
        return new GetTagsResponse();
    }

    /**
     * Create an instance of {@link GetTags }
     * 
     */
    public GetTags createGetTags() {
        return new GetTags();
    }

    /**
     * Create an instance of {@link Tag }
     * 
     */
    public Tag createTag() {
        return new Tag();
    }

    /**
     * Create an instance of {@link AddTag }
     * 
     */
    public AddTag createAddTag() {
        return new AddTag();
    }

    /**
     * Create an instance of {@link AddTagResponse }
     * 
     */
    public AddTagResponse createAddTagResponse() {
        return new AddTagResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTagsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tag.metier.webService/", name = "getTagsResponse")
    public JAXBElement<GetTagsResponse> createGetTagsResponse(GetTagsResponse value) {
        return new JAXBElement<GetTagsResponse>(_GetTagsResponse_QNAME, GetTagsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tag }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tag.metier.webService/", name = "tag")
    public JAXBElement<Tag> createTag(Tag value) {
        return new JAXBElement<Tag>(_Tag_QNAME, Tag.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTags }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tag.metier.webService/", name = "getTags")
    public JAXBElement<GetTags> createGetTags(GetTags value) {
        return new JAXBElement<GetTags>(_GetTags_QNAME, GetTags.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTagResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tag.metier.webService/", name = "addTagResponse")
    public JAXBElement<AddTagResponse> createAddTagResponse(AddTagResponse value) {
        return new JAXBElement<AddTagResponse>(_AddTagResponse_QNAME, AddTagResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTag }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tag.metier.webService/", name = "addTag")
    public JAXBElement<AddTag> createAddTag(AddTag value) {
        return new JAXBElement<AddTag>(_AddTag_QNAME, AddTag.class, null, value);
    }

}
