package edu.mum.foods;

import com.aquafx_project.AquaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomerDashboard extends Application {
	
	static Stage customerdashstage = new Stage();

	public static void main(String[] arg) {
		launch(arg);
	}

	static Stage classStage = new Stage();

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		CustomerDashboard.classStage = primaryStage;

		primaryStage.setTitle("Customer Dashboard");

		Label lblPageTitle = new Label("Buy Food!!");
		Label blankSpace = new Label("");
		lblPageTitle.setAlignment(Pos.CENTER);

		// top grid
		GridPane topGrid = new GridPane();
		topGrid.setAlignment(Pos.TOP_CENTER);
		topGrid.setHgap(10);

		topGrid.add(lblPageTitle, 0, 0);
		topGrid.add(blankSpace, 0, 1);

		HBox boxSearch= new HBox();
		TextField feildSearch= new TextField();
		Button btnSearch = new Button("Search");
		boxSearch.getChildren().addAll(feildSearch, btnSearch);
		topGrid.add(boxSearch, 0, 2);
		
		topGrid.add(new Label(""), 0, 3);
		topGrid.add(new Label(""), 0, 4);
		
		Label lblCat= new Label("Category:");
		topGrid.add(lblCat, 0, 5);
		
		topGrid.add(new Label(""), 0, 6);
		
		HBox boxCat= new HBox();
		boxCat.setSpacing(15);
		
		VBox boxNep= new VBox();
		 ImageView imgNep = new ImageView();
		 Image img= new Image(DetailsFood.class.getResourceAsStream("dal_bhat_nepal1.jpg"));
         imgNep.setImage((img));
         imgNep.setFitWidth(130);
         imgNep.setPreserveRatio(true);
         Button btnNep= new Button("Nepali");
        boxNep.getChildren().addAll(imgNep,btnNep);
        
        VBox boxUsa= new VBox();
		 ImageView imgUsa = new ImageView();
		 Image img1= new Image(DetailsFood.class.getResourceAsStream("dal_bhat_nepal1.jpg"));
        imgUsa.setImage((img1));
        imgUsa.setFitWidth(130);
        imgUsa.setPreserveRatio(true);
        Button btnUsa= new Button("American");
       boxUsa.getChildren().addAll(imgUsa,btnUsa);
       
       VBox boxCam= new VBox();
		 ImageView imgCam = new ImageView();
		 Image img2= new Image(DetailsFood.class.getResourceAsStream("dal_bhat_nepal1.jpg"));
       imgCam.setImage((img2));
       imgCam.setFitWidth(130);
       imgCam.setPreserveRatio(true);
       Button btnCam= new Button("Cambodian");
      boxCam.getChildren().addAll(imgCam,btnCam);
         
        boxCat.getChildren().addAll(boxNep, boxCam, boxUsa);
		topGrid.add(boxCat, 0, 7);

		// add all grid into main grid
		GridPane mainGrid = new GridPane();
		mainGrid.setAlignment(Pos.TOP_CENTER);
		mainGrid.setPadding(new Insets(10, 10, 10, 10));
		mainGrid.add(topGrid, 0, 1);

		Scene scene = new Scene(mainGrid, 450, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();

		btnSearch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				try {
					
				} catch (Exception e) {
					
				}
			}
		});
		
		btnNep.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				try {
					
				} catch (Exception e) {
					
				}
			}
		});
		
		btnCam.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				try {
					
				} catch (Exception e) {
					
				}
			}
		});
		
		btnUsa.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				try {
					
				} catch (Exception e) {
					
				}
			}
		});



	}

}
