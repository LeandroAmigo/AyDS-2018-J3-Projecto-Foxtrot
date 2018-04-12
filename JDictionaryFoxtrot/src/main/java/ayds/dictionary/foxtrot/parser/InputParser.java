package ayds.dictionary.foxtrot.parsers;
public interface InputParser {
  public static InputParser getInstance();
  public String format(String texto);
}
