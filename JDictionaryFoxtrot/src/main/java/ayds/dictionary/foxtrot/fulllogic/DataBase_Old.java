package ayds.dictionary.foxtrot.fulllogic;

import java.sql.*;

public class DataBase_Old {

  public static void createNewDatabase() {

    String url = "jdbc:sqlite:./dictionary.db";

    try (Connection connection = DriverManager.getConnection(url)) {
      if (connection != null) {
        DatabaseMetaData meta = connection.getMetaData();
        System.out.println("The driver name is " + meta.getDriverName());
        System.out.println("A new database has been created.");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec.

        statement.executeUpdate("create table terms (id INTEGER PRIMARY KEY AUTOINCREMENT, term string, meaning string, source integer)");

      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void saveTerm(String term, String meaning)
  {
    Connection connection = null;
    try
    {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:./dictionary.db");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      System.out.println("INSERT  " + term + "', '"+ meaning );

      statement.executeUpdate("insert into terms values(null, '"+ term + "', '"+ meaning + "', 1)");
    }
    catch(SQLException e)
    {
      System.err.println("Error saving " + e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println( e);
      }
    }
  }

  public static String getMeaning(String term)
  {

    Connection connection = null;
    try
    {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:./dictionary.db");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      ResultSet rs = statement.executeQuery("select * from terms WHERE term = '" + term + "'" );
      rs.next();
      return rs.getString("meaning");
    }
    catch(SQLException e)
    {
      // if the error message is "out of memory",
      // it probably means no database file is found
      System.err.println("Get term error " + e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println(e);
      }
    }
    return null;
  }

}
