package model;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import junit.framework.Assert;

public class MyTest {
	
	private Customers  louis;
		
	@Before
	public void Before() {
		louis = new Customers("Louis");
		
		Movie movie1 = new Movie("Rogue One", Movie.NEW_RELEASE);
		Movie movie2 = new Movie("Reine des neiges", Movie.CHILDRENS);
		Movie movie3 = new Movie("Star Wars III", Movie.REGULAR);
		
		Rental rental1 = new Rental(movie1, 5);
		Rental rental2 = new Rental(movie2, 7);
		Rental rental3 = new Rental(movie3, 4);
		
		louis.addRental(rental1);
		louis.addRental(rental2);
		louis.addRental(rental3);
	}
	
	@Test
	public void test() {
		final String statement = "Rental Record for Louis\n\tRogue One\t15.0 \n\tReine des neiges\t7.5 \n\tStar Wars III\t5.0 \nAmount owned is 27.5\nYou earned 4 frequent renter points";
		Assert.assertEquals(statement, louis.statementString());
	}
	
	@After
	public void After() {
		
	}

}
