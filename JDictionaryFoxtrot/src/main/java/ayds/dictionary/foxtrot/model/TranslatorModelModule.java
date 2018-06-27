package ayds.dictionary.foxtrot.model;

import ayds.dictionary.foxtrot.model.databases.*;
import ayds.dictionary.foxtrot.model.externalServices.ServiceDefModule;
import ayds.dictionary.foxtrot.model.externalServices.Source;
import java.util.HashMap;
import java.util.Map;

public class TranslatorModelModule {
  private static TranslatorModelModule instance;
  private TranslatorModel translatorModel;
  private ExceptionHandler exceptionHandler;

  private TranslatorModelModule() {
    DataBase dataBase= TranslatorDatabasesModule.getInstance().getDataBase();
    Map<Source, Exception> exceptionMap = new HashMap<Source, Exception>();
    exceptionHandler = new ExceptionHandlerImpl();
    translatorModel =  new TranslatorModelImpl(
        new RepositoryImpl(dataBase, ServiceDefModule.getInstance().getServiceDef(), exceptionMap, exceptionHandler));
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

