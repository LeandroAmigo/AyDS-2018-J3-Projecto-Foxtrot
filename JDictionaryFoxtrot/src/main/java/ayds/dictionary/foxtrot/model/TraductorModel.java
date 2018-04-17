package ayds.dictionary.foxtrot.model;

import ayds.dictionary.foxtrot.excepciones.TraductorException;

public interface TraductorModel {
    public boolean estaResultadoCacheado(String request);
    public String getResultadoCacheado(String request);
    public String solicitarResultado(String request) throws TraductorException;
    public boolean esResultadoValido(String response);
    public void guardarResultado(String request, String response);
}
