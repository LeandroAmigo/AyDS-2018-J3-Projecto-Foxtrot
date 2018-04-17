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
    @Override
    public void onEventGo(String request) {
        String response;
            if (requestVacio(request))
                response = "Ingrese un termino antes de consultar";
            else if (requestYaAlmacenado(request))
                response = obtenerResultadoCacheado(request);
            else {
                response = nuevaTraduccion(request);
                if (encontroResultado(response)) {
                    response = resaltarResultado(response, request);
                    guardarResultado(request, response);
                } else
                    response = "No se encontro el resultado";
            }
        visualizar(response);
    }

    private boolean requestVacio(String request){
        return (request == null || request.isEmpty());
    }
    private boolean requestYaAlmacenado(String request) {
        return traductorModel.estaResultadoCacheado(request);
    }
    private String obtenerResultadoCacheado(String request) {
        return traductorModel.getResultadoCacheado(request);
    }
    private String nuevaTraduccion(String request) {
        String response = null;
        try {
            String traduccionXML = traductorModel.solicitarResultado(request);
            if (traductorModel.esResultadoValido(traduccionXML)) {
                String traduccionSinFormato = inputParser.format(traduccionXML);
                response = outputParser.format(traduccionSinFormato);
            }
        } catch (TraductorException traductorException) {
            traductorView.updateTraduccion(traductorException.getMessage());
        }
        return response;
    }
    private boolean encontroResultado(String response) {
        return response != null;
    }
    private String resaltarResultado(String response, String request) {
        return outputParser.resaltar(response, request);
    }
    private void guardarResultado(String request, String response) {
        traductorModel.guardarResultado(request, response);
    }
    private void visualizar(String response){
        traductorView.updateTraduccion(response);
    }

  @Override public void setTraductorView(TraductorView traductorView) {
    this.traductorView = traductorView;
  }

}
