
package webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WebServiceSOAPService", targetNamespace = "http://webservice/", wsdlLocation = "http://localhost:8686/?wsdl")
public class WebServiceSOAPService
    extends Service
{

    private final static URL WEBSERVICESOAPSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICESOAPSERVICE_EXCEPTION;
    private final static QName WEBSERVICESOAPSERVICE_QNAME = new QName("http://webservice/", "WebServiceSOAPService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8686/?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICESOAPSERVICE_WSDL_LOCATION = url;
        WEBSERVICESOAPSERVICE_EXCEPTION = e;
    }

    public WebServiceSOAPService() {
        super(__getWsdlLocation(), WEBSERVICESOAPSERVICE_QNAME);
    }

    public WebServiceSOAPService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICESOAPSERVICE_QNAME, features);
    }

    public WebServiceSOAPService(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICESOAPSERVICE_QNAME);
    }

    public WebServiceSOAPService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICESOAPSERVICE_QNAME, features);
    }

    public WebServiceSOAPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServiceSOAPService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WS
     */
    @WebEndpoint(name = "WSPort")
    public WS getWSPort() {
        return super.getPort(new QName("http://webservice/", "WSPort"), WS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WS
     */
    @WebEndpoint(name = "WSPort")
    public WS getWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice/", "WSPort"), WS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICESOAPSERVICE_EXCEPTION!= null) {
            throw WEBSERVICESOAPSERVICE_EXCEPTION;
        }
        return WEBSERVICESOAPSERVICE_WSDL_LOCATION;
    }

}
