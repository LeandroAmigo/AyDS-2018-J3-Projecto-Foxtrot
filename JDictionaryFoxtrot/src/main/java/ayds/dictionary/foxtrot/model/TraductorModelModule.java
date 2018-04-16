package ayds.dictionary.foxtrot.model;

import ayds.dictionary.foxtrot.model.databases
import ayds.dictionary.foxtrot.model.services.ServiceYandex;

public class TraductorModelModule {
  private static TraductorModelModule instance;
  private TraductorModel traductorModel;

  private TraductorModelModule() {
    DataBase dataBase= DataBaseSQL.getInstance();
    traductorModel =  new TraductorModelImpl(ServiceYandex.getInstance(),dataBase);
  }

  public static TraductorModelModule getInstance() {
    if(instance == null) {
      instance =  new TraductorModelModule();
    }
    return instance;
  }

  public TraductorModel getTraductorModel() {
    return traductorModel;
  }
}
