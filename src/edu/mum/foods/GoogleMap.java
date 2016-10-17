package edu.mum.foods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.LongToIntFunction;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class GoogleMap extends Application {
	

	
    private Scene scene;
    @Override public void start(Stage stage) throws ClassNotFoundException, SQLException {
        // create the scene
        stage.setTitle("Food Delivery Map View");
        scene = new Scene(new Browser(),750,500, Color.web("#666970"));
        stage.setScene(scene);
        scene.getStylesheets().add("webviewsample/BrowserToolbar.css");        
        stage.show();
    }
 
    public static void main(String[] args){
        launch(args);
    }
    
    static Stage classStage= new Stage();
}
class Browser extends Region {
	
	private String longitude;
	private String latitude;
 
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
     
    public Browser() throws ClassNotFoundException, SQLException {
    	
		String query = "SELECT * FROM tblDelivery ORDER BY did DESC LIMIT 1";

		try {
			Statement stmt = Connection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				System.out.println(rs.getString("longtitude"));
				System.out.println(rs.getString("latitude"));
				System.out.println(rs.getInt("did"));
				
				longitude = rs.getString("longtitude");
				latitude = rs.getString("latitude");
				
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Connection.getConnection().close();
		}
		
        //apply the styles
        getStyleClass().add("browser");
        // load the web page
        webEngine.load("https://www.google.com/maps/dir/42.046457,+-91.980657/41.046457,-91.980657/@41.5435975,-92.3920327,9z/");
        //add the web view to the scene
        getChildren().add(browser);
 
    }
    private Node createSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }
 
    @Override protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
    }
 
    @Override protected double computePrefWidth(double height) {
        return 750;
    }
 
    @Override protected double computePrefHeight(double width) {
        return 500;
    }
}
