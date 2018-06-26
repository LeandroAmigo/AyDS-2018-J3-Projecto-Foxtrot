package ayds.dictionary.foxtrot.model;

import ayds.dictionary.foxtrot.model.databases.*;
import ayds.dictionary.foxtrot.model.externalServices.ServiceDefModule;

public class TranslatorModelModule {
  private static TranslatorModelModule instance;
  private TranslatorModel translatorModel;
  private ExceptionHandler exceptionHandler;

  private TranslatorModelModule() {
    DataBase dataBase= TranslatorDatabasesModule.getInstance().getDataBase();
    exceptionHandler = new ExceptionHandlerImpl();
    translatorModel =  new TranslatorModelImpl(
        new RepositoryImpl(dataBase, ServiceDefModule.getInstance().getServiceDef()));
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

  public ExceptionHandler getExceptionHandler() {
    return exceptionHandler;
  }
}

