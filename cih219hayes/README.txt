ER Diagram Changes:

~Cost now has fuel_charge_id, insurance_charge_perday, dropoff_charge, and discount_code as foreign keys and them plus the standard cost equal up to the total cost.


~Vehicleinfo- I added the two attributes Available_in_zip and Inventory to know where the cars are available and how many of them are in that location. Also it makes the table more accessible when writting queries.


~Reservation_info- I took rate_charge_id out of reservation info because it wasnt necessary to find to have there.


~Employee- I gave each employee a work telephone number and also an employee id number


About My Interface:
  The program initially prompts you to ask if you are a customer or an employee. If you are a customer it then ask you if you are a new or returning customer meaning you already have a reservation with us at the current time. If you are a new customer it then prompts you about which car you would like to rent. All of that information then gets loaded to the database and your reservation is made. If you are a returning customer it will ask you if you need either your reservation number or if you need your cost. The program will present you with that information respectivly based on what your chose. If you are an employee the porgram will ask if you plan to rent to a customer or return the rental. If you are renting it will tell you all the cars available to rent in your location and then make you cana help them make the reservation. If you are returning the vehicle it will just ask you to input there licsense number then it will delete all details pretaining to their reservation.


Problems with the program:
~Couldnt test to see if name values contained digits
~Names of people and streets shouldnt contain spaces
~Still throws exceptions if values are not correct.
~Cant test for if employee is not a valid Emp_id it will leave the program.    
