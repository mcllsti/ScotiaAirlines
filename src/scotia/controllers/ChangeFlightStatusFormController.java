package scotia.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import scotia.models.Airline;
import scotia.models.Flight;
//DARYL MCALLISTER
//Deals with the form on the change flight status jsp
@Controller
@RequestMapping("/changeFlightStatusForm")
public class ChangeFlightStatusFormController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loadDefault(HttpServletRequest request)
	{
		String textFromButton = request.getParameter("changeFlightStatusChoice"); //gets text from button
		
		if(textFromButton.equals("Return to Flight Selection"))
		{
			request.getSession().setAttribute("menuChoice", "ChangeFlightStatus"); //sets session variavke
			Airline scotia = (Airline) request.getSession().getAttribute("airline");
			return new ModelAndView("selectFlight", "scotia", scotia);
		}
		else if(textFromButton.equals("Seats Available"))
		{
			Flight selectedFlight = (Flight) request.getSession().getAttribute("selectedFlight");
			selectedFlight.setFlightStatus(4);
			request.getSession().setAttribute("selectedFlight", selectedFlight);
			String output = "Flight " + selectedFlight.getFlightNumber() + " now has seats available";
			request.getSession().setAttribute("message", output);
			return new ModelAndView ("genericOutput", "message", output);
			
		}
		else if(textFromButton.equals("Checking In"))
		{
			Flight selectedFlight = (Flight) request.getSession().getAttribute("selectedFlight");
			selectedFlight.setFlightStatus(1);
			request.getSession().setAttribute("selectedFlight", selectedFlight);
			String output = "Flight " + selectedFlight.getFlightNumber() + " now checking in";
			request.getSession().setAttribute("message", output);
			return new ModelAndView ("genericOutput", "message", output);
		}
		else if(textFromButton.equals("Boarding"))
		{
			Flight selectedFlight = (Flight) request.getSession().getAttribute("selectedFlight");
			selectedFlight.setFlightStatus(2);
			request.getSession().setAttribute("selectedFlight", selectedFlight);
			String output = "Flight " + selectedFlight.getFlightNumber() + " now boarding";
			request.getSession().setAttribute("message", output);
			return new ModelAndView ("genericOutput", "message", output);
		}
		else 
		{
			Flight selectedFlight = (Flight) request.getSession().getAttribute("selectedFlight");
			selectedFlight.setFlightStatus(3);
			request.getSession().setAttribute("selectedFlight", selectedFlight);
			String output = "Flight " + selectedFlight.getFlightNumber() + " now closed";
			request.getSession().setAttribute("message", output);
			return new ModelAndView ("genericOutput", "message", output);
		}
		
		//Airline scotia;
		//scotia = (Airline)request.getSession().getAttribute("airline");
		//return new ModelAndView("selectFlight", "scotia", scotia);
	}
	
	

}
