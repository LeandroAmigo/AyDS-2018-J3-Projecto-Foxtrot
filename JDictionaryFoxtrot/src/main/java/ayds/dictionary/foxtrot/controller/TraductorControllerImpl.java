package ayds.dictionary.foxtrot.controller;

import ayds.dictionary.foxtrot.excepciones.TraductorException;
import ayds.dictionary.foxtrot.model.TraductorModel;
import ayds.dictionary.foxtrot.controller.parsers.InputParser;
import ayds.dictionary.foxtrot.controller.parsers.OutputParser;
import ayds.dictionary.foxtrot.controller.parsers.Parsers;
import ayds.dictionary.foxtrot.view.TraductorView;

class TraductorControllerImpl implements TraductorController {

  private TraductorModel traductorModel;
  private TraductorView traductorView;
  private InputParser inputParser;
  private OutputParser outputParser;

  TraductorControllerImpl(TraductorModel traductorModel, Parsers parsers) {
    this.traductorModel = traductorModel;
    this.inputParser=parsers.getInputParser();
    this.outputParser=parsers.getOutputParser();
  }
  @Override public void onEventGo(String request) {
    String response;
    try {
      if (requestVacio(request))
        response = "Ingrese un termino antes de consultar";
      else if (traductorModel.estaResultadoCacheado(request))
        response = traductorModel.getResultadoCacheado(request);
      else {
        String responseXml = traductorModel.solicitarResultado(request);
        if (traductorModel.esResultadoValido(responseXml)) {
          String textoPlano = inputParser.format(responseXml);
          response = outputParser.format(textoPlano);
          response = outputParser.resaltar(response, request);
          traductorModel.guardarResultado(request, response);
        } else
          response = "No se encontro el resultado";
      }
      traductorView.updateTraduccion(response);
    }catch(TraductorException traductorException){
      traductorView.updateTraduccion(traductorException.getMessage());
    }
  }
  @Override public void setTraductorView(TraductorView traductorView) {
    this.traductorView = traductorView;
  }
  private boolean requestVacio(String request){
    return request==null;
  }
}
