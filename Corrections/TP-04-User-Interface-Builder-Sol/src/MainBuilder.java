
import ui.*;
import model.*;

import javafx.application.Application;
import javafx.scene.web.WebView;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;

public class MainBuilder extends Application {

	public MainBuilder() {}
	
	@Override 
	public void init() {
	}
	
	@Override
	public void start(Stage primaryStage) 
	{
		/// Rent some movies ///
		Movie m1 = new Movie("La Reine des Neiges", Movie.CHILDRENS);
		Movie m2 = new Movie("Kung-Fury 3", Movie.NEW_RELEASE);
		
		Customer c1 = new Customer("Paul");

		c1.addRental(new Rental(m1, 3));
		c1.addRental(new Rental(m2, 5)); 

		/// Statement building ///
		// Build the plain text statement
		TextBuilder txt = new TextBuilder();
        c1.buildStatement(txt);

		// Build the HTML statement
		HTMLBuilder html = new HTMLBuilder();
        c1.buildStatement(html);

		// Build the JavaFX statement
		JFXBuilder jfx = new JFXBuilder();
        c1.buildStatement(jfx);
	

        /// Statement display ///        
        // We will show all our statements in a JavaFX grid : 
		GridPane root = new GridPane();
				
        // Display the text statement
        root.add(new Text("Plain text"), 0, 0);
        root.add(new Text(txt.getStatement()), 0, 1);
        
        // Also put it on the console : 
        System.out.println(txt.getStatement());
        
        
        // Display the HTML statement in a small webview
		root.add(new Text("HTML"), 1, 0);
	    WebView webView = new WebView();
		webView.getEngine().loadContent(html.getStatement());
		webView.setVisible(true);
		webView.setMaxWidth(400);
		webView.setMaxHeight(400);
		root.add(webView, 1, 1);
		
        // Also put it on the console : 
        System.out.println(html.getStatement());
        
		
		// Display the JavaFX statement
		root.add(new Text("JavaFX"), 2, 0);
		root.add(jfx.getStatement(), 2, 1);
		
		
		/// JavaFX window set-up ///
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(new Scene(root, 0, 0));
		primaryStage.setMinHeight(500);
		primaryStage.setMinWidth(1000);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}