package edu.gatech.TeamDarksideOfTheEspresso.Record;


public class Vaccine
{
	private String	Info;
	private String	Price;
	
	public Vaccine(String Info, String Price){
		this.Info = Info;
		this.Price = Price;
	}
	
	public Vaccine(){
		this("","");
	}
		
	public String getInfo()
	{
		return Info;
	}
	
	
	public String getPrice()
	{
		return Price;
	}
	
	
	public void setInfo(String Info)
	{
		this.Info = Info;
	}
	
	
	public void setPrice(String Price)
	{
		this.Price = Price;
	}
}
