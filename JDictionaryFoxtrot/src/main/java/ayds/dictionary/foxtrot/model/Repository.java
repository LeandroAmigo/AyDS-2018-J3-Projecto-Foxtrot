package ayds.dictionary.foxtrot.model;

public interface Repository {
  Iterable<Definition> getDefinitions(String term);
}
