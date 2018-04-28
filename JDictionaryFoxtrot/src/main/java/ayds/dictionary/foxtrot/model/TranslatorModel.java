package ayds.dictionary.foxtrot.model;

public interface TranslatorModel {
   void requestResult(String term) ;
   void setListener(TranslatorModelListener listener);
   Definition getDefinition();
}
