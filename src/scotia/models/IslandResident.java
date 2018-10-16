package scotia.models;

//Subclass of passeneger that deals with island residents
public class IslandResident extends Passenger  {
	//DARYL MCALLISTER
	
	public IslandResident() //CONSTRUCTOR
	{
		super(0.9f);
		islandOfResidence = "";
	}
	
	public IslandResident(String name, String island) //OVERLOADED CONSTRUCTOR
	{
		super(0.9f);
		passengerName = name;
		islandOfResidence = island;
	}
	
	private String islandOfResidence;
	
	public String getIslandOfResidence()
	{
		return islandOfResidence;
	}
	
	public void setIslandOfResidence(String island)
	{
		islandOfResidence = island;
	}
	


}
