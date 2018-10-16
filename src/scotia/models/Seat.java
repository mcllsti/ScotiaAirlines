package scotia.models;

public class Seat {
	//DARYL MCALLISTER
	
	
	public Seat() //CONSTRUCTOR
	{
		seatNumber = "";
		seatPrice = 100;
		seatTakings = 0;
		currentStatus = 1;
		passenger = null;
		fullSeatStatus = 0;
	}
	
	public Seat(String seatNo) //OVERLOADED CONSTRUCTOR
	{
		seatNumber = seatNo;
		seatPrice = 100;
		seatTakings = 0;
		currentStatus = 1;
		passenger = null;
		fullSeatStatus = 0;
	}
	
	public void ResetDetails() // resets details for a cancel of a seat
	{
		seatPrice = 100;
		seatTakings = 0;
		currentStatus = 1;
		passenger = null;
		fullSeatStatus = 0;
	}
	
	private String seatNumber;
	private float seatPrice;
	private float seatTakings;
	private int currentStatus;
	private Passenger passenger;
	private int fullSeatStatus;
	
	//GETTERS AND SETTERS
	public String getSeatNumber()
	{
		return seatNumber;
	}
	
	public void setSeatNumber(String seatNo)
	{
		seatNumber=seatNo;
	}
	
	public float getSeatPrice()
	{
		return seatPrice;
	}
	
	public void setSeatPrice(float price)
	{
		seatPrice = price;
	}
	
	public float getSeatTakings()
	{
		return seatTakings;
	}
	
	public void setSeatTakings(float takings)
	{
		seatTakings = takings;
	}
	
	public int getCurrentStatus()
	{
		return currentStatus;
	}
	
	public void setCurrentStatus(int status)
	{
		currentStatus = status;
	}
	
	public Passenger getPassenger()
	{
		return passenger;
	}
	
	public void setPassenger(Passenger person)
	{
		passenger = person;
	}
	
	public int getFullSeatStatus()
	{
		return fullSeatStatus;
	
	}
	
	public void setFullSeatStatus(int fullStatus)
	{
		fullSeatStatus = fullStatus;
	}
	

	//Outputs the seat details
	public String displaySeatDetails()
	{
		String output = "";
		String seatStatus = "";
		
		switch(currentStatus) //Switch statement for ease of reading
		{
			case 1: seatStatus = "Free";
			break;
		
			case 2: seatStatus = "Reserved";
			break;
		
			case 3: seatStatus = "Booked";
			break;
		}
		
		output="<html> Seat Number: " + seatNumber + "<br/> Current Status:" + seatStatus + 
				"<br/> Seat Cost:: £" + seatPrice + "<br/> Seat Takings: £" + seatTakings;
		
		if(passenger != null) //As long as the passenger is not null
		{
			output = output + "<br/> Passenger: " + passenger.getPassengerName();
		}
		
		output = output + "</html>";
		return output;
	}
	
	//Changes the seats status 
	public int changeSeatStatus(int seatStatus, float currentSeatTakings, String passengerName, 
			char passengerType , String passengerInfo)
	{
		fullSeatStatus = -1;
		seatTakings = currentSeatTakings;
		
		if(passengerType == 'I') //If hte passenger is and islander
		{
			IslandResident newPassenger = new IslandResident(passengerName, passengerInfo);
			passenger = newPassenger;
			if(seatStatus == 2)
			{
				currentStatus = 2;
				fullSeatStatus = 3;
			}
			else if(seatStatus == 3)
			{
				currentStatus = 3;
				fullSeatStatus = 4;
			}
		}
		else if(passengerType == 'B') //If the are a business travller
		{
			BusinessTraveller newPassenger = new BusinessTraveller(passengerName, passengerInfo);
			passenger = newPassenger;
			if(seatStatus == 2)
			{
				currentStatus = 2;
				fullSeatStatus = 3;
			}
			else if(seatStatus == 3)
			{
				currentStatus = 3;
				fullSeatStatus = 4;
			}
		}
		else if(passengerType == 'O') //if they are an ordinary passenger
		{
			OrdinaryPassenger newPassenger = new OrdinaryPassenger(passengerName, passengerInfo.charAt(0));
			passenger = newPassenger;
			if(seatStatus == 2)
			{
				currentStatus = 2;
				fullSeatStatus = 3;
			}
			else if(seatStatus == 3)
			{
				currentStatus = 3;
				fullSeatStatus = 4;
			}
		}
		return fullSeatStatus;
	}
	
	//Changes the seat status
	public int changeSeatStatus(Airline myAirline, int newStatus, Passenger newPassenger, Flight newFlight)
	{
		if(newStatus == 1) //If outter statement depends on the new status
		{
	        switch (currentStatus) { //Inner switch statements depend on the current status
	        
            case 1:  return -1;
            
			case 2:  currentStatus = 1;
            		 passenger = null;
            		 fullSeatStatus = 1;
                     break;
                     
			case 3: currentStatus = 1;
					passenger = null;
					fullSeatStatus = 2;
					break;
               
	        }
		}
		else if(newStatus == 2)
		{
	        switch (currentStatus) { //Inner switch statements depend on the current status
	        
            case 1:  currentStatus = 2;
            		 passenger = newPassenger;
            		 fullSeatStatus = 3;
                     break;
                     
			case 2:  return -2;
			
			case 3: return -3;
               
	        }
		}
		else if(newStatus == 3)
		{
	        switch (currentStatus) { //Inner switch statements depend on the current status
	        
            case 1:  currentStatus = 3;
            		 passenger = newPassenger;
            		 fullSeatStatus = 4;
            		 seatTakings = seatTakings + (seatPrice * newPassenger.discountAmount);
            		 break;
            		 
			case 2:  if(newPassenger.getPassengerName().equalsIgnoreCase(passenger.getPassengerName()))
					{
						currentStatus = 3;
						passenger = newPassenger;
						fullSeatStatus = 5;
						seatTakings = seatTakings + (seatPrice * newPassenger.getDiscountAmount());
					}
					else
					{
						return -4;
					}
                     break;
                     
			case 3: return -5;
               
	        }
		}
		
		return fullSeatStatus;
		
	}

}
