package ayds.dictionary.foxtrot.model;

import ayds.dictionary.foxtrot.model.databases.*;
import ayds.dictionary.foxtrot.model.services.Service;
import ayds.dictionary.foxtrot.model.services.ServiceModule;

public class TranslatorModelModule {
  private static TranslatorModelModule instance;
  private TranslatorModel translatorModel;

  private TranslatorModelModule() {
    DataBase dataBase= TranslatorDatabasesModule.getInstance().getDataBase();
    Service service = ServiceModule.getInstance().getRemoteSource();
    translatorModel =  new TranslatorModelImpl(new RepositoryImpl(dataBase,service));
  }

  public static TranslatorModelModule getInstance() {
    if(instance == null) {
      instance =  new TranslatorModelModule();
    }
    return instance;
  }

  public TranslatorModel getTranslatorModel() {
    return translatorModel;
  }
}
