import java.sql.*;
public class SimpleSelect {
  public static void main(String[] args) {
    try {
      Class.forName ("oracle.jdbc.driver.OracleDriver");
    } catch(Exception e){e.printStackTrace();}    
    try (
         Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar0.cse.lehigh.edu:1521:cse241","abc123","password");
         Statement s=con.createStatement();
         ) {
           System.out.println("connection successfully made.");
           String q;
           ResultSet result;
           q = "select X.course_id, Y.course_id as Prereq1, Z.course_id as Prereq, Z.prereq_id as Prereq from dbcourse.prereq X, dbcourse.prereq Y, dbcourse.prereq Z where Z.course_id = Y.prereq_id and Y.course_id = X.prereq_id";
           result = s.executeQuery(q);
           if (!result.next()) System.out.println ("Empty result.");
           else {
             do {
               System.out.println (result.getString("Prereq1") + " " + result.getString("Prereq"));
             } while (result.next());
           }
	   System.out.println("Enter ID of instructor whose records you are seeking")
	       String ID= sc.next();
	   int realid= Integer.parseInt(ID);
	   while(realid<0 || realid>99999){

	       System.out.println ("Enter Valid ID between 0 and 99999");


	   }

         } catch(Exception e){e.printStackTrace();}
  }
}