package model;

public interface Builder {
	void beginStatement();
	void addUserName(String name);
	void addRentalStatement(String title, double price);
	void addTotalPrice(double price);
	void addTotalFrequentPoints(int frequentPoints);
	void endStatement();
}
