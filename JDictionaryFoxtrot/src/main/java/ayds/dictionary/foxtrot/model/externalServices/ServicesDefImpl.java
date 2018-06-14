package ayds.dictionary.foxtrot.model.externalServices;

import ayds.dictionary.foxtrot.model.externalServices.adapters.ServiceAdapter;

import java.util.Map;

public class ServicesDefImpl implements ServicesDef {
  private Map<Source, ServiceAdapter> servicesMap;

  ServicesDefImpl(Map<Source, ServiceAdapter> servicesMap) {
    this.servicesMap = servicesMap;
  }

  public Iterable<Source> getSourcesSet() {
    return servicesMap.keySet();
  }

  public ServiceAdapter getExternalService(Source source) {
    return servicesMap.get(source);
  }

}
