package ayds.dictionary.foxtrot.model.externalServices;

import ayds.dictionary.foxtrot.model.externalServices.adapters.ServiceAdapter;

public interface ServicesDef {
  Iterable<Source> getSourcesSet();
  ServiceAdapter getExternalService(Source source);
}
