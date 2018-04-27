package ayds.dictionary.foxtrot.view;

public class ParserToHTML implements OutputParser {

  private static ParserToHTML instance;
  private final String FONT_TYPE = "arial";

  private ParserToHTML() { }

  public static ParserToHTML getInstance() {
    if(instance == null) {
      instance =  new ParserToHTML();
    }
    return instance;
  }

  @Override public String format(String text, String term) {
    text = reemplazarComillas(text);
    String textoResaltado = resaltar(text,term);
    return definirFuente(textoResaltado);
  }

  private String definirFuente(String string){
    return "<font face=\""+FONT_TYPE+"\">" + string + "</font>";
  }

  private String reemplazarComillas(String text){
    return text.replace("'", "`");
  }

  private String resaltar(String text, String term){
    return text.replaceAll("(?i)" + term, "<b>" + term +"</b>");
  }
}






  /*
  private static ParserToHTML instance;
  private String texto;
  private static final String fuente= "arial";

  private ParserToHTML() {
  }

  public static ParserToHTML getInstance() {
    if(instance == null) {
      instance =  new ParserToHTML();
    }
    return instance;
  }

	@Override public String format(String texto) {
	  this.texto=texto;
	  formatNow();
	  return this.texto;
  }

  private void formatNow(){
      remplazarSaltosdeLinea();
      remplazarComillas();
      definirFuente();
  }
  private void remplazarSaltosdeLinea(){
    texto=texto.replace("\\n", "<br>");
  }

  private void remplazarComillas(){
    texto=texto.replace("'", "`");
  }

  private void definirFuente(){
    texto= "<font face=\""+fuente+"\">"+texto+"</font>";
  }

  @Override public String resaltar(String texto, String termino){
    return texto.replace(termino, "<b>" + termino +"</b>");
  }
}
*/