/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adm
 */
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sun.jdbc.odbc.JdbcOdbcDriver;
public class Test {
public static void main (String[] args) throws SQLException, ClassNotFoundException  {
//Driver driver = new sun.jdbc.odbc.JdbcOdbcDriver();
//DriverManager.registerDriver(driver);
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:eCommerce";
Connection conn= DriverManager.getConnection(url);

ResultSet resultat= null;
Statement stm = conn.createStatement();
resultat=stm.executeQuery("select * from Product");
while(resultat.next())
{
System.out.println("id du produit: "+resultat.getString("Id"));
}


//System.out.print(resultat.getInt(2));
resultat.close();
stm.close();
conn.close();


}
}
