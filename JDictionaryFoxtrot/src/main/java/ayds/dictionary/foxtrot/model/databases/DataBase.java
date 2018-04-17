package ayds.dictionary.foxtrot.model.databases;

import java.sql.*;

public interface  DataBase {
  public void createNewDatabase();
  public void saveTerm(String term, String meaning);
  public String getMeaning(String term);
}
