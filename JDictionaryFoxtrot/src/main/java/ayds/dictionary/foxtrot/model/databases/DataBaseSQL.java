package ayds.dictionary.foxtrot.model.databases;

import java.sql.*;

public class DataBaseSQL implements DataBase{
  private final String pathConnection = "jdbc:sqlite:./dictionary.db";
  private Connection connection;
  private Statement statementActual;
  private static DataBaseSQL instance;
  private DataBaseSQL(){}

  public static DataBaseSQL getInstance(){
    if(instance==null)
      instance=new DataBaseSQL();
    return instance;
  }
  public void createNewDatabase() {
    try {
      conectarBD();
      if (existeConexion()) {
        nuevaConsulta();
        setTimeOutInSeconds(30);
        crearTablaEnBaseDeDatos();    
       }
     }catch (SQLException e) { }
  }
  private void conectarBD() {
    try {
       connection = DriverManager.getConnection(pathConnection);
    } catch (SQLException e) {}
  }  
  private boolean existeConexion(){
    return connection!=null;
  }
  private void nuevaConsulta()throws SQLException{
    statementActual= connection.createStatement();
  }
  private void setTimeOutInSeconds(int seconds)throws SQLException{
    statementActual.setQueryTimeout(seconds); 
  }
  private void crearTablaEnBaseDeDatos()throws SQLException{
    statementActual.executeUpdate("create table terms (id INTEGER PRIMARY KEY AUTOINCREMENT, term string, meaning string, source integer)");
  }
  public void saveTerm(String term, String meaning) {
    try {
      conectarBD();
      if (existeConexion()) {
        nuevaConsulta();
        insertarEnBaseDeDatos(term,meaning);
        cerrarConexion();
      }
    }catch(SQLException e) { }
  }  
  private void insertarEnBaseDeDatos(String term, String meaning)throws SQLException{
    statementActual.executeUpdate("insert into terms values(null, '" + term + "', '" + meaning + "', 1)");
  }
  private void cerrarConexion()throws SQLException{
    connection.close();
  } 
  public String getMeaning(String term) {
    String meaning = null;
    try {
      conectarBD();
      if (existeConexion()) {
        nuevaConsulta();
        meaning= getStringMeaning(term);
        cerrarConexion();
      }
    }catch(SQLException e) { }
    return meaning;
  }
  private String getStringMeaning(String term)throws SQLException{
    ResultSet resultSet = statementActual.executeQuery("select * from terms WHERE term = '" + term + "'");
    resultSet.next();
    return resultSet.getString("meaning");
  }
}
