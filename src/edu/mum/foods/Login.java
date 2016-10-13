package edu.mum.foods;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aquafx_project.AquaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Login extends Application {

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
				String fname = "";
				String pw = "";
				int sts = 1;
				String enteredfname = "";
				String enteredpw = "";
				int enteredsts = 1;

				String query = "select firstname, password, status FROM tblperson";
				try {
					Statement stmt = Connection.getConnection().createStatement();
					ResultSet rs = stmt.executeQuery(query);

					while (rs.next()) {
						// Retrieve by column name
						fname = rs.getString("firstname");
						pw = rs.getString("password");
						sts = rs.getInt("status");
						
						enteredfname=txtEmail.getText();
						enteredpw=txtPassword.getText();
						
						//checking condition
						
						if(fname.equals(enteredfname) && pw.equals(enteredpw)){
							System.out.println("im inside");
							Register.launch();
							
						}
					}
					
					txtEmail.setText("");
					txtPassword.setText("");
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Try Again");
					alert.setHeaderText("Error!");
					alert.setContentText("Either your Username or password is not matched with our system data please try again");
					alert.showAndWait();
					
					
					rs.close();

				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						Connection.getConnection().close();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				System.out.println();

			}
		});

	}

}
