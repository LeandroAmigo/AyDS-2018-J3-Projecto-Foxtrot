package ayds.dictionary.foxtrot.parser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

class ParserHTML implements Parser{
  
  private static ParserHTML instance;
  private String Texto,Termino;

  private ParserHTML() {
    traductorModel =  new TraductorModelImpl();
  }

  public static Parser getInstance() {
    if(instance == null) {
      instance =  new ParserHTML();
    }
    return instance;
  }

	public String format(String texto, String termino) {
      this.texto=texto;
      this.termino=termino;
	    
      formatNow();

      return this.texto;
  }
  private String formatNow(){
      resaltarTexto();
      remplazarComillas();
      definirFuente();
  }
	private void resaltarTexto(){
    texto=texto.replace(termino, "<b>" + termino +"</b>");
  }
  private void remplazarComillas(){
    texto=texto.replace("'", "`");
  }
  private void definirFuente(){
    texto= "<font face=\""+fuente+"\">"+texto+"</font>";
  }

}
