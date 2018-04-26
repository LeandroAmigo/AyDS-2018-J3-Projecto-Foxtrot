package ayds.dictionary.foxtrot.model.databases;

import java.sql.*;

class DataBaseSQL implements DataBase{
  private static final String pathConnection = "jdbc:sqlite:./dictionary.db";
  private static final String CREATE_TABLE    = "create table if not exists terms (id INTEGER PRIMARY KEY AUTOINCREMENT, term string, meaning string, source integer)";

  DataBaseSQL() {
    createNewDatabase();
  }

  private void createNewDatabase() {
    try (Connection connection = createConnection()) {
      if (connection != null) {
        Statement statement = createStatement(connection);
        statement.executeUpdate(CREATE_TABLE);
      }
    }
    catch (SQLException e) {
    }
  }

  private static Connection createConnection() throws SQLException{
    return DriverManager.getConnection(pathConnection);
  }

  private static Statement createStatement(Connection connection) throws SQLException{
    Statement statement = connection.createStatement();
    statement.setQueryTimeout(30);
    return statement;
  }

  public void saveTerm(String term, String meaning) {
    Connection connection = null;
    try {
      connection = createConnection();
      Statement statement = createStatement(connection);
      statement.executeUpdate("insert into terms values(null, '" + term + "', '" + meaning + "', 1)");
      closeConnection(connection);
    } catch (SQLException e) {
    }
  }

  public String getMeaning (String term){
    String meaning = null;
    Connection connection = null;
    try {
      connection = createConnection();
      Statement statement = createStatement(connection);
      ResultSet rs = statement.executeQuery("select * from terms WHERE term = '" + term + "'");
      if (rs.next())
        meaning = rs.getString("meaning");
      closeConnection(connection);
    }
    catch (SQLException e) {
    }
    return meaning;
  }

  private void closeConnection(Connection connection) throws SQLException{
    if (connection != null)
      connection.close();
  }

}