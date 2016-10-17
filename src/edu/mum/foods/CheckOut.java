package edu.mum.foods;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import edu.mum.foods.*;

public class CheckOut extends Application {

	public static void main(String[] arg) {
		launch(arg);
	}

	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {

		primaryStage.setTitle("Check Out");

		Label lblPageTitle = new Label("Check Out");
		Label blankSpace = new Label("");
		lblPageTitle.setAlignment(Pos.CENTER);
		
		
		//get the latest order (temporary)
		
		String query = "SELECT * FROM tblOrder ORDER BY DESC";

		try {
			Statement stmt = Connection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				
				System.out.println(rs.getInt("oid"));

			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Connection.getConnection().close();
		}
		
		
		
		
		// top grid
		GridPane topGrid = new GridPane();
		topGrid.setAlignment(Pos.BASELINE_LEFT);
		topGrid.setHgap(10);

		topGrid.add(lblPageTitle, 0, 0);
		topGrid.add(blankSpace, 0, 1);



		// add all grid into main grid
		GridPane mainGrid = new GridPane();
		mainGrid.setAlignment(Pos.TOP_CENTER);
		mainGrid.setPadding(new Insets(10, 10, 10, 10));
		mainGrid.add(topGrid, 0, 1);

		Scene scene = new Scene(mainGrid, 550, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();
	}

}
