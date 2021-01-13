
package webservice.metier.step;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice.metier.step package. 
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

    private final static QName _AddStepResponse_QNAME = new QName("http://step.metier.webService/", "addStepResponse");
    private final static QName _GetLastStepIdResponse_QNAME = new QName("http://step.metier.webService/", "getLastStepIdResponse");
    private final static QName _AddStep_QNAME = new QName("http://step.metier.webService/", "addStep");
    private final static QName _GetLastStepId_QNAME = new QName("http://step.metier.webService/", "getLastStepId");
    private final static QName _Step_QNAME = new QName("http://step.metier.webService/", "step");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice.metier.step
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddStep }
     * 
     */
    public AddStep createAddStep() {
        return new AddStep();
    }

    /**
     * Create an instance of {@link GetLastStepIdResponse }
     * 
     */
    public GetLastStepIdResponse createGetLastStepIdResponse() {
        return new GetLastStepIdResponse();
    }

    /**
     * Create an instance of {@link AddStepResponse }
     * 
     */
    public AddStepResponse createAddStepResponse() {
        return new AddStepResponse();
    }

    /**
     * Create an instance of {@link Step }
     * 
     */
    public Step createStep() {
        return new Step();
    }

    /**
     * Create an instance of {@link GetLastStepId }
     * 
     */
    public GetLastStepId createGetLastStepId() {
        return new GetLastStepId();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStepResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://step.metier.webService/", name = "addStepResponse")
    public JAXBElement<AddStepResponse> createAddStepResponse(AddStepResponse value) {
        return new JAXBElement<AddStepResponse>(_AddStepResponse_QNAME, AddStepResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastStepIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://step.metier.webService/", name = "getLastStepIdResponse")
    public JAXBElement<GetLastStepIdResponse> createGetLastStepIdResponse(GetLastStepIdResponse value) {
        return new JAXBElement<GetLastStepIdResponse>(_GetLastStepIdResponse_QNAME, GetLastStepIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://step.metier.webService/", name = "addStep")
    public JAXBElement<AddStep> createAddStep(AddStep value) {
        return new JAXBElement<AddStep>(_AddStep_QNAME, AddStep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastStepId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://step.metier.webService/", name = "getLastStepId")
    public JAXBElement<GetLastStepId> createGetLastStepId(GetLastStepId value) {
        return new JAXBElement<GetLastStepId>(_GetLastStepId_QNAME, GetLastStepId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Step }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://step.metier.webService/", name = "step")
    public JAXBElement<Step> createStep(Step value) {
        return new JAXBElement<Step>(_Step_QNAME, Step.class, null, value);
    }

}
