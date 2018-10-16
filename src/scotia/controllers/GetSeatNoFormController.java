package scotia.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import scotia.models.Airline;
import scotia.models.Flight;
import scotia.models.Seat;
//DARYL MCALLISTER
//deals with the from in hte get seat number jsp
@Controller
@RequestMapping("/getSeatNoForm")
public class GetSeatNoFormController {
	
	@RequestMapping(method = RequestMethod.POST)
	public String loadDefault(@RequestParam Map<String,String> requestParams, HttpServletRequest request)
	{
		
		Airline scotia = (Airline)request.getSession().getAttribute("airline"); //get session variable
		Flight selectedFlight = (Flight)request.getSession().getAttribute("selectedFlight"); //get session variable
		Seat selectedSeat = scotia.getSeat(selectedFlight.getFlightNumber(), requestParams.get("txtSeatNo")); //get session variable
		String output;
		
		if((request.getSession().getAttribute("menuChoice")).equals("DisplaySeats"))
		{
			String seatDetails = selectedSeat.displaySeatDetails(); // gets seat details
			request.getSession().setAttribute("message", seatDetails); //sets the message variable into a session variable 
			
			return "genericOutput";
		}
		if((request.getSession().getAttribute("menuChoice")).equals("Cancel"))
		{
			
			if(selectedSeat.getCurrentStatus() == 1)
			{
				output = "Error: seat has no bookings or reservationst o cancel";
			}
			else
			{
				if(selectedSeat.getCurrentStatus() == 2)
				{
					selectedSeat.ResetDetails();
					selectedFlight.updateSeat(1);
				}
				else if (selectedSeat.getCurrentStatus() == 3)
				{
					selectedSeat.ResetDetails();
					selectedFlight.updateSeat(2);
				}

				output = "Seat " + selectedSeat.getSeatNumber() + " has been canceled";
			}
			request.getSession().setAttribute("message", output); //sets the message variable into a session variable 
			
			return "genericOutput";
		}
		else if(request.getSession().getAttribute("menuChoice").equals("Reserve"))
		{
			request.getSession().setAttribute("selectedSeat", selectedSeat);
			request.getSession().setAttribute("bookingChoice", 2);
			return "getPassengerName";
		}
		else if(request.getSession().getAttribute("menuChoice").equals("Book"))
		{
			request.getSession().setAttribute("selectedSeat", selectedSeat);
			request.getSession().setAttribute("bookingChoice", 3);
			return "getPassengerName";
		}
		else
		{
			return "genericOutput";
		}

	}
	
	

}