package ayds.dictionary.foxtrot.model;

import ayds.dictionary.foxtrot.excepciones.*;

public interface TraductorModel {
    public void iniciarDatosPersistente()throws TraductorModelException;
    public boolean estaResultadoCacheado(String request)throws TraductorModelException;
    public String getResultadoCacheado(String request)throws TraductorModelException;
    public String solicitarResultado(String request) throws TraductorException;
    public boolean esResultadoValido(String response);
    public void guardarResultado(String request, String response)throws TraductorModelException;
}
