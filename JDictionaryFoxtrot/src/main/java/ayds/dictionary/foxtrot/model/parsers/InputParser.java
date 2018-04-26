package ayds.dictionary.foxtrot.model.parsers;

import ayds.dictionary.foxtrot.excepciones.TraductorException;

public interface InputParser {
  String format(String texto) throws TraductorException;
}
