package scotia.models;

//Subclass of passenger that deatils with Business Travllers
public class BusinessTraveller extends Passenger  {
	//DARYL MCALLISTER
	
	public BusinessTraveller() //CONSTRUCTOR
	{
		super(0.75f); //CALLS BASE
		companyName = "";
	}
	
	public BusinessTraveller(String name, String compName) //OVERLOADED CONSTRUCTOR
	{
		super(0.75f);
		passengerName = name;
		companyName = compName;
	}

	
	private String companyName;
	
	//GETTER
	public String getCompanyName()
	{
		return companyName;
	}
	
	//SETTER
	public void setCompanyName(String compName)
	{
		companyName = compName;
	}
	

}
