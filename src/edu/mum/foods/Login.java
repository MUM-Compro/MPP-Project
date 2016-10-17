package edu.mum.foods;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aquafx_project.AquaFx;

import javafx.application.Application;
import javafx.application.Platform;
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
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Login extends Application {

	public static void main(String[] arg) {
		launch(arg);
	}

	static Stage loginStage = new Stage();

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

		Label lblLogin = new Label("");
		Button btnLogin = new Button("Login");
		Button btnRegister = new Button("Register");

		// Image imageRegister = new
		// Image(getClass().getResourceAsStream("add-user.png"));
		// btnSubmit.setGraphic(new ImageView(imageRegister));
		btnLogin.setId("btnRegister");
		btnRegister.setId("btnReset");

		HBox hbox = new HBox(20);
		hbox.getChildren().addAll(btnLogin, btnRegister);
		titleGrid.add(lblLogin, 0, 4);
		titleGrid.add(hbox, 0, 5);

		// Label lblSubmit = new Label("");
		// Button btnSubmit = new Button("Login");
		// titleGrid.add(lblSubmit, 0, 10);
		// titleGrid.add(btnSubmit, 0, 11);
		//
		// Label lblRegister = new Label("");
		// Button btnRegister = new Button("Register");
		// titleGrid.add(lblRegister, 1, 10);
		// titleGrid.add(btnRegister, 1, 11);

		// add all grid into main grid
		titleGrid.setAlignment(Pos.CENTER);
		titleGrid.setPadding(new Insets(10, 10, 10, 10));
		titleGrid.add(topGrid, 0, 1);

		Scene scene = new Scene(titleGrid, 450, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();

		btnRegister.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				Register reg = new Register();

				try {
					reg.start(Register.classStage);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				String enteredfname = txtEmail.getText();
				String enteredpw = txtPassword.getText();
				System.out.println(enteredfname);
				System.out.println(enteredpw);

				String fname = "";
				String pw = "";
				int st = 1;

				String query = "select firstname, password, access_level FROM tblperson";
				try {
					Statement stmt = Connection.getConnection().createStatement();
					ResultSet rs = stmt.executeQuery(query);

					while (rs.next()) {
						// Retrieve by column name
						fname = rs.getString("firstname");
						pw = rs.getString("password");
						st = rs.getInt("access_level");

						if (enteredfname.equals(fname) && enteredpw.equals(pw) && st == 1) {
							primaryStage.hide();
							System.out.println(fname);
							AdminDashboard dreg = new AdminDashboard();

							try {
								dreg.start(AdminDashboard.classStage);

							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} 
						else if (enteredfname.equals(fname) && enteredpw.equals(pw) && st == 2) {
							primaryStage.hide();
							ListItem dreg = new ListItem();

							try {
								dreg.start(ListItem.list2Stage);

							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							Label lblEror1 = new Label("");
							titleGrid.add(lblEror1, 0, 9);
							Label lblEror = new Label("Password or Username is not matched");
							titleGrid.add(lblEror, 0, 10);

						}
					}

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
