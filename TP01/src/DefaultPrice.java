package model;

public class DefaultPrice implements Price {
	
	private double _fee;
	private int _bundleDays;
	private double _extraFee;
	
	public DefaultPrice(double fee, int bundleDays, double extraFee) {
		_fee = fee;
		_bundleDays = bundleDays;
		_extraFee = extraFee;
	}
	
	public double getPrice(int days) {
		double totalAmount = _fee;
		if (days > _bundleDays) {
			totalAmount += (days - _bundleDays) * _extraFee;
		}
		return totalAmount;
	}
	
	public Price clone() {
		Price price = null;
		try {
			price = (Price) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return price;
	}
}
