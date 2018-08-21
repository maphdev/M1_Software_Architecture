package model;

public class Movie {
	public static final MovieCategory CHILDRENS = new ChildrenCategory();
	public static final MovieCategory REGULAR = new RegularCategory();
	public static final MovieCategory NEW_RELEASE = new NewReleaseCategory();

	private String _title;
	private MovieCategory _priceCode;

	public Movie(String title, MovieCategory priceCode)
	{
		_title = title;
		_priceCode = priceCode;
	}
	
	public MovieCategory getPriceCode()
	{
		return _priceCode;
	}
	
	public void setPriceCode(MovieCategory priceCode)
	{
		_priceCode = priceCode;
	}
	
	public String getTitle()
	{
		return _title;
	}
	
	public double getAmount(int days)
	{
		return getPriceCode().getAmount(days);
	}

	int getRenterPoints(int days)
	{
		int points = 1;
		if(getPriceCode() == Movie.NEW_RELEASE && days > 1)
			points++;
		return points;
	}
}
