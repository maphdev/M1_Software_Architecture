package ui;
import java.lang.StringBuilder;

/**
 * Creates a plain text version of a Customer statement.
 */
public class TextBuilder implements model.StatementBuilder {

	StringBuilder _string = new StringBuilder();
	
	public TextBuilder()
	{
	}

	@Override
	public void beginHeader()
	{
		
	}
	@Override
	public void endHeader()
	{
		_string.append("\n");	
	}

	@Override
	public void beginTable()
	{
		
	}
	
	@Override
	public void endTable()
	{
		
	}

	@Override
	public void beginRow()
	{	
	}
	
	@Override
	public void endRow()
	{
		_string.append("\n");
	}

	@Override
	public void beginColumn()
	{
		_string.append("\t");
	}
	
	@Override
	public void endColumn()
	{	
	}

	@Override
	public void beginParagraph()
	{
		_string.append("\n");
	}
	
	@Override
	public void endParagraph()
	{
		
	}

	@Override
	public void addString(String s)
	{
		_string.append(s);
	}
	
	@Override
	public void finish()
	{
		
	}
	
	@Override
	public void createNewStatement() 
	{	
		_string = new StringBuilder();
	}
	
	public String getStatement()
	{ 
		return _string.toString();	
	}
}
