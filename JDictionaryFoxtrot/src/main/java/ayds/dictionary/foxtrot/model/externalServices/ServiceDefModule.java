package ayds.dictionary.foxtrot.model.externalServices;

import ayds.dictionary.foxtrot.model.externalServices.adapters.ServiceMapFactoryModule;

public class ServiceDefModule {
  private static ServiceDefModule instance;
  private ServicesDef servicesDef;

  public static ServiceDefModule getInstance() {
    if (instance== null){
      instance = new ServiceDefModule();
    }
    return instance;
  }

  private ServiceDefModule() {
     servicesDef= new ServicesDefImpl(ServiceMapFactoryModule.getInstance().getServicesMapFactory().getServicesMap());
  }

  public ServicesDef getServiceDef() {
    return servicesDef;
  }
}
