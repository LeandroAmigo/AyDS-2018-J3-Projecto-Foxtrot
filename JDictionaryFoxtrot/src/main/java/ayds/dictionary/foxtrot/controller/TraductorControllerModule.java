package ayds.dictionary.foxtrot.controller;

import ayds.dictionary.foxtrot.model.TraductorModelModule;
import ayds.dictionary.foxtrot.controller.parsers.ParserFromXML;
import ayds.dictionary.foxtrot.controller.parsers.ParserToHTML;
import ayds.dictionary.foxtrot.controller.parsers.Parsers;
import ayds.dictionary.foxtrot.controller.parsers.ParsersImpl;
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
    controller.inicializarPersistenciaDelModelo();
  }

  private TraductorController getTraductorController() {
    Parsers parsers=new ParsersImpl(ParserFromXML.getInstance(), ParserToHTML.getInstance());
    return new TraductorControllerImpl(TraductorModelModule.getInstance().getTraductorModel(),parsers);
  }

  private TraductorView openTraductorWindowAndGetView(TraductorController traductorController) {
    return TraductorViewModule.getInstance().openTraductorWindow(traductorController);
  }
}
