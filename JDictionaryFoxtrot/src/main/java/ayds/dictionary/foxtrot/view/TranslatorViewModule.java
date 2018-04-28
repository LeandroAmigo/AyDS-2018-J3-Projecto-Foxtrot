package ayds.dictionary.foxtrot.view;

import ayds.dictionary.foxtrot.controller.TranslatorController;
import ayds.dictionary.foxtrot.model.TranslatorModelModule;
public class TranslatorViewModule {
  private static TranslatorViewModule instance;
  private TranslatorView translatorView;

  private TranslatorViewModule() { }

  public static TranslatorViewModule getInstance() {
    if (instance == null) {
      instance = new TranslatorViewModule();
    }
    return instance;
  }

  public TranslatorView openTraductorWindow(TranslatorController translatorController) {
    if (translatorView == null) {
      translatorView = new TranslatorViewImpl(translatorController, TranslatorModelModule.getInstance().getTranslatorModel(),ParserToHTML.getInstance());
      translatorView.showView();
    }
    return translatorView;
  }

}
