package ayds.dictionary.foxtrot.controller;

import ayds.dictionary.foxtrot.model.TraductorModel;
import ayds.dictionary.foxtrot.view.TraductorView;

class TraductorControllerImpl implements TraductorController {

  private TraductorModel traductorModel;
  private TraductorView traductorView;

  TraductorControllerImpl(TraductorModel traductorModel) {
    this.traductorModel = traductorModel;
  }
  @Override public void onEventUpdate(String request) {

  }
  @Override public void setTraductorView(TraductorView traductorView) {
    this.traductorView = traductorView;
  }
}
