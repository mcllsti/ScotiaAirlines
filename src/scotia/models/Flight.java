package scotia.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
//DARYL MCALLISTER
//Flight classes that will deal with the attributes and functions of a flight entity
public class Flight {
	
	public Flight(int columnsIn, int rowsIn) //CONSTRUCTOR
	{
		flightNumber = "";
		departure = "";
		arrival = "";
		date = new Date();
		freeSeats = columnsIn * rowsIn;
		bookedSeats = 0;
		reservedSeats = 0;
		columns = columnsIn;
		rows = rowsIn;
		isFull = false;
		checkingIn = false;
		closed = false;
		boarding = false;
		statusMessage = "";
		seats = new HashMap<String,Seat>();
		totalFlightTakings = 0;
	}
	
	private String flightNumber;
	private String departure;
	private String arrival;
	private Date date;
	private int freeSeats;
	private int bookedSeats;
	private int reservedSeats;
	private int columns;
	private int rows;
	private boolean isFull;
	private boolean checkingIn;
	private boolean closed;
	private boolean boarding;
	private String statusMessage;
	private HashMap<String,Seat> seats;
	private float totalFlightTakings;
	
	//GETTERS
	public String getFlightNumber()
	{
		return flightNumber;
	}
		
	public String getDeparture()
	{
		return departure;
	}
	
	public String getFlightStatus()
	{
		return statusMessage;
	}
	
	public String getArrival()
	{
		return arrival;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public int getFreeSeats()
	{
		return freeSeats;
	}
	
	public int getBookedSeats()
	{
		return bookedSeats;
	}
	
	public int getReservedSeats()
	{
		return reservedSeats;
	}
	
	public boolean getIsFull()
	{
		return isFull;
	}
	
	public boolean getCheckingIn()
	{
		return checkingIn;
	}
	
	public boolean getClosed()
	{
		return closed;
	}
	
	public boolean getBoarding()
	{
		return boarding;
	}
	
	public float getTotalFlightTakings()
	{
		return totalFlightTakings;
	}
	
	public HashMap<String,Seat> getSeats()
	{
		return seats;
	}
	
	public int getRows()
	{
		return rows;
	}
	
	public int getColumns()
	{
		return columns;
		
	}
	
	public void setTotalFlightTakings(float totalTakings){totalFlightTakings = totalTakings;}
	
	
	//Sets a mulititute of attributes
	public void setFlightDetails(String flightNo, String depAirport, String arrAirport)
	{
		flightNumber = flightNo;
		departure = depAirport;
		arrival = arrAirport;
	}
	
	//Sets the flight status depending on 
	public void setFlightStatus(int status)
	{
		switch(status) //Switch statement for readability
		{
		case 1: checkingIn = true;
		boarding = false;
		closed = false;
		statusMessage = "Checking in";
		break;
		
		case 2: checkingIn = false;
		boarding = true;
		closed = false;
		statusMessage = "Boarding";
		break;
		
		case 3: checkingIn = false;
		boarding = false;
		closed = true;
		statusMessage = "Flight Closed";
		break;
		
		case 4: closed = false;
				boarding= false;
				checkingIn = false;
				statusMessage= "Seats Available";
		}
	}
	
	//Updates a seat 
	public void updateSeat(int Choice)
	{
		switch(Choice) //Switch statement for reability
		{
			case 1: freeSeats++;
			reservedSeats--;
			if(!boarding && !closed)
			{
				statusMessage = "Seats available";
				isFull = false;
			}
			break;
			
			case 2: freeSeats++;
			bookedSeats--;
			if(!boarding && !closed)
			{
				statusMessage = "Seats available";
				isFull = false;
			}
			break;
			
			case 3: reservedSeats++;
			freeSeats--;
			break;
			
			case 4: bookedSeats++;
			freeSeats--;
			break;
			
			case 5: bookedSeats++;
			reservedSeats--;
			break;
			
			case -1: break;
		}
		
		if(freeSeats == 0) //If no free seats
		{
			isFull = true;
			statusMessage = "Flight Full";
		}
	}
	
	//Calculates the overall money the flight has taken 
	public float calculateTotalFlightTakings()
	{
		totalFlightTakings = 0;
		for(Map.Entry<String, Seat> tempSeat : seats.entrySet())
		{
			totalFlightTakings = totalFlightTakings + tempSeat.getValue().getSeatTakings();
		}
		return totalFlightTakings;
	}
	
	//Outputs the flight information
	public String displayFlightInfo()
	{
		String output = "";

			
			output="<html> Flight Number: " + flightNumber + "<br/> Arrival Airport: " + arrival + 
					"<br/> Departure: " + departure + "<br/> Number of Free Seats: " + freeSeats +
					"<br/>Reserved Seats: " + reservedSeats + 
					"<br/> Booked Seats: " + bookedSeats + 
					"<br/> Status: " + statusMessage + 
					"<br/>Flight Takings: £" + totalFlightTakings + "</html>";
			
			return output;
	}
	
	//Checks if seat number is valid
	public boolean isValidSeatNo(String seatNo)
	{
		String number = "";
		String letter = "";
		int checkIfNum;
		int element = -1;
		boolean shouldLeaveLoop = false;
		
		for(char c : seatNo.toCharArray()) //Puts the seat number in a character array
		{
			if(!shouldLeaveLoop)
			{
				try
				{
					String character;
					character = String.valueOf(c);
					checkIfNum = Integer.parseInt(character); //checks if it is a number
					number = number + c;
					element++;
				}
				catch(Exception e)
				{
					shouldLeaveLoop = true; //makes exiting the loop possbale
				}
			}
		}
		
		boolean lastPartIsCharacter = true;
		letter = seatNo.substring(element + 1);
		if(letter.length() == 1)
		{
			char letterChar = letter.charAt(0);
			if(!Character.isLetter(letterChar))
			{
				lastPartIsCharacter = false;
			}
		}
		else
		{
			lastPartIsCharacter = false;
		}
		
		try
		{
			if(Integer.parseInt(number) > columns || number.equals("") || //Turns it into a int nad checks 
					letter.length()!=1 || !lastPartIsCharacter)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
}
