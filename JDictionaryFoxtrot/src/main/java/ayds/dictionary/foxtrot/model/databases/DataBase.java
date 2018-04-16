package ayds.dictionary.foxtrot.model.databases;

import java.sql.*;

public interface  DataBase {
  public void createNewDatabase()throws TraductorModelException;
  public void saveTerm(String term, String meaning)throws TraductorModelException;
  public String getMeaning(String term)throws TraductorModelException;
}
