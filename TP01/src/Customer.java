package model;
import java.util.*;

public class Customer
{
    private String _name;
    private ArrayList<Rental> _rentals = new ArrayList();
    
    public Customer(String name) {
    	_name=name;
    }
    

	public void addRental(Rental rental) {
    	_rentals.add(rental);
    }
    
    public String getName() {
    	return _name;
    }
    
    public double computeTotalPrice() {
		double totalAmount = 0;
		
    	for (Rental each : _rentals) {
    		totalAmount += each.price();
    	}
    	
    	return totalAmount;
    }
    
    public int computeRenterPoints() {
    	int totalRenterPoints =  0;
    	
    	for (Rental each : _rentals) {
    		totalRenterPoints += each.renterPoints();
    	}
    	
    	return totalRenterPoints;
    }
    
    public String statementString() {
    	TxtBuilder txtBuilder = new TxtBuilder();
    	statement(txtBuilder);
    	return txtBuilder.getResults();
    }
    
    public void statementHTML() {
    	HTMLBuilder html = new HTMLBuilder();
    	statement(html);
    }
     
    public void statement(Builder builder) {
    	builder.beginStatement();
    	builder.addUserName(getName());
    	for (Rental r : _rentals)
    		builder.addRentalStatement(r.getMovie().getTitle(), r.price());
    	builder.addTotalPrice(computeTotalPrice());
    	builder.addTotalFrequentPoints(computeRenterPoints());
    	builder.endStatement();
    }
    
    /*
    public String statementBis() {		
    	StringBuffer str = new StringBuffer();
    	str.append("Rental Record for " + getName() + "\n");
    	for (Rental r : _rentals)
    		str.append("\t" + r.getMovie().getTitle()+"\t"+ String.valueOf(r.price()) +" \n");
    	str.append("Amount owned is " + String.valueOf(computeTotalPrice()) +"\n");
    	str.append("You earned " + String.valueOf(computeRenterPoints()) +" frequent renter points");
    	return str.toString();
    }
    */
    
    /*
    public String statementHTML() {	
    	StringBuffer str = new StringBuffer();
    	str.append("<html><body>");
    	str.append("Rental Record for " + getName() + "\n");
    	for (Rental r : _rentals)
    		str.append("\t" + r.getMovie().getTitle()+"\t"+ String.valueOf(r.price()) +" \n");
    	str.append("Amount owned is " + String.valueOf(computeTotalPrice()) +"\n");
    	str.append("You earned " + String.valueOf(computeRenterPoints()) +" frequent renter points");
    	str.append("</body></html>");
    	return str.toString();
    } */
}
 