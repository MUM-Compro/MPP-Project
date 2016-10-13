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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
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
		Label blankSpace2 = new Label("");
		Label blankSpace3 = new Label("");
		lblPageTitle.setAlignment(Pos.BASELINE_LEFT);

		// top grid
		GridPane topGrid = new GridPane();
		topGrid.setAlignment(Pos.BASELINE_LEFT);
		topGrid.setHgap(10);

		topGrid.add(lblPageTitle, 0, 0);
		topGrid.add(blankSpace, 0, 1);
		topGrid.add(blankSpace3, 0, 3);
		
		//food info start here
		
		Label lblFoodName = new Label("Food Name");
		Label lblPrice = new Label("Price");
		Label lblDescription = new Label("Description");
		Label lblCategory = new Label("Category");
		
        ImageView imv = new ImageView();
        Image image2 = new Image(ListItem.class.getResourceAsStream("food.jpg"),100,100, false, false);
        imv.setImage(image2);
        imv.autosize();
        
		VBox foodinfo = new VBox(10);
		foodinfo.setPrefWidth(200);
		foodinfo.getChildren().addAll(lblFoodName, lblPrice, lblCategory, lblDescription);
		
		VBox foodbutton = new VBox(10);
		Button btnOrder = new Button("Order");
		Button btnDetail = new Button("Detail");
		foodbutton.getChildren().addAll(btnOrder, btnDetail);
		
        HBox foodlist = new HBox(10);
        foodlist.getChildren().addAll(imv, foodinfo, foodbutton);
		
		topGrid.add(foodlist, 0, 4);
		
		//end food info
		
		
		Line line = new Line(1000, 10,   10, 10);
		topGrid.add(blankSpace2, 0, 5);
		topGrid.add(line, 0, 6);
		
		
		//togglegroup button
	    final ToggleGroup group = new ToggleGroup();

	    ToggleButton tb1 = new ToggleButton("American");
	    tb1.setToggleGroup(group);
	    tb1.setUserData(Color.LIGHTGREEN);
	    tb1.setSelected(true);


	    ToggleButton tb2 = new ToggleButton("Nepali");
	    tb2.setToggleGroup(group);
	    tb2.setUserData(Color.LIGHTBLUE);
	    ToggleButton tb3 = new ToggleButton("Cambodia");
	    tb3.setToggleGroup(group);
	    tb3.setUserData(Color.SALMON);
	    

	    HBox hbox = new HBox();

	    hbox.getChildren().add(tb1);
	    hbox.getChildren().add(tb2);
	    hbox.getChildren().add(tb3);
	    
	    topGrid.add(hbox, 0, 2);

		


		// add all grid into main grid
		GridPane mainGrid = new GridPane();
		mainGrid.setAlignment(Pos.BASELINE_LEFT);
		mainGrid.setPadding(new Insets(10, 10, 10, 10));
		mainGrid.add(topGrid, 0, 1);

		Scene scene = new Scene(mainGrid, 450, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();

	

	}

}
