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
    text = replaceCommas(text);
    String highlightedText = highlightText(text,term);
    return setFont(highlightedText);
  }

  private String setFont(String string){
    return "<font face=\""+FONT_TYPE+"\">" + string + "</font>";
  }

  private String replaceCommas(String text){
    return text.replace("'", "`");
  }

  private String highlightText(String text, String term){
    return text.replaceAll("(?i)" + term, "<b>" + term +"</b>");
  }

}