package model;

/**
 * Used to create a visual representation of a statement.
 */
public interface StatementBuilder {
	void createNewStatement();
	
	void beginHeader();
	void endHeader();
	
	void beginTable();
	void endTable();
	
	void beginRow();
	void endRow();
	
	void beginColumn();
	void endColumn();
	
	void beginParagraph();
	void endParagraph();

	void addString(String s);
	
	void finish();
}
