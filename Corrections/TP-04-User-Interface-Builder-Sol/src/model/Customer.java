package model;
import java.util.*;

public class Customer
{
	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();
	
	public Customer(String name)
	{
		_name=name;
	}
	
	public void addRental(Rental rental)
	{
		_rentals.addElement(rental);
	}
	
	public String getName()
	{
		return _name;
	}
	
	public Vector<Rental> getRentals() 
	{
		return _rentals;
	}	
	
	double getTotalAmount() 
	{
		double res = 0;
		for(Rental each : _rentals)
		{
			res += each.getMovie().getAmount(each.getDaysRented());
		}
		return res;
	}
	
	int getRenterPoints()
	{
		int res = 0;
		for(Rental each : _rentals)
		{
			res += each.getMovie().getRenterPoints(each.getDaysRented());
		}
		return res;
	}

	public void buildStatement(StatementBuilder bld)
	{
		bld.createNewStatement();
		
		bld.beginHeader();
		bld.addString("Rental Record for " + getName());
		bld.endHeader();
		
		bld.beginTable();
		for(Rental each : getRentals())
		{
			Movie mov = each.getMovie();
			bld.beginRow();
			 bld.beginColumn();
			  bld.addString(mov.getTitle());
			 bld.endColumn();
			 bld.beginColumn();
			  bld.addString(String.valueOf(mov.getAmount(each.getDaysRented())) );
			 bld.endColumn();
			bld.endRow();
		}
		bld.endTable();
		
		bld.beginParagraph();
		bld.addString("Amount owed is : " + String.valueOf(getTotalAmount()));
		bld.endParagraph();
		
		bld.beginParagraph();
		bld.addString("You earned : " + String.valueOf(getRenterPoints()) + " frequent renter points.");
		bld.endParagraph();
		
		bld.finish();
	}
}
