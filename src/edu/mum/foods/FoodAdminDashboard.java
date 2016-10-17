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

public class FoodAdminDashboard extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	static Stage classStage = new Stage();

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub

		primaryStage.setTitle("Welcome to Food Delivery Management System");
		
		GridPane mainGrid = new GridPane();
		mainGrid.setPadding(new Insets(10, 10, 10, 10));
		GridPane topGrid = new GridPane();
		topGrid.setAlignment(Pos.TOP_CENTER);
		topGrid.setHgap(10);
		
        final Button btnAddFood = new Button("Add Food Item");
        btnAddFood.setMinSize(210, 150);
        final Button btnRemoveFood = new Button("Remove Food Item");
        btnRemoveFood.setMinSize(210, 150);
        final Button btnUpdateFood = new Button("Update Info of Food Item");
        btnUpdateFood.setMinSize(210, 150);
        final Button btnSerachFood = new Button("Search Food Item");
        btnSerachFood.setMinSize(210, 150);
        Label lgap= new Label();
        Label lgap2= new Label();
        
        topGrid.add(lgap2, 0, 1);
        topGrid.add(btnAddFood, 0, 2);
        topGrid.add(btnRemoveFood, 1, 2);
        topGrid.add(lgap, 0, 3);
        topGrid.add(btnUpdateFood, 0, 4);
        topGrid.add(btnSerachFood, 1, 4);
        
        topGrid.add(new Label(""), 0, 6);
		Button btnBack = new Button("Back");
		topGrid.add(btnBack, 0, 23);
        
        
        mainGrid.add(topGrid, 0, 1);
		Scene scene = new Scene(mainGrid, 450, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();
		
		
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				AdminDashboard lreg = new AdminDashboard();

				try {
					lreg.start(AdminDashboard.classStage);
				} catch (Exception e) {

				}
			}
		});
		btnAddFood.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				AddFoodItem lreg = new AddFoodItem();

				try {
					lreg.start(AddFoodItem.classStage);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnRemoveFood.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				RemoveFood lreg = new RemoveFood();

				try {
					lreg.start(RemoveFood.classStage);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		btnUpdateFood.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				UpdateFoodDetail lreg = new UpdateFoodDetail();

				try {
					lreg.start(UpdateFoodDetail.classStage);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnSerachFood.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				SearchFood lreg = new SearchFood();

				try {
					lreg.start(SearchFood.classStage);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

}