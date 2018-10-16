package scotia.models;

//Subclass of passenger that deals with normal passengers
public class OrdinaryPassenger extends Passenger {
	//DARYL MCALLISTER
	
	public OrdinaryPassenger() //CONSTRUCTOR
	{
		super(1); //CALLS BASE
		currentPromotion = 'n';
	}
	
	public OrdinaryPassenger(String name, char promo) //OVERLOADED CONSTRUCTOR
	{
		super(1);
		passengerName = name;
		currentPromotion = promo;
	}
	
	private char currentPromotion;
	
	public char getCurrentPromotion()
	{
		return currentPromotion;
		
	}
	
	public void setCurrentPromotion(char promo){
		currentPromotion = promo;
	}
	

	//Finds the discount amount a passenger should have
	public void findDiscountAmount()
	{
		if (currentPromotion == 'y')
		{
			discountAmount = 0.95f;
		}
		else
		{
			discountAmount = 1;
		}
	}

}
