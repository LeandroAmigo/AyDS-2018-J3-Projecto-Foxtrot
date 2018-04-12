package ayds.dictionary.foxtrot.parser;
public interface Parser {
	public static Parser getInstance();
  public String format(String texto, String termino);
}
