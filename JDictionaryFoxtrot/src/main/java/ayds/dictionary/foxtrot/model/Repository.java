package ayds.dictionary.foxtrot.model;

import ayds.dictionary.foxtrot.excepciones.TraductorException;

public interface Repository {
  String getMeaning(String term) throws TraductorException;
}
