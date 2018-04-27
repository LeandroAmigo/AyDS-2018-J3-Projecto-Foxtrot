package ayds.dictionary.foxtrot.model;

public interface TraductorModel {
   void solicitarResultado(String term) ;
   void setListener(TraductorModelListener listener);
   Definition getDefinition();
}
