package edu.mum.foods;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.activation.MimeType;

import com.aquafx_project.AquaFx;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Path;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class AddFood extends Application {

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

		Label lblFoodname = new Label("Food Name");
		TextField txtFoodname = new TextField();
		txtFoodname.setPrefWidth(300);

		topGrid.add(lblFoodname, 0, 2);
		topGrid.add(txtFoodname, 0, 3);

		// Label lblLastname = new Label("Category");
		// TextField txtLastname = new TextField();
		// txtLastname.setPrefWidth(300);
		// topGrid.add(lblLastname, 0, 4);
		// topGrid.add(txtLastname, 0, 5);

		Label lblCategory = new Label("Category");
		ComboBox<String> cboCategory = new ComboBox<String>();
		cboCategory.getItems().addAll("-Select-", "American", "Nepali", "Combodian");
		cboCategory.setValue("-Select-");
		cboCategory.setPrefWidth(180);

		topGrid.add(lblCategory, 0, 4);
		topGrid.add(cboCategory, 0, 5);

		Label lblDescription = new Label("Description");
		TextArea txtDescription = new TextArea();
		txtDescription.setPrefWidth(300);
		topGrid.add(lblDescription, 0, 6);
		topGrid.add(txtDescription, 0, 7);

		Label lblPrice = new Label("Price");
		TextField txtPrice = new TextField();
		txtPrice.setPrefWidth(300);
		topGrid.add(lblPrice, 0, 8);
		topGrid.add(txtPrice, 0, 9);

		Label lblImage = new Label("");
		Button btnImageChooser = new Button("Choose Image");
		topGrid.add(lblImage, 0, 10);
		topGrid.add(btnImageChooser, 0, 11);
		


		
		Label imagepath = new Label("");
		topGrid.add(imagepath, 0, 19);

		btnImageChooser.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				

				FileChooser fileChooser = new FileChooser();
				File fileToSave = fileChooser.showSaveDialog(primaryStage);
				File defaultDirectory = new File("resource/");
				fileChooser.setInitialDirectory(defaultDirectory);

				if (fileToSave != null) {
					try {
						FileOutputStream fos = new FileOutputStream(fileToSave);

					} catch (Exception e) {
						Alert alert = new Alert(AlertType.ERROR, "Unable to save file : " + e.getMessage(), ButtonType.CLOSE);
						alert.showAndWait();
						return;
					}
				}

			    System.out.println(fileToSave.getName());

			    filename = fileToSave.getName();
			    
			    
			    
			    System.out.println(filename);

			}
		});
		



		Label lblSubmit = new Label("");
		Button btnSubmit = new Button("Add");
		topGrid.add(lblSubmit, 0, 20);
		topGrid.add(btnSubmit, 0, 21);

		// add all grid into main grid
		GridPane mainGrid = new GridPane();
		mainGrid.setAlignment(Pos.TOP_CENTER);
		mainGrid.setPadding(new Insets(10, 10, 10, 10));
		mainGrid.add(topGrid, 0, 1);

		Scene scene = new Scene(mainGrid, 450, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();

		btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				try {
					RegisterFood.getRegisterFood(txtFoodname.getText(), cboCategory.getValue(), txtDescription.getText(),
							txtPrice.getText(), filename);
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

	}
	
	private String filename;

}
