package edu.mum.foods;

import java.sql.SQLException;

import com.aquafx_project.AquaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class AdminDashboard extends Application {

	public static void main(String[] arg) {
		launch(arg);
	}

	static Stage classStage = new Stage();

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		AdminDashboard.classStage = primaryStage;

		primaryStage.setTitle("Admin");

		Label lblPageTitle = new Label("Admin Dashboard");
		Label blankSpace = new Label("");
		lblPageTitle.setAlignment(Pos.CENTER);

		// top grid
		GridPane topGrid = new GridPane();
		topGrid.setAlignment(Pos.TOP_CENTER);
		topGrid.setHgap(10);

		topGrid.add(lblPageTitle, 0, 0);
		topGrid.add(blankSpace, 0, 1);

		Button btnItem = new Button("Item Details");
		topGrid.add(btnItem, 0, 2);
		
		topGrid.add(new Label(""), 0, 3);
		
		Button btnReport = new Button("View Report");
		topGrid.add(btnReport, 0, 4);

		// add all grid into main grid
		GridPane mainGrid = new GridPane();
		mainGrid.setAlignment(Pos.TOP_CENTER);
		mainGrid.setPadding(new Insets(10, 10, 10, 10));
		mainGrid.add(topGrid, 0, 1);

		Scene scene = new Scene(mainGrid, 450, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();

		btnItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				try {
					
				} catch (Exception e) {
					
				}
			}
		});
		
		btnReport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				try {
					
				} catch (Exception e) {
					
				}
			}
		});




	}

}
