package edu.mum.foods;

import edu.mum.*;

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
	
	Register r= new Register();

	static String pass = "im password";
	static String uname = "im username";

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
		titleGrid.setAlignment(Pos.CENTER);
		titleGrid.setHgap(10);

		Label lblEmail = new Label("Email");
		TextField txtEmail = new TextField();
		txtEmail.setPrefWidth(300);
		titleGrid.add(lblEmail, 0, 0);
		titleGrid.add(txtEmail, 0, 1);

		Label lblPassword = new Label("Password");
		TextField txtPassword = new TextField();
		txtPassword.setPrefWidth(300);
		titleGrid.add(lblPassword, 0, 2);
		titleGrid.add(txtPassword, 0, 3);

		Label lblSubmit = new Label("");
		Button btnSubmit = new Button("Login");
		titleGrid.add(lblSubmit, 0, 10);
		titleGrid.add(btnSubmit, 0, 11);

		Label lblRegister = new Label("");
		Button btnRegister = new Button("Register");
		titleGrid.add(lblRegister, 1, 10);
		titleGrid.add(btnRegister, 1, 11);

		// add all grid into main grid
		titleGrid.setAlignment(Pos.CENTER);
		titleGrid.setPadding(new Insets(10, 10, 10, 10));
		titleGrid.add(topGrid, 0, 1);

		Scene scene = new Scene(titleGrid, 750, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();

		btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				pass = txtPassword.getText();
				uname = txtPassword.getText();
				try {
					r.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}

	public static String getUname() {
		return uname;
	}

	public static String getPassword() {
		return pass;
	}

}
