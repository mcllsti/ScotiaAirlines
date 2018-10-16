package scotia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//DARYL MCALLISTER
//Returns the add flight controller JSp
@Controller
@RequestMapping("/addFlight")
public class AddFlightController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadDefault()
	{
		return "addFlight";
	}
	
	

}
