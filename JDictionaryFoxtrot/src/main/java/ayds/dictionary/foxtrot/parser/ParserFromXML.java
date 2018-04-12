package ayds.dictionary.foxtrot.parsers;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

class ParserFromXML implements InputParser{
  
  private static ParserFromXML instance;
 
  private ParserFromXML() {}

  @Override public static InputParser getInstance() {
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
    DocumentBuilder db = dbf.newDocumentBuilder();
    return db.parse(new InputSource(new java.io.StringReader(body)));
  }
  private NodeList getNodo(documento){
    return documento.getDocumentElement().getElementsByTagName("text");
  }
  private String getContenido(nodoTexto){
    return nodoTexto.item(0).getTextContent();
  }

 }
