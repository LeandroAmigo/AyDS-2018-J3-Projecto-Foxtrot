package ayds.dictionary.foxtrot.view;

import ayds.dictionary.foxtrot.controller.TraductorController;
import ayds.dictionary.foxtrot.model.TraductorModelModule;
public class TraductorViewModule {

  private static TraductorViewModule instance;
  private TraductorView traductorView;

  private TraductorViewModule() { }

  public static TraductorViewModule getInstance() {
    if (instance == null) {
      instance = new TraductorViewModule();
    }
    return instance;
  }


  public TraductorView openTraductorWindow(TraductorController traductorController) {
    if (traductorView == null) {
      traductorView = new TraductorViewImpl(traductorController, TraductorModelModule.getInstance().getTraductorModel(),ParserToHTML.getInstance());
      traductorView.inicializarGUI();
    }
    return traductorView;
  }

}
