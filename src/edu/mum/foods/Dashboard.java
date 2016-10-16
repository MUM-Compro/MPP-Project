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

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("listfood.fxml"));

		stage.setTitle("FXML Welcome");
		stage.setScene(new Scene(root, 640, 500));
		stage.show();
	}
}
