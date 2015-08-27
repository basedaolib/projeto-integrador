package br.com.belaAgenda.infra.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.belaAgenda.infra.resourceBundle.ResourceBundleMessageScan;


public class ResourceBundleJSFScan implements ServletContextListener {

	
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    	dbf.setNamespaceAware(false);

    	DocumentBuilder docBuilder;
		try {
			String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("") + "WEB-INF/";
			docBuilder = dbf.newDocumentBuilder();
			
			Document doc = docBuilder.parse(new File(path + "faces-config.xml"));
			
			NodeList applications = doc.getElementsByTagName("application");
			
			Node application = applications.item(0);
			Element resourceBundle;
			Element baseName;
			Element var;
			for(String local : ResourceBundleMessageScan.listarArquivos()){
				resourceBundle = doc.createElement("resource-bundle");
				baseName = doc.createElement("base-name");
				var = doc.createElement("var");
				
				baseName.appendChild(doc.createTextNode(local));
				//var.appendChild(doc.createTextNode(data));
				
				resourceBundle.appendChild(baseName);
				resourceBundle.appendChild(var);
				
				application.appendChild(resourceBundle);
			}
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult(new StringWriter());
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);

            String xmlString = result.getWriter().toString();
			
			FileWriter fileWrite = new FileWriter(new File(path + "faces-config.xml"));  
		    fileWrite.write(xmlString);  
		    fileWrite.close();  
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



    }

	
    public void contextInitialized(ServletContextEvent arg0)  { 
    }
	
}
