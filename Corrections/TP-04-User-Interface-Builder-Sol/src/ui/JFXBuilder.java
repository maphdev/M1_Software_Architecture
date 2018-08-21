package ui;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Creates a JavaFX version of a Customer statement.
 * 
 * This puts all the UI elements in a single grid.
 */
public class JFXBuilder implements model.StatementBuilder {

	static final Font title = Font.font("Arial", FontWeight.BOLD, 14);
	static final Font bold = Font.font("Arial", FontWeight.BOLD, 12);
	static final Font normal = Font.font("Arial", FontWeight.NORMAL, 12);
	
	GridPane _grid;
    int _currentLine = 0;
    int _currentCol = 0;
    String _currentString;
    
	public JFXBuilder()
	{
	}	

	@Override
	public void beginHeader()
	{
		_currentString = new String();
	}
	
	@Override
	public void endHeader()
	{
		Text header = new Text(_currentString);
		header.setFont(title);
		
	    _grid.add(header, 0, _currentLine);	    
		_currentLine ++;
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
		_currentCol = 0;		
	}
	
	@Override
	public void endRow()
	{
		_currentLine++;
	}

	@Override
	public void beginColumn()
	{
		_currentString = new String();
	}
	
	@Override
	public void endColumn()
	{		
		Text txt = new Text(_currentString);
		txt.setFont(bold);
        _grid.add(txt, _currentCol, _currentLine);
        _currentCol++;
	}

	@Override
	public void beginParagraph()
	{
		_currentString = new String();
	}
	
	@Override
	public void endParagraph()
	{
		Text txt = new Text(_currentString);
		txt.setFont(normal);
        _grid.add(txt, 0, _currentLine);
		_currentLine++;		
	}

	@Override
	public void addString(String s)
	{
		_currentString += s;
	}
	
	@Override
	public void finish()
	{
		
	}	
	
	@Override
	public void createNewStatement() 
	{		
		_grid = new GridPane();
		_grid.setHgap(10);
		_grid.setVgap(10);
		_grid.setPadding(new Insets(0, 10, 0, 10));
		_currentLine = 0;
		_currentCol = 0;
	}

	public GridPane getStatement()
	{
		return _grid;
	}
}
