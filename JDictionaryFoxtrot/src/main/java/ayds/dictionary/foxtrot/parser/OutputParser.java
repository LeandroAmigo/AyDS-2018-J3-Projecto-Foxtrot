package ayds.dictionary.foxtrot.parsers;
public interface OutputParser {
  public static OutputParser getInstance();
  public String format(String texto);
  public String resaltar(String texto, String termino);
}
