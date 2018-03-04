package model;

public class Movie {
	
	public static final Price CHILDRENS = new DefaultPrice(1.5, 3, 1.5);
	public static final Price REGULAR = new DefaultPrice(2, 2, 1.5);
	public static final Price NEW_RELEASE = new DefaultPrice(0, 0, 3);
  
    private String _title;
    private Price _priceCode;
  
    public Movie(String title, Price priceCode) {
    	_title=title;
    	_priceCode=priceCode;
    }
    
    public Price getPriceCode() {
    	return _priceCode;
    }
    
    public void setPriceCode(Price priceCode) {
	_priceCode=priceCode;
    }
    
    public String getTitle() {
    	return _title;
    }

}
