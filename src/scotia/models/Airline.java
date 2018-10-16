package scotia.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

//DARYL MCALLISTER
//Airline class that will act as the main overall variable that will store Flights

public class Airline {
	
	public Airline() //CONSTRUCTOR
	{
		flights = new HashMap<String, Flight>();
	}
	
	private HashMap<String,Flight> flights; //Collection of flights
	

	
	//GETTER
	public HashMap<String,Flight> getFlights()
	{
		return flights;
	}
	
	//================METHODS===========
	//Adds a flight to the collection
	public void addFlight(Flight newFlight)
	{
		if(!flights.containsKey(newFlight.getFlightNumber()))
		{
			flights.put(newFlight.getFlightNumber(), newFlight); //puts the flight in the collection
		}
	}
	
	//Gets a seat from a flight with the provided flight number and seat number
	public Seat getSeat(String flightNo, String seatNo)
	{
		if (flights.containsKey(flightNo)) //If it is a flight
		{
			Flight currentFlight = flights.get(flightNo);
			if(currentFlight.getSeats().containsKey(seatNo)) // if the flight contains the seat details 
			{
				Seat tempSeat = currentFlight.getSeats().get(seatNo);
				return tempSeat;
			}
			else //if not create tempary seat witht he provided seat number 
			{
				Seat tempSeat = new Seat(seatNo);
				currentFlight.getSeats().put(seatNo, tempSeat);
				return tempSeat;
			}
		}
		else
		{
			return null;
		}
	}
	
	//Loads flights from the database
	public void loadFlightsFromDB()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); //Issueing the UcanAcess driver for database interaction
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cara\\Pictures\\ScotiaAirlines\\Airline.accdb"); //assigning a connection string to the database
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Flight"); //Issueing SQL to get all from fliight table
			
			while(rs.next()) //Getting each of hte collums data and building new flights from it
			{
				String Departure = rs.getString(1);
				String Arrival = rs.getString(2);
				int Rows = rs.getInt(3);
				int Columns = rs.getInt(4);
				String flightID = rs.getString(5);
				
				Flight newFlight = new Flight(Columns, Rows);
				newFlight.setFlightDetails(flightID, Departure, Arrival);
				flights.put(flightID, newFlight);
			}
		}
		catch(Exception ex)
		{
			String message = ex.getMessage();
		}
		
	}
	
	//Deletes all flights from the database 
	public void clearFlightsFromDB()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cara\\Pictures\\ScotiaAirlines\\Airline.accdb");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE * FROM Flight"); 
		}
		catch(Exception ex)
		{
			String message = ex.getMessage();
		}
	}
	
	//Saves current sessions flights to database
	public void saveFlightsToDB()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cara\\Pictures\\ScotiaAirlines\\Airline.accdb");
			Statement stmt = conn.createStatement();
			
			for(Map.Entry<String,Flight> f : flights.entrySet()) //For each of the flights in the hashmap it will save them
			{
				Flight flight = f.getValue(); //inserting values
				stmt.executeUpdate("INSERT INTO Flight VALUES ('" + flight.getDeparture() + "','" + 
						flight.getArrival() + "','" + flight.getRows() + "','" + flight.getColumns() +  "','" + flight.getFlightNumber() +"')");
			}
			
		}
		catch(Exception ex)
		{
			String message = ex.getMessage();
		}
	}
	

	//Saves current sessions seats to the database
	public void saveSeatsAndPassengersToDB()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cara\\Pictures\\ScotiaAirlines\\Airline.accdb");
			Statement stmt = conn.createStatement();
			
			for(Map.Entry<String, Flight> f : flights.entrySet())
			{
				Flight flight = f.getValue();
				for(Map.Entry<String, Seat> s : flight.getSeats().entrySet()) //for each seat in each flight
				{
					Seat seat = s.getValue();
					String passengerType = "";
					String passengerInfo = "";
					String passengerName = "";
					if(seat.getPassenger() != null) //makes sure passenger is not null 
					{
						if(seat.getPassenger().getClass() == (new BusinessTraveller()).getClass()) //Difrentiaties passenger types
						{
							passengerType = "B";
							passengerInfo = (((BusinessTraveller) seat.getPassenger()).getCompanyName());
							passengerName = seat.getPassenger().getPassengerName();
						}
						else if (seat.getPassenger().getClass() == (new IslandResident()).getClass())
						{
							passengerType = "B";
							passengerInfo = (((IslandResident) seat.getPassenger()).getIslandOfResidence());
							passengerName = seat.getPassenger().getPassengerName();
						}
						else
						{
							passengerType = "O";
							passengerInfo = String.valueOf((((OrdinaryPassenger) seat.getPassenger()).getCurrentPromotion()));
							passengerName = seat.getPassenger().getPassengerName();
						}
					}
					
					stmt.executeUpdate("INSERT INTO Seat VALUES ('" + seat.getSeatNumber() + "','" + seat.getCurrentStatus() + "','" + 
							seat.getSeatTakings() +  "','" + flight.getFlightNumber() +"')");
					
					stmt.executeUpdate("INSERT INTO Passenger VALUES ('" + passengerType + "','" + passengerInfo + "','" + 
							passengerName +  "','" + seat.getSeatNumber() + "','" +  flight.getFlightNumber() +"')");	
				}
				
			}
			
			
			
		}
		catch(Exception ex)
		{
			String message = ex.getMessage();
		}
	}
	
	//Loads the seats from the database
	public void loadSeatsFromDB()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cara\\Pictures\\ScotiaAirlines\\Airline.accdb");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Seat");
			
			
			
			while(rs.next())
			{
				String seatNumber = rs.getString(1);
				int currentStatus = rs.getInt(2);
				int seatTakings = rs.getInt(3);
				String FlightId = rs.getString(4);
				
				Seat loadedSeat = getSeat(FlightId,seatNumber);
				loadedSeat.setCurrentStatus(currentStatus);
				loadedSeat.setSeatTakings(seatTakings);
				

			}
		}
		catch(Exception ex)
		{
			String message = ex.getMessage();
		}
	}
	
	//Loads the passengers from the database
	public void loadPassengersFromDB()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cara\\Pictures\\ScotiaAirlines\\Airline.accdb");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Passenger");
			
			
			
			while(rs.next())
			{
				String passengerInfo = rs.getString(2);
				String passengerType = rs.getString(1);
				String seatNo = rs.getString(4);
				String passengerName = rs.getString(3);
				String FlightId = rs.getString(5);
				
				
				
				Seat loadedSeat = getSeat(FlightId,seatNo);
				int fullSeatStatus = loadedSeat.changeSeatStatus(loadedSeat.getCurrentStatus(), loadedSeat.getSeatTakings(), passengerName,
						passengerType.charAt(0), passengerInfo);
				
				Flight loadedFlight= flights.get(FlightId);
				loadedFlight.updateSeat(fullSeatStatus);
				loadedFlight.calculateTotalFlightTakings();

			}
		}
		catch(Exception ex)
		{
			String message = ex.getMessage();
		}
	}
	
	public void ClearSeatsAndPassengers()
	{
		
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cara\\Pictures\\ScotiaAirlines\\Airline.accdb");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE * FROM Seat"); 
			stmt.executeUpdate("DELETE * FROM Passenger"); 
		}
		catch(Exception ex)
		{
			String message = ex.getMessage();
		}
		
	}
	
	
	
	
	
	
	
	
	

}
