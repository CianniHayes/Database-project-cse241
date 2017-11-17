import java.sql.*;
import java.util.Scanner;
public class Projectinterface{
    public static void main(String[]args){
	try {
            Class.forName ("oracle.jdbc.driver.OracleDriver");
        } catch(Exception e){e.printStackTrace();}
        Scanner sc = new Scanner(System.in);
	int flag= 0;
	//      do{
	while(  flag== 0){
	    System.out.println("Enter oracle user Id:");
	    String i = sc.next();
	    System.out.println("Enter oracle password:");
	    String pass= sc.next();
      
	    //Connection connection;
	    	    try (
			 //Connection 
Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@edgar0.cse.lehigh.edu:1521:cse241", i , pass);

		 Statement s = connection.createStatement();)
		    {
					flag=1;
			int exc=0;
		    System.out.println("Hello Welcome to Hurts Rent-A-Lemon...Rent a painfully bad, cheap car");
		    System.out.println("Are you a Customer (C) or Employee (E)?");
		    String core= sc.next();
		    if(core.equalsIgnoreCase("c")){









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
			    try{
System.out.println("If you would like to know your cost please insert your license_num");
licensenum= sc.nextInt();
//if(licensenum < 1000000000 || licensenum>1000000000){
while(licensenum < 100000000){// || licensenum>10000000000){
	System.out.println("Please enter a valid license_num");		    
licensenum= sc.nextInt();
}
			   
			    }catch(Exception e){
				System.out.println("Exception Thrown :" + e);
				System.out.println("Your licsense number doesnt exist in our system");			    
}
 String totalcost= "select total_cost from COSTS,customer where customer.rate_charge_id= COSTS.RATE_CHARGE_ID and customer.LICENSE_NUM=" +"'" +licensenum+ "'"; 
 			    set= s.executeQuery(totalcost);
			    if(!set.next()){
				System.out.println("License num does not exist");
				return;
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
			}
		    else if(core.equalsIgnoreCase("e")){
			String done="n";
			
			System.out.println("Please enter your employee id");
			ResultSet emps;
			String valid= "";
			String empid= "";
			
			empid= sc.next();


 String whichemp= "select   firstname , LASTNAME,emp_id from employee where emp_id= '" +empid + "'";
 String fn= "";
 String ln= "";
 //     ResultSet emps;

 emps= s.executeQuery(whichemp);
 System.out.println("i get here");
 String emp_id= ""; 
if(!emps.next()) {
    emp_id=emps.getString("emp_id");
    System.out.println(emp_id);
 System.out.println("i get here 2");
  
  while(empid!= emp_id){
  
	 System.out.println("Enter valid id please");
	 empid=sc.next();
  }emps= s.executeQuery(whichemp);
 
 }
 else{
     System.out.println("Hello " +emps.getString("firstname") + " " + emps.getString("lastname"));
     fn=emps.getString("firstname");
     ln= emps.getString("lastname");
 }
 String response= "";
 do{
     System.out.println("Are you helping to make (M) a reservation or return (R) a reservation?");
      response= sc.next();
     //              System.out.print(response);
     if(response.equalsIgnoreCase("M")){
	 System.out.println("Great time to sell sell sell:");

	 //              String whatZip= select ZIP from physicallocation, EM
	 //PLOYEE where physicallocation.RENTAL_CITY= EMPLOYEE.WORK_LOC and emp_id= ' 

String whatZip= "select ZIP from physicallocation, EMPLOYEE where physicallocation.RENTAL_CITY= EMPLOYEE.WORK_LOC and emp_id= '"+ empid +"' ";

                            emps=s.executeQuery(whatZip);

                            String zip= " ";
                            if(!emps.next()){
                                System.out.println("couldnt find info on you");
                                return;
			    }
                            else{

                              	zip= emps.getString("ZIP");
			 }
			    System.out.println("Alright " + fn +" " +ln + "heres what we have in your Zip code" + " " + zip + " :");


                                String empinfo= "with info as (select * from employee, physicallocation where physicallocation.rental_city= employee.work_loc) select distinct  inventory, make, model, type, vehicle_id from VEHICLEINFO, info where VEHICLEINFO.AVALIABLE_IN_ZIP = '" + zip +"' and info.zip= VEHICLEINFO.AVALIABLE_IN_ZIP";

                                String vec= "";
				ResultSet ava;
				String vecid="";
				ava= s.executeQuery(empinfo);
				if(!ava.next()){
				    System.out.println("We have nothing in stock");

				}
				else{
 vecid=ava.getString("vehicle_id");

				    while(ava.next()){
					System.out.println("We have " +  ava.getString("Inventory") + " " + ava.getString("make") +" "  +ava.getString("model") + " " +ava.getString("type") +" " +"in stock. There vehicle ids are" + " " + ava.getString("vehicle_id"));
				    }
				   
				}

				System.out.println("Please ask the customer wht type of car from our inventory th ey are looking to rent from these options and input those values");

				System.out.println("The customer would like to rent the make:");
				String make= sc.next();
				System.out.println("The customer would like to rent the model:");
				String model= sc.next();
				System.out.println("The customer would like to rent the type:");
				String type= sc.next();
				


String update= "update VEHICLEINFO set INVENTORY= INVENTORY-1 where make='" +make+ "' and model = '" +model+ "' and TYPE= '" +type+"' and AVALIABLE_IN_ZIP='" +zip+"'" ;
exc=s.executeUpdate(update);
System.out.println("value returned:" +exc);
System.out.println("Please enter there license num");
String lic= sc.next();

int rate_charge_id= (int)((Math.random()*999999999)+100000000);


System.out.println("Great Please enter there first name");
				String first= sc.next();
				System.out.println("Please enter there last name");
				String last=sc.next();
				String name= first+" " +last;
				System.out.println("Please enter there street name");
				String address=sc.next();
				System.out.println("Please enter there insurance_num");
				String insurance= sc.next();
				rate_charge_id= (int)((Math.random()*999999999)+100000000);
				int res= (int)((Math.random()*999999999)+100000000);
                        String newtuple= "insert into customer values('"+name+"','" + address+ "','"+ lic + "','" + res + "','" + insurance + "','" + rate_charge_id+ "','" + zip + "')";

			exc=s.executeUpdate(newtuple);

			System.out.println("value returned:" +exc);
	

                        System.out.println("Just to recap your name is: " +name+ " your liscense number is: " + lic + " your address is: " + address + "and the car you are requesting is: " +model +" " + make+ " " + type);


	       
                        String resinfo= "insert into reservationinfo values('" +lic + "','" + vecid +"','" + zip +"')";
                        exc=s.executeUpdate(resinfo);
                        System.out.println("value returned:" +exc);












				System.out.println("Thank You we will update our tables.");
  














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
                          String cost= "select total_cost, costs.rate_charge_id from costs, customer where costs.RATE_CHARGE_ID = customer.RATE_CHARGE_ID and customer.LICENSE_NUM='" + lic + "'";

			  // System.out.println("i get past cost");
			  sets = s.executeQuery(cost);

			  System.out.println("i get past cost");                          
String cuscost="";
                          String rids="";
                          if(!sets.next()){
                              System.out.println("We have no vehicle info on you");
                              return;
                          }
                          else{
                              cuscost=sets.getString("total_cost");
                              rids= sets.getString("rate_charge_id");
                              System.out.println("Please inform them that their total cost for the rental will be $" + cuscost);
                          }


                          String updateinv= "update vehicleinfo set inventory= INVENTORY+1 where VEHICLE_ID='"+ vehid+"'";

                          exc= s.executeUpdate(updateinv);

                          System.out.println("exc" + exc);                       

                          String deleteres="delete from RESERVATIONINFO where LICENSE_NUM='"+ lic +"' ";
			  exc= s.executeUpdate(deleteres);

       String deletecus= "delete from customer where LICENSE_NUM='" +lic + "' ";

       exc= s.executeUpdate(deletecus);

                         

       		    
       //                   exc= s.executeUpdate(deletecus);
                          System.out.println("exc" + exc);
                          String deletecost= "delete from costs where rate_charge_id='" + rids + "'";
			  exc= s.executeUpdate(deletecost);


     }
		  
System.out.println("Will that be all today (Y or N)");
done= sc.next();
if(done.equalsIgnoreCase("Y")){
	System.out.println("Great job selling keep up the good work");
    }
 
 }while(done.equalsIgnoreCase("N"));
		


		    }

		 
		    } catch(Exception e){
		System.out.println("Exception" + e);
		System.out.println("Please try again");		    
		}
	}
		
	System.out.println("Exiting Program Now");
    }
}