package ayds.dictionary.foxtrot.controller.parsers;

import ayds.dictionary.foxtrot.excepciones.TraductorException;

public interface InputParser {
  public String format(String texto) throws TraductorException;
}
