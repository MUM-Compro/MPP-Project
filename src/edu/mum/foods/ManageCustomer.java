package edu.mum.foods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aquafx_project.AquaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ManageCustomer extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	static Stage mcStage = new Stage();

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub

		primaryStage.setTitle("Welcome to Food Delivery Management System");
		
		GridPane mainGrid = new GridPane();
		GridPane topGrid = new GridPane();
		topGrid.setAlignment(Pos.TOP_CENTER);
		topGrid.setHgap(10);
		
        final Button btnAddCustomer = new Button("Add New Customer");
        btnAddCustomer.setMinSize(210, 150);
        final Button btnRemoveCustomer = new Button("Remove Customer");
        btnRemoveCustomer.setMinSize(210, 150);
        final Button btnUpdateCustomer = new Button("Update Customer Info");
        btnUpdateCustomer.setMinSize(210, 150);
        final Button btnSerachCustomer = new Button("Search Customer");
        btnSerachCustomer.setMinSize(210, 150);
        Label lgap= new Label();
        Label lgap2= new Label();
        
        topGrid.add(lgap2, 0, 1);
        topGrid.add(btnAddCustomer, 0, 2);
        topGrid.add(btnRemoveCustomer, 1, 2);
        topGrid.add(lgap, 0, 3);
        topGrid.add(btnUpdateCustomer, 0, 4);
        topGrid.add(btnSerachCustomer, 1, 4);
        
        
        mainGrid.add(topGrid, 0, 1);
		Scene scene = new Scene(mainGrid, 450, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();
	}

}