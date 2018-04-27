package ayds.dictionary.foxtrot.model;

import ayds.dictionary.foxtrot.excepciones.TraductorException;

public interface Repository {
  Definition getDefinition(String term);
}
