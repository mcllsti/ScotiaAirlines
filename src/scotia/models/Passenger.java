package scotia.models;

//Base class of passengers that is abstract as no instance of it will be created
public abstract class Passenger {
	//DARYL MCALLISTER
	public Passenger() //CONSTRUCTOR
	{
		discountAmount = 1;
		passengerName = "";
	}
	
	public Passenger(float amount) //OVERLOADED CONSTRUCTOR
	{
		discountAmount = amount;
		passengerName = "";
	}
	
	protected float discountAmount;
	protected String passengerName;
	
	public float getDiscountAmount()
	{
		return discountAmount;
		
	}
	
	public String getPassengerName()
	{
		return passengerName;
	}
	
	
	public void setDiscountAmount(float amount){
		discountAmount = amount;
	}
	
	public void setPassengerName(String name){
		passengerName = name;
	}
	


}
