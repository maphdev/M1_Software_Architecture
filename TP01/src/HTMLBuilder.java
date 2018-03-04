package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HTMLBuilder implements Builder {

	private StringBuffer _str;
	
	public HTMLBuilder() {
		_str = new StringBuffer();
	}
	
	@Override
	public void beginStatement() {
		_str.append("<!DOCTYPE html>\n<html>\n<head>\n\t<title>")
		.append("Rental record")
		.append("</title>\n</head>\n<body>\n");
	}

	@Override
	public void addUserName(String name) {
		_str.append("Rental Record for " + name + "<br/>\n");
	}

	@Override
	public void addRentalStatement(String title, double price) {
		_str.append("&nbsp&nbsp&nbsp&nbsp&nbsp" + title+"&nbsp&nbsp&nbsp&nbsp&nbsp"+ String.valueOf(price) +"<br/>\n");
	}

	@Override
	public void addTotalPrice(double price) {
		_str.append("Amount owned is " + String.valueOf(price) +"<br/>\n");
	}

	@Override
	public void addTotalFrequentPoints(int frequentPoints) {
		_str.append("You earned " + String.valueOf(frequentPoints) +" frequent renter points");
	}

	@Override
	public void endStatement() {
		_str.append("</body>\n</html>");
		
		FileOutputStream file;
		try {
			file = new FileOutputStream("record.html");
			file.write(_str.toString().getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getResults() {
		return _str.toString();
	}

}
