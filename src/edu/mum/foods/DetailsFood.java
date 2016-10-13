package edu.mum.foods;

import java.sql.SQLException;

import com.aquafx_project.AquaFx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class DetailsFood extends Application{
	
	public static void main(String[] arg) {
		launch(arg);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("Food");
		
		 ImageView iv2 = new ImageView();
		 Image img= new Image(DetailsFood.class.getResourceAsStream("dal_bhat_nepal1.jpg"));
         iv2.setImage((img));
         iv2.setFitWidth(300);
         iv2.setPreserveRatio(true);
         iv2.setSmooth(true);
         iv2.setCache(true);

		// top grid
		GridPane topGrid = new GridPane();
		topGrid.setAlignment(Pos.TOP_CENTER);
		topGrid.setHgap(10);

		topGrid.add(iv2, 0, 0);
		
		HBox hboxName = new HBox(8); // spacing = 8
	    
		Label lblFoodname = new Label("Dal Bhat:");
		lblFoodname.setFont(new Font(20));
		Label lblFoodCat = new Label("Nepali");
		lblFoodCat.setFont(new Font(18));
		hboxName.getChildren().addAll(lblFoodname,lblFoodCat);
		topGrid.add(hboxName, 0, 2);
		
		String disc="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proide.";
		
		HBox hboxDisc = new HBox(8);
		Label lblFoodDis = new Label("Description:");
		Text text = new Text();
		text.setFont(new Font(12));
		text.setWrappingWidth(230);
		text.setTextAlignment(TextAlignment.JUSTIFY);
		text.setText(disc);
		hboxDisc.getChildren().addAll(lblFoodDis,text);
		topGrid.add(hboxDisc, 0, 3);
		
		HBox hboxBuy = new HBox(8); // spacing = 8
		hboxBuy.setAlignment(Pos.BOTTOM_RIGHT);
		
		Label lblPrice = new Label("$"+"20");
		lblFoodname.setFont(new Font(16));
		Button btnBuy = new Button("Buy");
		hboxBuy.getChildren().addAll(lblPrice,btnBuy);
		topGrid.add(hboxBuy, 0, 4);
		

		// add all grid into main grid
		GridPane mainGrid = new GridPane();
		mainGrid.setAlignment(Pos.TOP_CENTER);
		mainGrid.setPadding(new Insets(10, 10, 10, 10));
		mainGrid.add(topGrid, 0, 1);

		Scene scene = new Scene(mainGrid, 650, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();

//		btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//
//
//
//			}
//		});

	}

}

