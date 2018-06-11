package ayds.dictionary.foxtrot.model.externalServices;

public interface ServicesDef {
  Iterable<Source> getSourcesSet();
  ServiceAdapter getExternalService(Source source);
}
