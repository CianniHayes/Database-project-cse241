

import java.sql.*;
import java.util.Random;
public class Insertthings {
     public static void main(String[] args) {
	 /*	try {
	    Class.forName ("oracle.jdbc.driver.OracleDriver");
	} catch(Exception e){e.printStackTrace();}
	try (
	     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar0.cse.lehigh.edu:1521:cse241","cih219","P873940065");
	     Statement s=con.createStatement();
	     ) {
	     Random r = new Random(); */
String locations[]=
{
    "NYC",
	"LA",
	"Chicago",
	"Philadelphia",
	"Phoenix",
	"San Antonio",
	"Autsin",
	"JacksonVille",
	"Indianapolis",
	"San Francisco",
	"Columbus"

};


String typesde[]={
    "F150",
    "Mustang",
    "CS71",
    "Cooper",
    "Hayesmobile",
    "J80",
    "Lehighser",
};

String typesof[]={
    "Chrysler",
    "Dodge",
    "Ford",
    "Lincoln",
    "GM",
    "Tessla",
    "Hennessey",
};

String typess[]={
  "Jeep",
  "SUV",
  "Minivan",
  "punchbuggy",
  "bubblebee",
"Bigwheels",
"submarine"
};

int time[]={
    1150,
    1500,
    930,
    1930,
    930,
    1755,
    2317,
    1500,
    1500,
    1341,
    930,
    1213,
    2343,
    2317,
    2343,
    1930,
    1930,
    1930,
    1930,
    1400,
    2400,
    1917,
    1456,
    1341,
    2343,
    2343,
    2343,
    2343,
    2317,
    2155,
    1930,
    1221,
    1755,
    1400,
    1500,
    1930,
    2343,
    1341,
    1930,
    1930,
    2317,
    1930,
    930,
    1930,
    1930,
    1221,
    1341,
    1221,
    1341,
    1221,
    1650,
    1500,
    930,
    1930,
    930,
    1755,
    2317,
    1500,
    1500,
    1341,
    930,
    1213,
    2343,
    2400,
    2343,
    1930,
    1930,
    1930,
    2400,
    1400,
    2400,
    1917,
    1456,
    1341,
    2343,
};
int time2[]={
    978,
1013,
530,
1221,
855,
1221,
900,
1013,
530,
1221,
855,
800,
800,
    900,
943,
641,
800,
1221,
900,
1930,
2317,
1221,
1221,
855,
2317,
943,
641,
641,
530,
530,
1221,
943,
1013,
1013,
800,
1930,
855,
530,
800,
530,
1930,
900,
1013,
1255,
800,
641,
855,
900,
800,
1930,
1255,
530,
530,
530,
1255,
855,
1013,
943,
855,
1930,
530,
1221,
1930,
2317,
900,
900,
2317,
800,
2317,
943,
943,
1255,
943,
530,
6419,
    1013,
530,
1221,
855,
1221,
900,
1013,
530,
1221,
855,
800,
800,
900,
943,
641,
800,
1221,
900,
1930,
2317,
1221,
1221,
855,
2317,
943,
641,
641,
530,
530,
1221,
943,
1013,
1013,
800,
1930,
855,
530,
800,
530,
1930,
900,
1013,
1255,
800,
641,
855,
900,
800,
1930,
1255,
530,
530,
530,
1255,
855,
1013,
943,
855,
1930,
530,
1221,
1930,
    2317,
900,
900,
2317,
800,
2317,
943,
943,
1255,
943,
530,
641
};
	
for( int j =0; j<75; j++){
    int num=(int)(Math.random()*11);
    int num2= (int)((Math.random()*2400)+ 1200);
    System.out.println(time[j]-time2[j]);
    /* System.out.println("------------------");
    System.out.println(num2);
    System.out.println("------------------");
    System.out.print(num2-num);

    */
}



	String q;
		ResultSet result;
		int randnum=0;
		int exc=0;	
		int rates=200;
		/*(*		for( int i = 0; i < 75; i++){
		    int season= (int)(Math.random()*4);
		    int type= (int)(Math.random()*7);
		    int purch_num=(int)((Math.random()*99999999)+100000000 );
		    int charge= (int)(Math.random()*999);
		    rates= (int)(Math.random()*100 +.5);
		    int vehicle_r= (int)((Math.random()*500)+250);
		    System.out.println(vehicle_r);
		    q = "insert into rates(vechicle_type, time_of_year, purch ,rate_charges, vehicle_rate) values('" + time[season] + "','" + types[type] + "'," + purch_num+ "," + rates + "," + vehicle_r +")";




		//"insert into dropoffcharges(pickup_loc, return_loc, distance_driven, rate_charges) values('"+ locations[randval]  +  "','" +  locations[randval]  + "'," + code+ "," + norm + ")";



// "insert i00nto discountcodes(normal_rate, group_rate, membership_dis, discount_code) values(" + norm + "," +group+ "," + dis +"," + code+ ")";


// "insert into Customer(license_num, reservation_num, name, phys_add) values (" +ids+"," + res +  ",'" +  name[i] +"','"   + streets[i] +"')";
		    //		    int norm= (int)(Math.random()*200);
		    // int group=(int)(Math.random()*200);

		    // int dis=(int)(Math.random()*200);

		    // int code=(int)((Math.random()*99999999)+100000000 );
		   

		    exc = s.executeUpdate(q); */
		// }
		//System.out.println ("value returned: " + exc);
		// } catch(Exception e){e.printStackTrace();}
     }
}
