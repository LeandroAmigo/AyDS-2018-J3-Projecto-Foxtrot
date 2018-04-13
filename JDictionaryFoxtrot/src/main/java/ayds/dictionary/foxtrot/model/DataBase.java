package ayds.dictionary.foxtrot.model;

import java.sql.*;

public class DataBase {
  private static final String pathConnection = "jdbc:sqlite:./dictionary.db";

  private static Connection conectarBD() {
     Connection connection= null;
    try {
       connection = DriverManager.getConnection(pathConnection);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

  public static void createNewDatabase() {
    try {
      Connection connection = conectarBD();
      if (connection!=null) {
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec.
        statement.executeUpdate("create table terms (id INTEGER PRIMARY KEY AUTOINCREMENT, term string, meaning string, source integer)");

       }
     }catch (SQLException e) { }
  }

  public static void saveTerm(String term, String meaning) {
    try {
      Connection connection = conectarBD();
      if (connection!=null) {
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into terms values(null, '" + term + "', '" + meaning + "', 1)");
        connection.close();
      }
    }catch(SQLException e) { }
  }

  public static String getMeaning(String term) {
    String meaning = null;
    try {
      Connection connection = conectarBD();
      if (connection!=null) {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from terms WHERE term = '" + term + "'");
        rs.next();
        meaning= rs.getString("meaning");
        connection.close();
      }
    }catch(SQLException e) { }
    return meaning;
  }
}
