
package com.utilisateur.service;

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
@WebServiceClient(name = "UtilisateurServiceService", targetNamespace = "http://service.utilisateur.com/", wsdlLocation = "http://localhost:8082/?wsdl")
public class UtilisateurServiceService
    extends Service
{

    private final static URL UTILISATEURSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException UTILISATEURSERVICESERVICE_EXCEPTION;
    private final static QName UTILISATEURSERVICESERVICE_QNAME = new QName("http://service.utilisateur.com/", "UtilisateurServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8082/?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        UTILISATEURSERVICESERVICE_WSDL_LOCATION = url;
        UTILISATEURSERVICESERVICE_EXCEPTION = e;
    }

    public UtilisateurServiceService() {
        super(__getWsdlLocation(), UTILISATEURSERVICESERVICE_QNAME);
    }

    public UtilisateurServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), UTILISATEURSERVICESERVICE_QNAME, features);
    }

    public UtilisateurServiceService(URL wsdlLocation) {
        super(wsdlLocation, UTILISATEURSERVICESERVICE_QNAME);
    }

    public UtilisateurServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, UTILISATEURSERVICESERVICE_QNAME, features);
    }

    public UtilisateurServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UtilisateurServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns UtilisateurWS
     */
    @WebEndpoint(name = "UtilisateurWSPort")
    public UtilisateurWS getUtilisateurWSPort() {
        return super.getPort(new QName("http://service.utilisateur.com/", "UtilisateurWSPort"), UtilisateurWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UtilisateurWS
     */
    @WebEndpoint(name = "UtilisateurWSPort")
    public UtilisateurWS getUtilisateurWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.utilisateur.com/", "UtilisateurWSPort"), UtilisateurWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (UTILISATEURSERVICESERVICE_EXCEPTION!= null) {
            throw UTILISATEURSERVICESERVICE_EXCEPTION;
        }
        return UTILISATEURSERVICESERVICE_WSDL_LOCATION;
    }

}
