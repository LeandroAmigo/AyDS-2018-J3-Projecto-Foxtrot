package ayds.dictionary.foxtrot.model.externalServices;

import java.util.HashMap;

public class ServiceDefModule {
  private static ServiceDefModule ourInstance = new ServiceDefModule();
  private ServicesDef servicesDef;

  public static ServiceDefModule getInstance() {
    return ourInstance;
  }

  private ServiceDefModule() {
    HashMap<Source, ServiceAdapter> servicesMap = new HashMap<Source, ServiceAdapter>();
    initializeServicesMap(servicesMap);
    servicesDef = new ServicesDefImpl(servicesMap);
  }

  private void initializeServicesMap(HashMap<Source, ServiceAdapter> servicesMap) {
    servicesMap.put(Source.YANDEX, new YandexServiceAdapter(services.ServiceModule.getInstance().getRemoteSource()));
    //servicesMap.put(Source.WIKIPEDIA, new WikipediaServiceAdapter(Services.ServiceModule.getInstance().getService()));
    //servicesMap.put(Source.BHLLIB, new BigHugeLabsAdapter(services.ServiceModule.getInstance().getService()));
  }

  public ServicesDef getServiceDef() {
    return servicesDef;
  }
}
