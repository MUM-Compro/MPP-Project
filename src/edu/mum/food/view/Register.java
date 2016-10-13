package edu.mum.food.view;

import com.aquafx_project.AquaFx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
		
		Label lblPageTitle = new Label("Register New User");
		Label blankSpace = new Label("");
		lblPageTitle.setAlignment(Pos.CENTER);
		
		// top grid
		GridPane topGrid = new GridPane();
		topGrid.setAlignment(Pos.TOP_CENTER);
		topGrid.setHgap(10);
		
		topGrid.add(lblPageTitle, 0, 0);
		topGrid.add(blankSpace, 0, 1);

		Label lblFirstname = new Label("Firstname");
		TextField txtFirstname = new TextField();
		txtFirstname.setPrefWidth(300);
		topGrid.add(lblFirstname, 0, 2);
		topGrid.add(txtFirstname, 0, 3);

		Label lblLastname = new Label("Lastname");
		TextField txtLastname = new TextField();
		txtLastname.setPrefWidth(300);
		topGrid.add(lblLastname, 0, 4);
		topGrid.add(txtLastname, 0, 5);
		
		Label lblEmail = new Label("Email");
		TextField txtEmail = new TextField();
		txtEmail.setPrefWidth(300);
		topGrid.add(lblEmail, 0, 6);
		topGrid.add(txtEmail, 0, 7);
		
		Label lblPassword = new Label("Password");
		PasswordField txtPassword = new PasswordField();
		txtPassword.setPrefWidth(300);
		topGrid.add(lblPassword, 0, 8);
		topGrid.add(txtPassword, 0, 9);
		
		Label lblGender = new Label("Gender");
		ComboBox<String> cboGender = new ComboBox<String>();
		cboGender.getItems().addAll("Male", "Female");
		cboGender.setValue("Male");
		cboGender.setPrefWidth(180);
		
		topGrid.add(lblGender, 0, 10);
		topGrid.add(cboGender, 0, 11);
		
		Label lblAddress = new Label("Address");
		TextField txtAddress = new TextField();
		txtAddress.setPrefWidth(300);
		topGrid.add(lblAddress, 0, 12);
		topGrid.add(txtAddress, 0, 13);
		
		Label lblContactNumber = new Label("Contact Number");
		TextField txtContactNumber = new TextField();
		txtContactNumber.setPrefWidth(300);
		topGrid.add(lblContactNumber, 0, 14);
		topGrid.add(txtContactNumber, 0, 15);
		
		Label lblRole = new Label("Role");
		ComboBox<String> cboRole = new ComboBox<String>();
		cboRole.getItems().addAll("Admin", "Customer");
		cboRole.setValue("Admin");
		cboRole.setPrefWidth(180);
		topGrid.add(lblRole, 0, 16);
		topGrid.add(cboRole, 0, 17);

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
