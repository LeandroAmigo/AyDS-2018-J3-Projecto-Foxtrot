package ayds.dictionary.foxtrot.model;

import ayds.dictionary.foxtrot.excepciones.TraductorException;
import ayds.dictionary.foxtrot.model.services.Service;

public class TraductorModelImpl implements TraductorModel{

  private Service service;
  public TraductorModelImpl(Service service) {
    DataBase.createNewDatabase();
    this.service=service;
  }

  @Override
  public boolean estaResultadoCacheado(String request) {
    String text = DataBase.getMeaning(request);
    return text!=null;
 }

  @Override
  public String getResultadoCacheado(String request) {
    return "[*]" + DataBase.getMeaning(request);
  }

  @Override
  public String solicitarResultado(String request) throws TraductorException {
    return service.obtenerTermino(request);
  }

  @Override
  public boolean esResultadoValido(String response) {
    return service.hayResultados(response);
  }

    @Override
    public void guardarResultado(String request, String response) {
        DataBase.saveTerm(request, response);
    }

}
