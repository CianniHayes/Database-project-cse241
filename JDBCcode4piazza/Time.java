import java.io.*;
import java.sql.*;
import java.util.Scanner;
class Time {
  public static void main (String[] arg) {
    try {
      Class.forName ("oracle.jdbc.driver.OracleDriver");
    } catch(Exception e){e.printStackTrace();}    
    try (
         Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar0.cse.lehigh.edu:1521:cse241","abc123","password");
         Statement s=con.createStatement();
         ) {
           Scanner krb = new Scanner(System.in);
           System.out.print("Input start time): ");
           String ts = krb.nextLine();
           System.out.print("Input end time): ");   
           String te = krb.nextLine();
           String q = "insert into TZ values ('" + ts + "', '" + te + "')";
           System.out.println(q);
           int i = s.executeUpdate(q);
           q = "select t_start, t_end, t_end - t_start as diff from TZ";
           System.out.println(q);
           ResultSet result = s.executeQuery(q);
           if (!result.next()) System.out.println ("Empty result.");
           else {
             do {
               System.out.println (result.getString("t_start") + "    " +
                                   result.getString("t_end") + "     " +
                                   result.getString("diff"));
             } while (result.next());
           }
         } catch(Exception e){e.printStackTrace();}
  }
}