package scotia.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import scotia.models.Airline;
//DARYL MCALLISTER
//handles the admin options jsp's form 
@Controller
@RequestMapping("/adminOptionsForm")
public class AdminOptionsFormController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loadDefault(HttpServletRequest request)
	{
		String textFromButton = request.getParameter("adminOptionsChoice"); //gets text from button
		
		if(textFromButton.equals("Change Flight Status"))
		{
			request.getSession().setAttribute("menuChoice", "ChangeFlightStatus"); //sets session variable
		}
		
		Airline scotia;
		scotia = (Airline)request.getSession().getAttribute("airline");
		return new ModelAndView("selectFlight", "scotia", scotia); //returns select flight jsp and passes in the session vairable
	}
	
	

}
