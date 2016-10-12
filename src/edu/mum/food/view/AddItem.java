package edu.mum.food.view;

import java.io.File;

import com.aquafx_project.*;

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
import javafx.stage.Window;

public class AddItem extends Application{
	
	public static void main(String[] arg){
		launch(arg);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		primaryStage.setTitle("Add Item");
		
		//title grid
		GridPane titleGrid = new GridPane();
		titleGrid.setAlignment(Pos.CENTER);
		titleGrid.setHgap(10);
		
		//top grid
		GridPane topGrid = new GridPane();
		topGrid.setAlignment(Pos.CENTER);
		topGrid.setHgap(10);
		
		Label lblItemCode = new Label("Item Code");
		TextField txtItemCode = new TextField();
		txtItemCode.setPrefWidth(300);
		topGrid.add(lblItemCode, 0, 0);
		topGrid.add(txtItemCode, 0, 1);
		
		Label lblName = new Label("Name");
		TextField txtName = new TextField();
		txtName.setPrefWidth(300);
		topGrid.add(lblName, 0, 2);
		topGrid.add(txtName, 0, 3);
		
		Label lblPrice = new Label("Price");
		TextField txtPrice = new TextField();
		txtPrice.setPrefWidth(300);
		topGrid.add(lblPrice, 0, 4);
		topGrid.add(txtPrice, 0, 5);
		
		Label lblImage = new Label("");
		Button btnImageChooser = new Button("Choose Image");
		topGrid.add(lblImage, 0, 6);
		topGrid.add(btnImageChooser, 0, 7);
		
		btnImageChooser.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 FileChooser fileChooser = new FileChooser();
				 fileChooser.setTitle("Open Resource File");
				 fileChooser.getExtensionFilters().addAll(
				         new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
				 File selectedFile = fileChooser.showOpenDialog(primaryStage);
			}
		});
		

		Label lblDescription = new Label("");
		TextArea txtDescription = new TextArea();
		topGrid.add(lblDescription, 0, 8);
		topGrid.add(txtDescription, 0, 9);
		
		Label lblSubmit = new Label("");
		Button btnSubmit = new Button("Submit");
		topGrid.add(lblSubmit, 0, 10);
		topGrid.add(btnSubmit, 0, 11);

		
		//add all grid into main grid
		GridPane mainGrid = new GridPane();
		mainGrid.setAlignment(Pos.CENTER);
		mainGrid.setPadding(new Insets(10,10,10,10));
		mainGrid.add(topGrid, 0, 1);
		
		Scene scene = new Scene(mainGrid,700,700);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();
		
	}
	
	
	

}
