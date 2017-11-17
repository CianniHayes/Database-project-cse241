import java.sql.*;
import java.util.Scanner;
public class Projectinterface{
    public static void main(String[]args){
	try {
            Class.forName ("oracle.jdbc.driver.OracleDriver");
        } catch(Exception e){e.printStackTrace();}
        Scanner sc = new Scanner(System.in);
	int flag=0;
	while(  flag== 0){
            System.out.println("Enter oracle user Id:");
            String i = sc.next();
            System.out.println("Enter oracle password:");
            String pass= sc.next();


	    try (

		 Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@edgar0.cse.lehigh.edu:1521:cse241", i  , pass);

		 Statement s = connection.createStatement();)
		    {
			flag=1;		
	int exc=0;
		    System.out.println("Hello Welcome to Hurts Rent-A-Lemon...Rent a painfully bad, cheap car");
		    System.out.println("Lets get started are new customer (type n)or already have a reservation (type o)");
		    String response= sc.next();
		    String done;
		    if(response.equalsIgnoreCase("o")){
			do
			    {			
System.out.println("Hello returning customer");
			System.out.println("What can we help you with today?");
			System.out.println("Enter 1 if You need to know your cost");
			System.out.println("Enter 2 if you are looking for your vehicle data");
			int numeric=sc.nextInt();
			int licensenum=0;
			ResultSet set;			
			if(numeric==1){
			   
System.out.println("If you would like to know your cost please insert your license_num");
			    licensenum= sc.nextInt();
			    String totalcost= "select total_cost from COSTS,customer where customer.rate_charge_id= COSTS.RATE_CHARGE_ID and customer.LICENSE_NUM=" +"'" +licensenum+ "'"; 
 			    set= s.executeQuery(totalcost);
			    if(!set.next()){
				System.out.println("License num does not exist");

			    }	
			    else{		   
 System.out.println("$" + set.getString("total_cost"));
			    }
			}
			else if(numeric==2){
			    	
	    System.out.println("If you would like to know your vehicle data  please insert your license_num");
                            licensenum= sc.nextInt();
String vehdata= "select make, model, type, ODOMETER_READING from VEHICLEINFO, reservationinfo where VEHICLEINFO.VEHICLE_ID = reservationinfo.VEHICLE_ID and reservationinfo.LICENSE_NUM ='"+licensenum + "'";

                          set= s.executeQuery(vehdata);
                          if(!set.next()){
                               System.out.println("License num does not exist");

			  }
			  else{
			      System.out.println( set.getString("make") + " " + set.getString("model")+ " " + set.getString("type") + " " + set.getString("odometer_reading"));
			  }
			}
 System.out.println("Will that be all today? Y or N");
			  done= sc.next();
			    }while(done.equalsIgnoreCase("N"));
		    }
			   			 


		   else if(response.equalsIgnoreCase("n")){
		       String like= " ";
		       String answer;
		       do{
		System.out.println("Welcome New Customer");
			System.out.println("First well need some information from you");
			System.out.println("Please enter your first name");
			String fname= sc.next();
			System.out.println("Please enter your last name");
			String lname= sc.next();
			String name = fname + " " + lname;
			System.out.println("Thank You now we will need a street name. Just the name is fine no numbers necessary");
	     String street= sc.next();
	     String address = street.replaceAll("\\s","");	
	     System.out.println("Please insert licsense num");
			String lic_num= sc.next();
			System.out.println("Please insert your zipcode");
			String zip=sc.next();       
			System.out.println("Lastly we need your insurance_id");
			String insurance= sc.next();
			int res_num= (int)((Math.random()*999999999)+10000000);
	
			System.out.println("Great your reservation number is" + res_num);
			System.out.println("Well put you in our systems");
			System.out.println("Here are the cars we have available in you area.");
String available= "select inventory, make, model, type from VEHICLEINFO where AVALIABLE_IN_ZIP='" +zip+ "'";
ResultSet ava;
                         ava= s.executeQuery(available);
                          if(!ava.next()){
                               System.out.println("License num does not exist");

			  }
			  else{
			      while(ava.next()){
			      System.out.println("There are " +  ava.getString("inventory") + " " + ava.getString("make")+ " " + ava.getString("model") + " " + ava.getString("type")+ " in your area");
			      }
			  }




			
System.out.println("Please pick out your Vehicle data: Make, Model, and Type");
			System.out.println("Make options: Ford, Tessla, Dodge, Chrysler, Gm, Hennessey, Lincoln");

			String model= sc.next();
			String make= " ";
			boolean carry= true;
			if(model.equalsIgnoreCase("Ford")){
			   make= "Nissan";
			    }
			else if (model.equalsIgnoreCase("Tessla")){
			    make="Mustang";
			}
			else if (model.equalsIgnoreCase("Dodge")){
			    make="Mobiler";
			}
			else if (model.equalsIgnoreCase("Chrysler")){
			    make="Cooper";
			}
			else if (model.equalsIgnoreCase("GM")){
			    make="J80";
			}
			else if (model.equalsIgnoreCase("Hennessey")){
			    make="Lehigher";
			}
			else if (model.equalsIgnoreCase("Lincoln")){
			    make="Rover";
			}
			else{

			    System.out.println("Invalid entry. We do not have that type of car");
			}
			System.out.println("Great last thing is your type: bubblebee, punchbuggy, Jeep, Bigwheels, Minivan,SUV, Submarine");
			String type= sc.next();
			int rate_charge_id= (int)((Math.random()*999999999)+100000000);		
			String newtuple= "insert into customer values('"+name+"','" + address+ "','"+ lic_num + "','" + res_num + "','" + insurance + "','" + rate_charge_id+ "','" + zip + "')";

		    exc=s.executeUpdate(newtuple);
		  
		    System.out.println("value returned:" +exc); 
   int odo=(int)((Math.random()*9999)+1000);
			int vec_id= (int)((Math.random()*999999999)+10000000);
			String vehInfo= "insert into vehicleinfo values ('" +model+ "','" + make + "','" + type +"','" +odo + "','" + vec_id + "')";
		   exc=s.executeUpdate(vehInfo);
			System.out.println("value returned:" +exc);

			String resinfo= "insert into reservationinfo values('" +lic_num + "','" + vec_id +"','" + zip +"')";
			exc=s.executeUpdate(resinfo);
			System.out.println("value returned:" +exc);
			System.out.println("Just to recap your name is: " +name+ " your liscense number is: " + lic_num + " your address is: " + street + "and the car you are requesting is: " +model +" " + make+ " " + type);
			System.out.println("We would like to thank you for choosing Hurts Rent-A-Lemon...Rent a painfully bad, cheap car"); 
	    System.out.println("Will that be all today? Y or N");
		     done= sc.next();
		     System.out.println("Will you be renting another car? Y or N");
		     answer= sc.next();
		   		      
		     //System.out.println("Great let us take care of that for you");
		       }while(answer.equalsIgnoreCase("Y"));
		       System.out.println("Thank you have a great day");		
   }

		


		    
	    else{
			System.out.println("Invalid reponse");
	    }
		    }catch(Exception e){e.printStackTrace();}
	}    
}
}