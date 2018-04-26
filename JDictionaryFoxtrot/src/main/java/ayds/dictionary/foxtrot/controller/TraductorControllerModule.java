package ayds.dictionary.foxtrot.controller;

import ayds.dictionary.foxtrot.model.TraductorModelModule;
import ayds.dictionary.foxtrot.view.TraductorView;
import ayds.dictionary.foxtrot.view.TraductorViewModule;

public class TraductorControllerModule {
  private static TraductorControllerModule instance;

  private TraductorControllerModule() { }

  public static TraductorControllerModule getInstance() {
    if (instance == null) {
      instance = new TraductorControllerModule();
    }
    return instance;
  }

  void startApplication() {
    TraductorController controller = getTraductorController();
    TraductorView view = openTraductorWindowAndGetView(controller);
    controller.setTraductorView(view);
  }

  private TraductorController getTraductorController() {
    return new TraductorControllerImpl(TraductorModelModule.getInstance().getTraductorModel());
  }

  private TraductorView openTraductorWindowAndGetView(TraductorController traductorController) {
    return TraductorViewModule.getInstance().openTraductorWindow(traductorController);
  }
}
