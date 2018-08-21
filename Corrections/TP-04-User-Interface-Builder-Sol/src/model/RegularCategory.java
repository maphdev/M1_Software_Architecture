package model;

public class RegularCategory implements MovieCategory
{
	@Override
	public double getAmount(int days)
	{
		double val = 2;
		if (days > 2)
		{
			val += (days - 2) * 1.5;
		}
		return val;		
	}

	@Override
	public int getRenterPoints(int days) {
		return 1;
	}
}