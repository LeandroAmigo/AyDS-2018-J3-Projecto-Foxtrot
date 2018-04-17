package ayds.dictionary.foxtrot.model;

import ayds.dictionary.foxtrot.excepciones.TraductorException;
import ayds.dictionary.foxtrot.model.databases.DataBase;
import ayds.dictionary.foxtrot.model.databases.DataBaseSQL;
import ayds.dictionary.foxtrot.model.services.Service;

public class TraductorModelImpl implements TraductorModel{

  private Service service;
  private DataBase dataBase;
  public TraductorModelImpl(Service service,DataBase dataBase) {
    this.service=service;
    this.dataBase=dataBase;
    dataBase.createNewDatabase();
  }

  @Override
  public boolean estaResultadoCacheado(String request) {
    String text = dataBase.getMeaning(request);
    return text!=null;
 }

  @Override
  public String getResultadoCacheado(String request) {
    return "[*]" + dataBase.getMeaning(request);
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
        dataBase.saveTerm(request, response);
    }

}
