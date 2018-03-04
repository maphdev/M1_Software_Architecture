package model;

public class TxtBuilder implements Builder {
	private StringBuffer _str;
	
	public TxtBuilder() {
		_str = new StringBuffer();
	}
	
	@Override
	public void beginStatement() {
		// TODO Auto-generated method stub
	}

	@Override
	public void addUserName(String name) {
		_str.append("Rental Record for " + name + "\n");
	}

	@Override
	public void addRentalStatement(String title, double price) {
		_str.append("\t" + title+"\t"+ String.valueOf(price) +" \n");
	}

	@Override
	public void addTotalPrice(double price) {
		_str.append("Amount owned is " + String.valueOf(price) +"\n");
	}

	@Override
	public void addTotalFrequentPoints(int frequentPoints) {
		_str.append("You earned " + String.valueOf(frequentPoints) +" frequent renter points");
	}

	@Override
	public void endStatement() {
		// TODO Auto-generated method stub
	}
	
	public String getResults() {
		return _str.toString();
	}

}
