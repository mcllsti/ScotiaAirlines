package scotia.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import scotia.models.Airline;
import scotia.models.Flight;
//DARYL MCALLISTER
@Controller
@RequestMapping("/bookingMenuForm")
public class BookingMenuFormController {
	
	String[] output = new String[3];
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loadDefault(HttpServletRequest request)
	{
		String textFromButton = request.getParameter("bookingMenuChoice");
		
		if(textFromButton.equals("Cancel A Reservation/Booking"))
		{
			
			Flight selectedFlight = (Flight) request.getSession().getAttribute("selectedFlight");
			//String flightId = selectedFlight.getFlightNumber();
			
			if(selectedFlight.getBoarding() || selectedFlight.getClosed())
			{
				String output = "Cancelations not available. Flight is " + selectedFlight.getFlightStatus();
				request.getSession().setAttribute("message", output);
				return new ModelAndView("genericOutput","message",output);
			}
			else{
				request.getSession().setAttribute("menuChoice", "Cancel");
				setOutputs(request);
				return new ModelAndView("getSeatNo","output",output);
			}

		}
		else if(textFromButton.equals("Reserve A Seat"))
		{
			Flight selectedFlight = (Flight) request.getSession().getAttribute("selectedFlight");
			
			if(selectedFlight.getBoarding() || selectedFlight.getClosed() || selectedFlight.getIsFull() || selectedFlight.getCheckingIn())
			{
				String output = "Reservations are not available. Flight " + selectedFlight.getFlightNumber() + " is " + selectedFlight.getFlightStatus();
				request.getSession().setAttribute("message", output);
				return new ModelAndView("genericOutput","message",output);
			}
			else
			{
				request.getSession().setAttribute("menuChoice", "Reserve");
				setOutputs(request);
				return new ModelAndView("getSeatNo","output",output);
			}
			

		}
		else if(textFromButton.equals("Book A Seat"))
		{
			Flight selectedFlight = (Flight) request.getSession().getAttribute("selectedFlight");
			
			if(selectedFlight.getBoarding() || selectedFlight.getClosed() || selectedFlight.getIsFull())
			{
				String output = "Bookings are not available. Flight " + selectedFlight.getFlightNumber() + " is " + selectedFlight.getFlightStatus();
				request.getSession().setAttribute("message", output);
				return new ModelAndView("genericOutput","message",output);
			}
			else
			{
				request.getSession().setAttribute("menuChoice", "Book");
				setOutputs(request);
				return new ModelAndView("getSeatNo","output",output);
			}}	
		else
		{
			return null;
		}
		
	}
	
	public void setOutputs(HttpServletRequest request)
	{
		if(request.getSession().getAttribute("menuChoice").equals("DisplaySeats"))
		{
			output[0] = "Enter Seat No to View";
		}
		else if(request.getSession().getAttribute("menuChoice").equals("Cancel"))
		{
			output[0] = "Enter Seat No to Cancel";
		}
		else if(request.getSession().getAttribute("menuChoice").equals("Reserve"))
		{
			output[0] = "Enter Seat No to Reserve";
		}
		else if(request.getSession().getAttribute("menuChoice").equals("Book"))
		{
			output[0] = "Enter Seat No to Book";
		}
		
		
		if(request.getSession().getAttribute("menuChoice").equals("DisplaySeats"))
		{
			output[1] = "Submit";
		}
		else if(request.getSession().getAttribute("menuChoice").equals("Cancel"))
		{
			output[1] = "Submit Cancellation";
		}
		else if(request.getSession().getAttribute("menuChoice").equals("Reserve"))
		{
			output[1] = "Submit Reservation";
		}
		else if(request.getSession().getAttribute("menuChoice").equals("Book"))
		{
			output[1] = "Submit Booking";
		}
		
		
		if(request.getSession().getAttribute("menuChoice").equals("DisplaySeats"))
		{
			output[2] = "Return to Main Menu";
		}
		else
		{
			output[2] = "Return To Booking Menu";
		}
		
	}
	
	
	

}
