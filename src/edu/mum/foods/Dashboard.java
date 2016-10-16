package edu.mum.foods;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Dashboard extends Application {

	public static void main(String[] args) {
			launch(Dashboard.class, args);
	}
	
	static Stage dashStage = new Stage();

	@Override
	public void start(Stage stage) throws Exception {
		
		
		Dashboard.dashStage = stage;
		
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

		stage.setTitle("Admin Dashboard");
		stage.setScene(new Scene(root, 640, 500));
		stage.show();
	}
}
