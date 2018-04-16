package ayds.dictionary.foxtrot.model.databases;

import java.sql.*;
import ayds.dictionary.foxtrot.excepciones.TraductorModelException;

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
  public void createNewDatabase() throws TraductorModelException{
    try {
      conectarBD();
      if (existeConexion()) {
        nuevaConsulta();
        setTimeOutInSeconds(30);
        crearTablaEnBaseDeDatos();    
       }
     }catch (SQLException e) {
        throw new TraductorModelException("Error al crear la Base de Datos");
     }
  }
  private void conectarBD() {
    connection = DriverManager.getConnection(pathConnection);
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
  public void saveTerm(String term, String meaning)throws TraductorModelException{
    try {
      conectarBD();
      if (existeConexion()) {
        nuevaConsulta();
        insertarEnBaseDeDatos(term,meaning);
        cerrarConexion();
      }
    } catch (SQLException e) {
        throw new TraductorModelException("Error al guardar el termino en la Base de Datos");
    }
  }  
  private void insertarEnBaseDeDatos(String term, String meaning)throws SQLException{
    statementActual.executeUpdate("insert into terms values(null, '" + term + "', '" + meaning + "', 1)");
  }
  private void cerrarConexion()throws SQLException{
    connection.close();
  } 
  public String getMeaning(String term)throws TraductorModelException{
    String meaning = null;
    try {
      conectarBD();
      if (existeConexion()) {
        nuevaConsulta();
        meaning= getStringMeaning(term);
        cerrarConexion();
      }
    } catch (SQLException e) {
        throw new TraductorModelException("Error al intentar obtener el termino de la Base de Datos");
    }
    return meaning;
  }
  private String getStringMeaning(String term)throws SQLException{
    ResultSet resultSet = statementActual.executeQuery("select * from terms WHERE term = '" + term + "'");
    resultSet.next();
    return resultSet.getString("meaning");
  }
}
