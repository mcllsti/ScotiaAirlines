package scotia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//DARYL MCALLISTER
//gets the get passenger name jsp
@Controller
@RequestMapping("/getPassengerName")
public class GetPassengerNameController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadDefault()
	{
		return "getPassengerName";
	}
	
	

}

