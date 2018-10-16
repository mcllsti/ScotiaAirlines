package scotia.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import scotia.models.Airline;
import scotia.models.Flight;
import scotia.models.Seat;
//DARYL MCALLISTER
//Deals with the form in the get passenger name jsp
@Controller
@RequestMapping("/getPassengerNameForm")
public class GetPassengerNameFormController {
	
	@RequestMapping(method = RequestMethod.POST)
	public String loadDefault(@RequestParam Map<String,String> requestParams, HttpServletRequest request)
	{
		
		String name = requestParams.get("txtPassengerName"); // gets the input
		request.getSession().setAttribute("passengerName", name);
		String textFromButton = request.getParameter("passengerTypeChoice");
		
		//if statement to deterime where to send user next depending on type
		if(textFromButton.equals("Ordinary Passenger"))
		{
			return "getPromo";
		}
		else if(textFromButton.equals("Island Resident"))
		{
			return "getIslandName";
		}
		else
		{
			return "getCompanyName";
		}

	}
	
	

}
