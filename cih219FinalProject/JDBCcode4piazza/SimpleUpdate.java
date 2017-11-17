import java.sql.*;
public class SimpleUpdate {
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
           int i;
           q = "create table enemies2 (dog_name varchar(20), weight numeric(9,2))";
           i = s.executeUpdate(q);
           System.out.println ("value returned: " + i);
           s.close();
           con.close();
         } catch(Exception e){e.printStackTrace();}
  }
}