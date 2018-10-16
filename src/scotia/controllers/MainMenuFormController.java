package scotia.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import scotia.models.Airline;
//DARYL MCALLISTER
//Deals with the selection form in the main menu controller
@Controller
@RequestMapping("/mainMenuForm")
public class MainMenuFormController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loadDefault(HttpServletRequest request)
	{
		String textFromButton = request.getParameter("mainMenuChoice"); // gets text from button
		
		
		//if statement that directs the user depending on button chosen
		if(textFromButton.equals("Booking Menu"))
		{
			request.getSession().setAttribute("menuChoice", "Booking");
		}
		else if(textFromButton.equals("Display Seat Details"))
		{
			request.getSession().setAttribute("menuChoice", "DisplaySeats");
		}
		else if(textFromButton.equals("Display Flight Details"))
		{
			request.getSession().setAttribute("menuChoice", "DisplayFlight");
		}
		
		Airline scotia;
		scotia = (Airline)request.getSession().getAttribute("airline");
		return new ModelAndView("selectFlight", "scotia", scotia);
	}
	
	

}
