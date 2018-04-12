package ayds.dictionary.foxtrot.parsers;


class ParserToHTML implements OutputParser{
  
  private static ParserToHTML instance;
  private String Texto,Termino;
  private static final String fuente= "arial";

  private ParserToHTML() {
    traductorModel =  new TraductorModelImpl();
  }

  @Override public static OutputParser getInstance() {
    if(instance == null) {
      instance =  new ParserToHTML();
    }
    return instance;
  }

	@Override public String format(String texto) {
	  this.texto=texto;
	  this.termino=termino;
	      
	  formatNow();

	  return this.texto;
  }
  private String formatNow(){
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

  @Override public String resaltar(String texto, String termino);){
    return texto.replace(termino, "<b>" + termino +"</b>");
  }
}
