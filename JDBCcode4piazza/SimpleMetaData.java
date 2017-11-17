import java.sql.*;

public class SimpleMetaData {
  public static void main(String[] args) {    
    try {
      Class.forName ("oracle.jdbc.driver.OracleDriver");
    } catch(Exception e){e.printStackTrace();}    
    try (
         Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar0.cse.lehigh.edu:1521:cse241","abc123","password");
         Statement s=con.createStatement();
         ) {
           String q;
           ResultSet result;
           q = "SELECT * from instructor";
           result = s.executeQuery(q);
           ResultSetMetaData rsmd = result.getMetaData();
           for (int i = 1; i <= rsmd.getColumnCount(); i++) {
             System.out.print (rsmd.getColumnName(i) + " (");
             System.out.println (rsmd.getColumnTypeName(i) + ")");
           }
         } catch(Exception e){e.printStackTrace();}
  }
}