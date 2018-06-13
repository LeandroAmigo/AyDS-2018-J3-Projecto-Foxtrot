package ayds.dictionary.foxtrot.model.externalServices;

import java.util.HashMap;
import ayds.dictionary.foxtrot.services.YandexServiceModule;
import wikipedia.service.WikipediaServiceModule;

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
    servicesMap.put(Source.YANDEX, new YandexServiceAdapter(YandexServiceModule.getInstance().getRemoteSource()));
    servicesMap.put(Source.WIKIPEDIA, new WikipediaServiceAdapter(WikipediaServiceModule.getInstance().getService()));
    //servicesMap.put(Source.BHLLIB, new BigHugeLabsAdapter(BigHugeLabsModule.getInstance().getBigHugeLabsService()));
  }

  public ServicesDef getServiceDef() {
    return servicesDef;
  }
}
