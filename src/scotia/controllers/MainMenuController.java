package scotia.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import scotia.models.Airline;
//DARYL MCALLISTER
//gets the main menu jsp
@Controller
@RequestMapping("/mainMenu")
public class MainMenuController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadDefault(HttpServletRequest request)
	{
		if(request.getSession().getAttribute("airline") == null)
		{
			Airline scotia = new Airline(); // makes a new airline variable
			scotia.loadFlightsFromDB();
			scotia.loadSeatsFromDB();
			scotia.loadPassengersFromDB();
			request.getSession().setAttribute("airline", scotia); // sets airline into a session variable
		}
		return "mainMenu";
	}
	
	

}
