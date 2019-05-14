
package client;

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
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WebDataImplService", targetNamespace = "http://ws/", wsdlLocation = "http://localhost:8082/ws/webdata?wsdl")
public class WebDataImplService
    extends Service
{

    private final static URL WEBDATAIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBDATAIMPLSERVICE_EXCEPTION;
    private final static QName WEBDATAIMPLSERVICE_QNAME = new QName("http://ws/", "WebDataImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8082/ws/webdata?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBDATAIMPLSERVICE_WSDL_LOCATION = url;
        WEBDATAIMPLSERVICE_EXCEPTION = e;
    }

    public WebDataImplService() {
        super(__getWsdlLocation(), WEBDATAIMPLSERVICE_QNAME);
    }

    public WebDataImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBDATAIMPLSERVICE_QNAME, features);
    }

    public WebDataImplService(URL wsdlLocation) {
        super(wsdlLocation, WEBDATAIMPLSERVICE_QNAME);
    }

    public WebDataImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBDATAIMPLSERVICE_QNAME, features);
    }

    public WebDataImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebDataImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebData
     */
    @WebEndpoint(name = "WebDataImplPort")
    public WebData getWebDataImplPort() {
        return super.getPort(new QName("http://ws/", "WebDataImplPort"), WebData.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebData
     */
    @WebEndpoint(name = "WebDataImplPort")
    public WebData getWebDataImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws/", "WebDataImplPort"), WebData.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBDATAIMPLSERVICE_EXCEPTION!= null) {
            throw WEBDATAIMPLSERVICE_EXCEPTION;
        }
        return WEBDATAIMPLSERVICE_WSDL_LOCATION;
    }

}
