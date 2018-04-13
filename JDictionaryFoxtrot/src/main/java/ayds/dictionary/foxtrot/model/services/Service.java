package ayds.dictionary.foxtrot.model.services;

import ayds.dictionary.foxtrot.excepciones.TraductorException;

public interface Service {
  public String obtenerTermino(String request) throws TraductorException;
  public boolean hayResultados(String respuesta);
}
