package ayds.dictionary.foxtrot.model;

import ayds.dictionary.foxtrot.model.databases.*;
import services.Service;
import services.ServiceModule;

public class TranslatorModelModule {
  private static TranslatorModelModule instance;
  private TranslatorModel translatorModel;
  private ExceptionHandler exceptionHandler = new ExceptionHandlerImpl();

  private TranslatorModelModule() {
    DataBase dataBase= TranslatorDatabasesModule.getInstance().getDataBase();
    Service service = ServiceModule.getInstance().getRemoteSource();
    translatorModel =  new TranslatorModelImpl(new RepositoryImpl(dataBase,new YandexServiceAdapter(service)));
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

