package ayds.dictionary.foxtrot.model;

import ayds.dictionary.foxtrot.model.databases.*;
import ayds.dictionary.foxtrot.model.services.Service;
import ayds.dictionary.foxtrot.model.services.ServiceModule;

public class TraductorModelModule {
  private static TraductorModelModule instance;
  private TraductorModel traductorModel;

  private TraductorModelModule() {
    DataBase dataBase= TraductorDatabasesModule.getInstance().getDataBase();
    Service service = ServiceModule.getInstance().getRemoteSource();
    traductorModel =  new TraductorModelImpl(new RepositoryImpl(dataBase,service));
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
