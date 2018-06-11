package ayds.dictionary.foxtrot.model.externalServices;

import java.util.HashMap;

public class ServicesDefImpl implements ServicesDef {
  private HashMap<Source, ServiceAdapter> servicesMap;

  ServicesDefImpl(HashMap<Source, ServiceAdapter> servicesMap) {
    this.servicesMap = servicesMap;
  }

  public Iterable<Source> getSourcesSet() {
    return servicesMap.keySet();
  }

  public ServiceAdapter getExternalService(Source source) {
    return servicesMap.get(source);
  }

}
