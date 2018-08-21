package model;

public class NewReleaseCategory implements MovieCategory
{
	@Override
	public double getAmount(int days)
	{
		return days * 3;	
	}
	
	@Override
	public int getRenterPoints(int days) {
		return 1;
	}
}