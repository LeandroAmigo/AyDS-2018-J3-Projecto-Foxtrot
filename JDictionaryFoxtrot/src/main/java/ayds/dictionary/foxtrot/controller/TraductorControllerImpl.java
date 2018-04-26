package ayds.dictionary.foxtrot.controller;

import ayds.dictionary.foxtrot.excepciones.TraductorException;
import ayds.dictionary.foxtrot.model.TraductorModel;
import ayds.dictionary.foxtrot.view.TraductorView;

class TraductorControllerImpl implements TraductorController {

    private TraductorModel traductorModel;
    private TraductorView traductorView;

    TraductorControllerImpl(TraductorModel traductorModel) {
        this.traductorModel = traductorModel;
    }

    @Override
    public void setTraductorView(TraductorView traductorView) {
        this.traductorView = traductorView;
    }

    @Override
    public void onEventGo(String request) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                traductorModel.solicitarResultado(request);
            }
        }).start();
    }

}