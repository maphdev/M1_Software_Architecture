package model;

public class ChildrenCategory implements MovieCategory
{
	@Override
	public double getAmount(int days)
	{
		double val = 1.5;
		if(days > 3)
		{
			val += (days - 3) * 1.5;
		}
		return val;		
	}

	@Override
	public int getRenterPoints(int days) {
		return 1;
	}
}