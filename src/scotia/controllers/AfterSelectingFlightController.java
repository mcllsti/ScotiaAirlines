package scotia.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import scotia.models.Airline;
import scotia.models.Flight;
//DARYL MCALLISTER
//Deals with the action after a flight has been selected by the user on the selectFlight JSP
@Controller
@RequestMapping("/afterSelectingFlight")
public class AfterSelectingFlightController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loadDefault(HttpServletRequest request)
	{
		String textFromButton = request.getParameter("selectedFlight"); //Gets text from button
		int firstSpace = textFromButton.indexOf(" ");
		String textFromButtonMinusFirstPart = textFromButton.substring(firstSpace+1); //creates a sub string 
		
		int secondSpace = textFromButtonMinusFirstPart.indexOf(" ");
		String id = textFromButtonMinusFirstPart.substring(0, secondSpace); //creates ID from the substrings
		
		Airline scotia = (Airline)request.getSession().getAttribute("airline"); //gets session variable
		Flight selectedFlight = scotia.getFlights().get(id); //gets flight using ID
		request.getSession().setAttribute("selectedFlight", selectedFlight);
		
		if(request.getSession().getAttribute("menuChoice").equals("Booking")) //If hte user chose bookings
		{
			return new ModelAndView("bookingMenu","selectedFlight",selectedFlight);
		}
		else if(request.getSession().getAttribute("menuChoice").equals("ChangeFlightStatus")) //if the user chose chagne flight status
		{
			return new ModelAndView("changeFlightStatus","selectedFlight",selectedFlight); 
		}
		else if(request.getSession().getAttribute("menuChoice").equals("DisplayFlight")) // if hte user chose display flight
		{
			String message = selectedFlight.displayFlightInfo();
			request.getSession().setAttribute("message", message);
			return new ModelAndView("genericOutput","message",message);

		}
		else if(request.getSession().getAttribute("menuChoice").equals("DisplaySeats"))
		{
			String[] output = new String[3];
			output[0] = "Enter Seat No to View";
			output[1] = "Submit";
			output[2] = "Return to Main Menu";
			return new ModelAndView("getSeatNo","output",output);
		}
		else
		{
			return null;
		}
			
	}
	
	

}
