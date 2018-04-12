package ayds.dictionary.foxtrot.model;

public class TraductorModelModule {
  private static TraductorModelModule instance;
  private TraductorModel traductorModel;

  private UserModelModule() {
    traductorModel =  new TraductorModelImpl();
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
