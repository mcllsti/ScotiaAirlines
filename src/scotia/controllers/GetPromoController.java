package scotia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//DARYL MCALLISTER
//gets the getpromo jsp 

@Controller
@RequestMapping("/getPromo")
public class GetPromoController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadDefault()
	{
		return "getPromo";
	}
	
	

}

