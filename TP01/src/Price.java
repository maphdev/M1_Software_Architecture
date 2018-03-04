package model;

public interface Price extends Cloneable {
	double getPrice(int days);
	Price clone();
}
