package edu.mum.foods;

import java.sql.SQLException;

import com.aquafx_project.AquaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListItem extends Application {

	public static void main(String[] arg) {
		launch(arg);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("Food Menu");

		Label lblPageTitle = new Label("Food Menu");
		Label blankSpace = new Label("");
		lblPageTitle.setAlignment(Pos.CENTER);

		// top grid
		GridPane topGrid = new GridPane();
		topGrid.setAlignment(Pos.TOP_CENTER);
		topGrid.setHgap(10);

		topGrid.add(lblPageTitle, 0, 0);
		topGrid.add(blankSpace, 0, 1);
		
		Label lblFoodName = new Label("Food Name");
		Label lblPrice = new Label("Price");
		Label lblDescription = new Label("Description");
		Label lblCategory = new Label("Category");
		
        ImageView imv = new ImageView();
        Image image2 = new Image(ListItem.class.getResourceAsStream("food.jpg"),100,100, false, false);
        imv.setImage(image2);
        imv.autosize();
        

		
		VBox foodbox = new VBox(10);
		foodbox.getChildren().addAll(lblFoodName, lblPrice, lblCategory, lblDescription);
		
        HBox foodlist = new HBox(10);
        foodlist.getChildren().addAll(imv, foodbox);
		
		topGrid.add(foodlist, 0, 4);

		


		// add all grid into main grid
		GridPane mainGrid = new GridPane();
		mainGrid.setAlignment(Pos.TOP_CENTER);
		mainGrid.setPadding(new Insets(10, 10, 10, 10));
		mainGrid.add(topGrid, 0, 1);

		Scene scene = new Scene(mainGrid, 450, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();

	

	}

}
