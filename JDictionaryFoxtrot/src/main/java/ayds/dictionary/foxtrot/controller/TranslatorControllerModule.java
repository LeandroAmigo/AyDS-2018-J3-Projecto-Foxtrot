package ayds.dictionary.foxtrot.controller;

import ayds.dictionary.foxtrot.model.TranslatorModelModule;
import ayds.dictionary.foxtrot.view.TranslatorView;
import ayds.dictionary.foxtrot.view.TranslatorViewModule;

public class TranslatorControllerModule {
  private static TranslatorControllerModule instance;

  private TranslatorControllerModule() { }

  public static TranslatorControllerModule getInstance() {
    if (instance == null) {
      instance = new TranslatorControllerModule();
    }
    return instance;
  }

  void startApplication() {
    TranslatorController controller = getTraductorController();
    TranslatorView view = openTraductorWindowAndGetView(controller);
    controller.setTranslatorView(view);
  }

  private TranslatorController getTraductorController() {
    return new TranslatorControllerImpl(TranslatorModelModule.getInstance().getTranslatorModel());
  }

  private TranslatorView openTraductorWindowAndGetView(TranslatorController translatorController) {
    return TranslatorViewModule.getInstance().openTraductorWindow(translatorController);
  }
}
