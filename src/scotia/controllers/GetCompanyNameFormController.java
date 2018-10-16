package scotia.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import scotia.models.Airline;
import scotia.models.BusinessTraveller;
import scotia.models.Flight;
import scotia.models.IslandResident;
import scotia.models.Seat;
//DARYL MCALLISTER
//Controller to deal with the form on the get company name 
@Controller
@RequestMapping("/getComapnyNameForm")
public class GetCompanyNameFormController {
	
	@RequestMapping(method = RequestMethod.POST)
	public String loadDefault(@RequestParam Map<String,String> requestParams, HttpServletRequest request)
	{
		
		String output = ""; 
		String name = (String)request.getSession().getAttribute("passengerName"); //gets session variable
		String company = requestParams.get("txtCompanyName");//gets input from a text box
		BusinessTraveller newPassenger = new BusinessTraveller(name, company);
		
		int choice = (int)request.getSession().getAttribute("bookingChoice"); //gets session variable
		
		Airline scotia = (Airline)request.getSession().getAttribute("airline"); //gets session variable
		
		Flight selectedFlight = (Flight)request.getSession().getAttribute("selectedFlight"); //gets session variable 
		
		Seat selectedSeat = (Seat)request.getSession().getAttribute("selectedSeat"); //gets session variable
		
		int fullSeatStatus = selectedSeat.changeSeatStatus(scotia, choice, newPassenger, selectedFlight); 

		selectedFlight.updateSeat(fullSeatStatus); // updates seat
		selectedFlight.calculateTotalFlightTakings(); //calculates flight totals
		
		scotia.ClearSeatsAndPassengers();
		scotia.saveSeatsAndPassengersToDB();
		
		
        switch (fullSeatStatus) { 
        
        case -1:  output = "Error " + selectedSeat.getSeatNumber() + " is already free!";
        		break;
        
		case 1:  output = selectedSeat.getSeatNumber() + " has been canceled";
                 break;
                 
		case 2: output = selectedSeat.getSeatNumber() + " has been canceled - no refund";
				break;
				
		case 3: output = selectedSeat.getSeatNumber() + " has been reserved by " + newPassenger.getPassengerName();
				break;
		
		case -2:
		case -4:
				output = "Error " + selectedSeat.getSeatNumber() + " has already been resereved by " + selectedSeat.getPassenger().getPassengerName();
				break;
		
		case -3: 
		case -5: 	
				output = "Error " + selectedSeat.getSeatNumber() + " has already been booked by " + selectedSeat.getPassenger().getPassengerName();
				break;
		
		case 4: 
		case 5: 
				output = selectedSeat.getSeatNumber() + " has been booked by " + newPassenger.getPassengerName();
				break;
           
        }
        
        
        request.getSession().setAttribute("message", output);
        return "genericOutput";
		
	}

}