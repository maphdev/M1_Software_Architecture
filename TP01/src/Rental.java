package model;

public class Rental {
	
    private Movie _movie;
    private int _daysRented;
    private Price _pricing;
    
    public Rental(Movie movie, int daysRented) {
    	_movie=movie;
    	_daysRented=daysRented;
    	_pricing = movie.getPriceCode().clone();
    }
    
    public int getDaysRented() {
    	return _daysRented; 
    }
    
    public Movie getMovie() {
    	return _movie;
    }
    
    public double price() {
    	return _pricing.getPrice(_daysRented);
    }
    
    public int renterPoints() {
    	if (_movie.getPriceCode() == Movie.NEW_RELEASE) 
    		return 2;
    	return 1;
    }
}
