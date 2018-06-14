package ayds.dictionary.foxtrot.model.databases;

import ayds.dictionary.foxtrot.model.exceptions.TranslatorException;
import ayds.dictionary.foxtrot.model.Definition;
import ayds.dictionary.foxtrot.model.externalServices.Source;
import ayds.dictionary.foxtrot.model.TranslatorModelModule;

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
      notifyExceptionHandler("Ocurrió un error en la creación de la base de datos");
    }
  }

  private void notifyExceptionHandler(String message) {
    TranslatorModelModule.getInstance().getExceptionHandler().notifyException(new TranslatorException(message));
  }

  private static Connection createConnection() throws SQLException{
    return DriverManager.getConnection(pathConnection);
  }

  private static Statement createStatement(Connection connection) throws SQLException{
    Statement statement = connection.createStatement();
    statement.setQueryTimeout(30);
    return statement;
  }

  public void saveDefinition(Definition definition) {
    Connection connection = null;
    if ( !definition.isMeaningEmpty()) {
      String term = definition.getTerm();
      String meaning = definition.getMeaning().replace("'", "`");
      int source = definition.getSource().ordinal();
      try {
        connection = createConnection();
        Statement statement = createStatement(connection);
        statement.executeUpdate("insert into terms values(null, '" + term + "', '" + meaning + "', "+source+")");
        closeConnection(connection);
      } catch (SQLException e) {
        notifyExceptionHandler("Ocurrió un error en el guardado del término a la base de datos.");
      }
    }
  }

  public Definition getMeaning (String term, Source source){
    Definition definition = null;
    Connection connection = null;
    try {
      connection = createConnection();
      Statement statement = createStatement(connection);
      int ordinal = source.ordinal();
      ResultSet rs = statement.executeQuery("select * from terms WHERE term = '" + term + "' AND source = "+ordinal);
      if (rs.next())
          definition = new Definition(term, rs.getString("meaning"), Source.values()[(rs.getInt("source"))] );
      closeConnection(connection);
    }
    catch (SQLException e) {
      notifyExceptionHandler("Ocurrió un error en el acceso a la base de datos.");
    }
    return definition;
  }

  private void closeConnection(Connection connection) throws SQLException{
    if (connection != null)
      connection.close();
  }

}