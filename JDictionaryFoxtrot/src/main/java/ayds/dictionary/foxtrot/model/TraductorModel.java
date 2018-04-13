package ayds.dictionary.foxtrot.model;

public interface TraductorModel {
    public boolean estaResultadoCacheado(String request);
    public String getResultadoCacheado(String request);
    public String solicitarResultado(String request);
    public boolean esResultadoValido(String response);
    public void guardarResultado(String request, String response);
}
