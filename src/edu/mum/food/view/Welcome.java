package edu.mum.food.view;

import java.io.File;

import com.aquafx_project.AquaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Welcome extends Application {

	public static void main(String[] arg) {
		launch(arg);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("Welcome to Food Delivery Management System");

		// title grid
		GridPane titleGrid = new GridPane();
		titleGrid.setAlignment(Pos.CENTER);
		titleGrid.setHgap(10);

		// top grid
		GridPane topGrid = new GridPane();
		topGrid.setAlignment(Pos.CENTER);
		topGrid.setHgap(10);

		Label lblItemCode = new Label("Username");
		TextField txtItemCode = new TextField();
		txtItemCode.setPrefWidth(300);
		topGrid.add(lblItemCode, 0, 0);
		topGrid.add(txtItemCode, 0, 1);
		
		Label lblPassword = new Label("Password");
		TextField txtPassword = new TextField();
		txtItemCode.setPrefWidth(300);
		topGrid.add(lblPassword, 0, 2);
		topGrid.add(txtPassword, 0, 3);


		Label lblSubmit = new Label("");
		Button btnSubmit = new Button("Login");
		topGrid.add(lblSubmit, 0, 10);
		topGrid.add(btnSubmit, 0, 11);

		// add all grid into main grid
		GridPane mainGrid = new GridPane();
		mainGrid.setAlignment(Pos.CENTER);
		mainGrid.setPadding(new Insets(10, 10, 10, 10));
		mainGrid.add(topGrid, 0, 1);

		Scene scene = new Scene(mainGrid, 750, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();

	}

}
