package ayds.dictionary.foxtrot.model.externalServices;

import ayds.dictionary.foxtrot.services.YandexServiceModule;
import wikipedia.service.WikipediaServiceModule;
import ayds.dictionary.delta.services.BigHugeLabsModule;

public class ServiceDefModule {
  private static ServiceDefModule ourInstance = new ServiceDefModule();
  private ServicesDef servicesDef;

  public static ServiceDefModule getInstance() {
    return ourInstance;
  }

  private ServiceDefModule() {
      ServicesMapFactory factory = createMapFactory();
      servicesDef = new ServicesDefImpl(factory.getServicesMap());
  }

  private ServicesMapFactory createMapFactory() {
    return new ServiceMapFactotyImpl(YandexServiceModule.getInstance().getRemoteSource(),
            WikipediaServiceModule.getInstance().getService(),
            BigHugeLabsModule.getInstance().getBigHugeLabsService());
  }

  public ServicesDef getServiceDef() {
    return servicesDef;
  }
}
