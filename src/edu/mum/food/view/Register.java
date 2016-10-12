package edu.mum.food.view;

import com.aquafx_project.AquaFx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Register extends Application {

	public static void main(String[] arg) {
		launch(arg);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("Register New User");
		
		Label lblPageTitle = new Label("New Register");
		lblPageTitle.setAlignment(Pos.CENTER);
		

		// top grid
		GridPane topGrid = new GridPane();
		topGrid.setAlignment(Pos.TOP_CENTER);
		topGrid.setHgap(10);
		
		topGrid.add(lblPageTitle, 0, 0);

		Label lblItemCode = new Label("Firstname");
		TextField txtItemCode = new TextField();
		txtItemCode.setPrefWidth(300);
		topGrid.add(lblItemCode, 0, 1);
		topGrid.add(txtItemCode, 0, 2);

		Label lblPassword = new Label("Lastname");
		TextField txtPassword = new TextField();
		txtItemCode.setPrefWidth(300);
		topGrid.add(lblPassword, 0, 3);
		topGrid.add(txtPassword, 0, 4);

		Label lblSubmit = new Label("");
		Button btnSubmit = new Button("Login");
		topGrid.add(lblSubmit, 0, 10);
		topGrid.add(btnSubmit, 0, 11);

		// add all grid into main grid
		GridPane mainGrid = new GridPane();
		mainGrid.setAlignment(Pos.TOP_CENTER);
		mainGrid.setPadding(new Insets(10, 10, 10, 10));
		mainGrid.add(topGrid, 0, 1);

		Scene scene = new Scene(mainGrid, 750, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();

	}

}
