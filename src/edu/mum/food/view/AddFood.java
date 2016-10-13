package edu.mum.food.view;

import java.sql.SQLException;

import com.aquafx_project.AquaFx;

import edu.mum.food.model.RegisterModel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddFood extends Application{
	
	public static void main(String[] arg) {
		launch(arg);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("Add Food");

		Label lblPageTitle = new Label("Add Food");
		Label blankSpace = new Label("");
		lblPageTitle.setAlignment(Pos.CENTER);

		// top grid
		GridPane topGrid = new GridPane();
		topGrid.setAlignment(Pos.TOP_CENTER);
		topGrid.setHgap(10);

		topGrid.add(lblPageTitle, 0, 0);
		topGrid.add(blankSpace, 0, 1);

		Label lblFirstname = new Label("Food Name");
		TextField txtFirstname = new TextField();
		txtFirstname.setPrefWidth(300);

		topGrid.add(lblFirstname, 0, 2);
		topGrid.add(txtFirstname, 0, 3);

		Label lblLastname = new Label("Category");
		TextField txtLastname = new TextField();
		txtLastname.setPrefWidth(300);
		topGrid.add(lblLastname, 0, 4);
		topGrid.add(txtLastname, 0, 5);

		Label lblEmail = new Label("Description");
		TextArea txtEmail = new TextArea();
		txtEmail.setPrefWidth(300);
		topGrid.add(lblEmail, 0, 6);
		topGrid.add(txtEmail, 0, 7);

		Label lblPrice = new Label("Price");
		TextField txtPassword = new TextField();
		txtPassword.setPrefWidth(300);
		topGrid.add(lblPrice, 0, 8);
		topGrid.add(txtPassword, 0, 9);

		Label lblSubmit = new Label("");
		Button btnSubmit = new Button("Register");
		topGrid.add(lblSubmit, 0, 20);
		topGrid.add(btnSubmit, 0, 21);

		// add all grid into main grid
		GridPane mainGrid = new GridPane();
		mainGrid.setAlignment(Pos.TOP_CENTER);
		mainGrid.setPadding(new Insets(10, 10, 10, 10));
		mainGrid.add(topGrid, 0, 1);

		Scene scene = new Scene(mainGrid, 650, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();

		btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {



			}
		});

	}

}
