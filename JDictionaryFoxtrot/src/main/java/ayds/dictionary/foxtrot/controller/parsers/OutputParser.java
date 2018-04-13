package ayds.dictionary.foxtrot.controller.parsers;
public interface OutputParser {
  public String format(String texto);
  public String resaltar(String texto, String termino);
}
