package scotia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//DARYL MCALLISTER
//Returns the get comapny name jsp
@Controller
@RequestMapping("/getCompanyName")
public class GetCompanyNameController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadDefault()
	{
		return "getCompanyName";
	}
	
	

}

