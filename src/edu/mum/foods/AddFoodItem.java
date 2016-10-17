package edu.mum.foods;

import java.sql.SQLException;

import com.aquafx_project.AquaFx;

import edu.mum.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AddFoodItem extends Application {

	public static void main(String[] arg) {
		launch(arg);
	}

	static Stage classStage = new Stage();

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Register.classStage = primaryStage;

		primaryStage.setTitle("Add New Food Item");

		Label lblPageTitle = new Label("Add New Food Item");
		Label blankSpace = new Label("");
		lblPageTitle.setAlignment(Pos.CENTER);

		// top grid
		GridPane topGrid = new GridPane();
		topGrid.setAlignment(Pos.TOP_CENTER);
		topGrid.setHgap(10);

		topGrid.add(lblPageTitle, 0, 0);
		topGrid.add(blankSpace, 0, 1);

		Label lblFoodName = new Label("Item Name");
		TextField txtFoodName = new TextField();
		txtFoodName.setPrefWidth(300);

		// Label lblFirstnameValidate = new Label("te");

		topGrid.add(lblFoodName, 0, 2);
		topGrid.add(txtFoodName, 0, 3);

		// topGrid.add(lblFirstnameValidate, 0, 30);

		Label lblCategory = new Label("Category");
		ComboBox<String> cboCat = new ComboBox<String>();
		cboCat.getItems().addAll("-Select-", "Nepali", "Cambodia", "American");
		cboCat.setValue("-Select-");
		cboCat.setPrefWidth(180);

		topGrid.add(lblCategory, 0, 10);
		topGrid.add(cboCat, 0, 11);

		Label lblDescription = new Label("Description");
		TextField txtDescription = new TextField();
		txtDescription.setPrefWidth(300);
		topGrid.add(lblDescription, 0, 12);
		topGrid.add(txtDescription, 0, 13);

		Label lblPrice = new Label("Price");
		TextField txtPrice = new TextField();
		txtPrice.setPrefWidth(300);
		topGrid.add(lblPrice, 0, 14);
		topGrid.add(txtPrice, 0, 15);
		
		Label lblImage = new Label("Image");
		TextField txtImage = new TextField();
		txtImage.setPrefWidth(300);
		topGrid.add(lblImage, 0, 16);
		topGrid.add(txtImage, 0, 17);

		// Label lblRole = new Label("Role");
		// ComboBox<String> cboRole = new ComboBox<String>();
		// cboRole.getItems().addAll("Admin", "Customer");
		// cboRole.setValue("Admin");
		// cboRole.setPrefWidth(180);
		// topGrid.add(lblRole, 0, 16);
		// topGrid.add(cboRole, 0, 17);

		Label lblSubmit = new Label("");
		Button btnSubmit = new Button("Register");
		Button btnReset = new Button("Reset");

		// Image imageRegister = new
		// Image(getClass().getResourceAsStream("add-user.png"));
		// btnSubmit.setGraphic(new ImageView(imageRegister));
		btnSubmit.setId("btnRegister");
		btnReset.setId("btnReset");

		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(btnSubmit, btnReset);
		topGrid.add(lblSubmit, 0, 20);
		topGrid.add(hbox, 0, 21);

		Label lblLogin1 = new Label("");
		topGrid.add(lblLogin1, 0, 22);
		Label lblLogin = new Label("Already a Member?");
		Button btnLogin = new Button("Login");
		HBox hbox2 = new HBox(10);
		hbox2.getChildren().addAll(lblLogin, btnLogin);
		topGrid.add(hbox2, 0, 23);

		// add all grid into main grid
		GridPane mainGrid = new GridPane();
		mainGrid.setAlignment(Pos.TOP_CENTER);
		mainGrid.setPadding(new Insets(10, 10, 10, 10));
		mainGrid.add(topGrid, 0, 1);

		Scene scene = new Scene(mainGrid, 450, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();

		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				Login lreg = new Login();

				try {
					lreg.start(Login.loginStage);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				try {
					RegisterUser.getRegister(txtFirstname.getText(), txtLastname.getText(), txtEmail.getText(),
							txtPassword.getText(), cboGender.getValue(), txtAddress.getText(),
							txtContactNumber.getText(), "1");
					System.out.println("Inserted");

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText("Successful!");
					alert.setContentText("You have successful register account with our system!");

					alert.showAndWait();

				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Failed");
				}

			}
		});

		btnReset.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				txtFirstname.setText("");
				txtLastname.setText("");
				txtEmail.setText("");
				txtPassword.setText("");
				txtContactNumber.setText("");
				txtAddress.setText("");
				cboGender.setValue("-Select-");

			}
		});

	}

}
