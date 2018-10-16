package scotia.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import scotia.models.Airline;
//DARYL MCALLISTER
//gets the select flight jsp for the user
@Controller
@RequestMapping("/selectFlight")
public class SelectFlightController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadDefault(HttpServletRequest request)
	{
		Airline scotia;
		scotia = (Airline)request.getSession().getAttribute("airline");
		return new ModelAndView("selectFlight", "scotia", scotia); // passe sin airline 
	}
	
	

}
