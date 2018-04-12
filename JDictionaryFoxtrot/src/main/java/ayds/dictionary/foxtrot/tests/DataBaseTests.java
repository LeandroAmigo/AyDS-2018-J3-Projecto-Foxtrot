package ayds.dictionary.foxtrot.tests;

import java.sql.*;

public class DataBaseTests {

    public static void testDB()
    {

        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:./dictionary.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            //statement.executeUpdate("drop table if exists person");
            //statement.executeUpdate("create table person (id integer, name string)");
            //statement.executeUpdate("insert into person values(1, 'leo')");
            //statement.executeUpdate("insert into person values(2, 'yui')");
            ResultSet rs = statement.executeQuery("select * from terms");
            while(rs.next())
            {
                // read the result set
                System.out.println("id = " + rs.getInt("id"));
                System.out.println("term = " + rs.getString("term"));
                System.out.println("meaning = " + rs.getString("meaning"));
                System.out.println("source = " + rs.getString("source"));

            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
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
    }

}
