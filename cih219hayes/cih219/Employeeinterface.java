import java.sql.*;
import java.util.Scanner;
public class Employeeinterface{
    public static void main(String[]args){
        try {
            Class.forName ("oracle.jdbc.driver.OracleDriver");
        } catch(Exception e){e.printStackTrace();}
        Scanner sc = new Scanner(System.in);
	int flag =0;
	while(flag==0){
	System.out.println("Enter user");	
String username= sc.next();
	System.out.println("Enter password");
	String password= sc.next();
	try (

	     Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@edgar0.cse.lehigh.edu:1521:cse241", username , password);

	     Statement s = connection.createStatement();)
		{
		    flag=1;
		    int exc=0;
 System.out.println("Please enter your employee id");
     ResultSet emps;
     String valid= "";
     String empid= "";  
 
  empid= sc.next();	 


 String whichemp= "select   firstname , LASTNAME from employee where emp_id= '" + empid + "'";                  
 String fn= "";
 String ln= "";
 //     ResultSet emps;

 emps= s.executeQuery(whichemp);

 if(!emps.next()){
     System.out.println("Invalid ID");

 }
 else{
     System.out.println("Hello " +emps.getString("firstname") + " " + emps.getString("lastname"));
     fn=emps.getString("firstname");
ln= emps.getString("lastname");

 }
    
 // System.out.println("Hello employee of Hurts Rent a Lemon");
		   		    
 System.out.println("Are you helping to make (M) a reservation or return (R) a reservation?");
		    String response= sc.next();
		    //		    System.out.print(response);
		    if(response.equalsIgnoreCase("M")){
			    System.out.println("Great time to sell sell sell:");
			    //	    System.out.println("Please enter your Zip");
			    String whatZip= "select ZIP from physicallocation, EMPLOYEE where physicallocation.RENTAL_CITY= EMPLOYEE.WORK_LOC and emp_id= '"+ empid +"' ";
			    emps=s.executeQuery(whatZip);

			    String zip= " ";
			    if(!emps.next()){
				System.out.println("couldnt find info on you");
				return;	
		    }
			    else{
			    
				//				System.out.println(emps.getString("ZIP"));
			       zip= emps.getString("ZIP");
 //			    System.out.println(zip);

			    }
			    System.out.println("Alright " + fn +" " +ln + "heres what we have in your Zip code" + " " + zip + " :");
				String empinfo= "with info as (select * from employee, physicallocation where physicallocation.rental_city= employee.work_loc) select distinct  inventory, make, model, type, vehicle_id from VEHICLEINFO, info where VEHICLEINFO.AVALIABLE_IN_ZIP = '" + zip +"' and info.zip= VEHICLEINFO.AVALIABLE_IN_ZIP ";

				String vec= "";
ResultSet ava;
ava= s.executeQuery(empinfo);
if(!ava.next()){
    System.out.println("We have nothing in stock");

}
else{
    while(ava.next()){
	System.out.println("We have " +  ava.getString("Inventory") + " " + ava.getString("make") +" "  +ava.getString("model") + " " +ava.getString("type") +" " +"in stock. There vehicle ids are" + " " + ava.getString("vehicle_id"));
    }
    //    vec=ava.getString("vehicle_id");

}

System.out.println("Please ask the customer wht type of car from our inventory they are looking to rent from these options and input those values");

System.out.println("The customer would like to rent the make:");
String make= sc.next();
System.out.println("The customer would like to rent the model:");
String model= sc.next();
System.out.println("The customer would like to rent the type:");
String type= sc.next();

System.out.println("Thank You we will update our tables.");

String update= "update VEHICLEINFO set INVENTORY= INVENTORY-1 where make='" +make + "' and model = '" +model+ "' and TYPE= '" +type+"' and AVALIABLE_IN_ZIP='" +zip+"'" ;
exc=s.executeUpdate(update);
System.out.println("value returned:" +exc);
	
		    }





		      if(response.equalsIgnoreCase("R")){
			  ResultSet sets;
			  System.out.println("That will be no problem we will just need there license number");
			  String lic= sc.next();
			  String resnum="";
			  String vehid="";			
			  String corlic= "select reservation_num from customer where license_num='" +lic + "'";

			  sets= s.executeQuery(corlic);
			  if(!sets.next()){
			      System.out.println("Please enter valid ID number that one is not in our system");
			      while(!sets.next()){
				      lic=sc.next();
				  }
			  }
			  else{
			      resnum=sets.getString("reservation_num");
			  }
			
			  // System.out.println(resnum);
			  String vehinfo= "select vehicle_id from reservationinfo where reservationinfo.LICENSE_NUM= '" + lic + "' ";

			  sets= s.executeQuery(vehinfo);
                          if(!sets.next()){
                              System.out.println("We have no vehicle info on you");
			      return;
                          }
                          else{
                              vehid=sets.getString("vehicle_id");
                          }
			  System.out.println(vehid);
			  String cost= "select total_cost,rate_charge_id from costs, customer where  costs.RATE_CHARGE_ID = customer.RATE_CHARGE_ID and customer.LICENSE_NUM='" + lic + "'";
			  sets = s.executeQuery(cost);
			  String cuscos="";
			  String rid="";
			  if(!sets.next()){
                              System.out.println("We have no vehicle info on you" );
                              return;
                          }
                          else{
                              cuscos=sets.getString("total_cost");
			      rid= sets.getString("rate_charge_id");
			      System.out.println("Please inform them that their total cost for the rental will be $" + cuscos);
                          }


			  String updateinv= "update vehicleinfo set inventory= INVENTORY+1 where VEHICLE_ID='"+ vehid+"'";
			  exc= s.executeUpdate(updateinv);
			  System.out.println("exc" + exc);			  
			  String deleteres="delete from RESERVATIONINFO where LICENSE_NUM='"+ lic +"' ";
			  exc=s.executeUpdate(deleteres);
			  System.out.println("exc" + exc);   
			  String deletecus= "delete from customer where LICENSE_NUM='" +lic + "' "; 
			  exc= s.executeUpdate(deletecus);
			  System.out.println("exc" + exc);   
			  String deletecost= "delete from cost where rate_charge_id='" + rid + "'";



		      }
		
		}catch(Exception e){
	    System.out.println("Exception thrown:" + e);
	    System.out.println("Sorry couldnt connect to that account");
}
	}
}
}