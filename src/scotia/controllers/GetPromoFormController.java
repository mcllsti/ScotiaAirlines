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
import scotia.models.OrdinaryPassenger;
import scotia.models.Seat;
//DARYL MCALLISTER

//deals with the form on the get promo jsp
@Controller
@RequestMapping("/getPromoForm")
public class GetPromoFormController {
	
	@RequestMapping(method = RequestMethod.POST)
	public String loadDefault(@RequestParam Map<String,String> requestParams, HttpServletRequest request)
	{
		
		String output = "";
		String name = (String)request.getSession().getAttribute("passengerName"); //get session variable
		char promo = requestParams.get("txtPromo").charAt(0); // get company name input
		OrdinaryPassenger newPassenger = new OrdinaryPassenger(name, promo);
		
		int choice = (int)request.getSession().getAttribute("bookingChoice"); //get session variable
		
		Airline scotia = (Airline)request.getSession().getAttribute("airline"); //get session variable
		
		Flight selectedFlight = (Flight)request.getSession().getAttribute("selectedFlight"); //get session variable
		
		Seat selectedSeat = (Seat)request.getSession().getAttribute("selectedSeat"); //get session variable
		
		int fullSeatStatus = selectedSeat.changeSeatStatus(scotia, choice, newPassenger, selectedFlight);

		selectedFlight.updateSeat(fullSeatStatus);
		selectedFlight.calculateTotalFlightTakings();
		
		
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
