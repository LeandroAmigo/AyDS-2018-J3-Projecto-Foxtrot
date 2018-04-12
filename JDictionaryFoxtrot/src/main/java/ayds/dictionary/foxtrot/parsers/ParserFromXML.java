package ayds.dictionary.foxtrot.parsers;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;

class ParserFromXML implements InputParser{
  
  private static ParserFromXML instance;
 
  private ParserFromXML() {}

  public static ParserFromXML getInstance() {
    if(instance == null) {
      instance =  new ParserFromXML();
    }
    return instance;
  }

	@Override public String format(String texto) {
	  Document documento= getDocument(texto);
	  NodeList nodoTexto = getNodo(documento);
    String contenido=getContenido(nodoTexto);
	  return contenido;
  }
  private Document getDocument(String texto){
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = null;
    Document doc=null;
    try {
      db = dbf.newDocumentBuilder();
      doc=db.parse(new InputSource(new java.io.StringReader(texto)));
    } catch (ParserConfigurationException e) {e.printStackTrace();} catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return doc;
  }
  private NodeList getNodo(Document documento){
    return documento.getDocumentElement().getElementsByTagName("text");
  }
  private String getContenido(NodeList nodoTexto){
    return nodoTexto.item(0).getTextContent();
  }

 }
