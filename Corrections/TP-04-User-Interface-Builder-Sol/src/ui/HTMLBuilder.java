package ui;

/**
 * Creates an HTML version of a Customer statement.
 */
public class HTMLBuilder implements model.StatementBuilder {

	String _string;
	
	public HTMLBuilder()
	{
	}

	@Override
	public void beginHeader()
	{
		_string += "<h1>";
	}
	@Override
	public void endHeader()
	{
		_string += "</h1>";
	}

	@Override
	public void beginTable()
	{
		_string += "<table>";		
	}
	
	@Override
	public void endTable()
	{
		_string += "</table>";		
	}

	@Override
	public void beginRow()
	{	
		_string += "<tr>";	
	}
	
	@Override
	public void endRow()
	{
		_string += "</tr>";	
	}

	@Override
	public void beginColumn()
	{
		_string += "<td>";	
	}
	
	@Override
	public void endColumn()
	{	
		_string += "</td>";	
	}

	@Override
	public void beginParagraph()
	{
		_string += "<p>";
	}
	
	@Override
	public void endParagraph()
	{
		_string += "</p>";		
	}

	@Override
	public void addString(String s)
	{
		// TODO we should escape the input string for HTML characters
		_string += s;
	}
	
	@Override
	public void finish()
	{
		_string += "</body></html>";		
	}
	
	@Override
	public void createNewStatement() 
	{	
		_string = "<!doctype html>"
				+ "<html>"
				+ "<head>"
				+ "<title>Statement</title>"
				+ "</head>"
				+ "<body>";
	}
	
	public String getStatement()
	{ 
		return _string;		
	}
}
