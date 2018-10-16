package scotia.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//DARYL MCALLISTER
//Generic output jsp that will be used to display various outputs and messages
@Controller
@RequestMapping("/genericOutput")
public class GenericOutputController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loadDefault(HttpServletRequest request)
	{
		String message;
		message = request.getSession().getAttribute("message").toString(); // gets the message session variable
		return new ModelAndView("genericOutput","message",message); // returns the view with message model
	}
	
	

}
