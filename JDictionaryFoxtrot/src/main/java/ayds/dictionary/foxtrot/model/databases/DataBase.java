package ayds.dictionary.foxtrot.model.databases;

public interface  DataBase {
   void saveTerm(String term, String meaning);
   String getMeaning(String term);
}
