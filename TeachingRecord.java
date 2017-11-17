import java.sql.*;
import java.util.Scanner;
public class TeachingRecord{
    public static void main(String[]args){
		try {
	    Class.forName ("oracle.jdbc.driver.OracleDriver");
	} catch(Exception e){e.printStackTrace();}
	Scanner sc = new Scanner(System.in);

	//Connection connection;
	//Statement s;

		int flag= 0;	
		//	do{
		while(  flag== 0){
      System.out.println("Enter oracle user Id:");
        String i = sc.next();
System.out.println("Enter oracle password:");
	String pass= sc.next();

	try ( 
 
Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@edgar0.cse.lehigh.edu:1521:cse241", i , pass);

Statement s = connection.createStatement();)
		{
flag=1;
	     
        System.out.println("Input Substring of Instuctor:");	
	String sub= sc.next();
	ResultSet res;
String wants= "select instructor.id as ID, instructor.name as Name from instructor where name like(" + "'%" + sub + "%'" + ")";
	res = s.executeQuery(wants); //error executing query
	
if(!res.next()){
	    System.out.println("Empty String.");
}
	else{
	    do{
		System.out.println( res.getString("ID") + " " + res.getString("Name"));
	    }while(res.next());
	}	
    System.out.println("Enter ID of instructor whose records you are seeking");
	
   String IDs= sc.next();

	    ResultSet finals;
	    
	    String findID= "with firstquery as (SELECT distinct dept_name as Department, course.course_id as CNO, title , teaches.sec_id as SEC, teaches.semester as SEM, teaches.year, takes.id as ID FROM teaches, takes ,course WHERE teaches.sec_id = takes.sec_id and teaches.id =" +IDs+ 
			     "and teaches.course_id = course.course_id and takes.course_id = course.course_id order by dept_name) SELECT Department , CNO, title,SEC, SEM, year, Count(ID) as Enrollment  From firstquery GROUP BY title, Department, SEC, SEM, year, CNO ORDER BY Department, CNO";


 finals = s.executeQuery(findID);

	   if(!finals.next()){
	       System.out.print("No classes available");
	   }
	   else{	   
do{	   	   
       	  

    System.out.println( finals.getString("Department") + " " + finals.getString("CNO")+ " " +  finals.getString("Title") + " " +   finals.getString("SEC") + " " +  finals.getString("SEM") + " " +   finals.getString("Year") + " " + finals.getString("Enrollment"));
}
while(finals.next());
	   }
	
	    } catch(Exception e){e.printStackTrace();}
		}
    }
}                                              



