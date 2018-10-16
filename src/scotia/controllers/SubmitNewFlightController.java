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
//DARYL MCALLISTER
//deals with the submittin gof a new flight
@Controller
@RequestMapping("/submitNewFlight")
public class SubmitNewFlightController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView createPerson(@RequestParam Map<String,String> requestParams, HttpServletRequest request)
	{
		String message;
		try
		{
			//takes in all the deatils into string variables
			Airline scotia = (Airline)request.getSession().getAttribute("airline");
			String flightID = requestParams.get("txtFlightID");
			String departure = requestParams.get("txtDeparture");
			String arrival = requestParams.get("txtArrival");
			String stringRows = requestParams.get("txtRows");
			String stringColumns = requestParams.get("txtColumns");
			
			int rows = Integer.parseInt(stringRows); //turns it to a int
			int columns = Integer.parseInt(stringColumns);
		
			Flight newFlight = new Flight(columns,rows); // creates a new flight
			newFlight.setFlightDetails(flightID, departure, arrival); //sets the details
			
			scotia.addFlight(newFlight); // adds flight to airline variable
			
			scotia.clearFlightsFromDB();
			scotia.saveFlightsToDB(); // saves it
			
			request.getSession().setAttribute("airline", scotia);
				
			message = "Flight No: " + flightID + " added to Flights";
		}
		catch(Exception ex)
		{
			message = "Problem Registering New Flight";
		}
		
		return new ModelAndView("addFlight", "message", message);
	}

}
