package scotia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//DARYL MCALLISTER
//returns the get island name jsp
	@Controller
	@RequestMapping("/getIslandName")
	public class GetIslandNameController {
		
		@RequestMapping(method = RequestMethod.GET)
		public String loadDefault()
		{
			return "getIslandName";
		}
		
		

	}
