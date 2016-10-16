package edu.mum.foods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aquafx_project.AquaFx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class ListItem extends Application {

	public static void main(String[] arg) {
		launch(arg);
	}

	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {

		ListView<String> list = new ListView<>();

		ObservableList<String> items = FXCollections.observableArrayList();

		String query = "SELECT * FROM tblItems";

		try {
			Statement stmt = Connection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getString("item_name"));

				items.addAll(rs.getString("item_name"));

				list.setItems(items);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Connection.getConnection().close();
		}

		primaryStage.setTitle("Food Menu");

		Label lblPageTitle = new Label("Food Menu");
		Label blankSpace = new Label("");
		Label blankSpace2 = new Label("");
		Label blankSpace3 = new Label("Select your favorite food, then click Order");
		Label blankSpace4 = new Label("");
		lblPageTitle.setAlignment(Pos.BASELINE_LEFT);

		// top grid
		GridPane topGrid = new GridPane();
		topGrid.setAlignment(Pos.BASELINE_LEFT);
		topGrid.setHgap(10);

		topGrid.add(lblPageTitle, 0, 0);
		topGrid.add(blankSpace, 0, 1);
		topGrid.add(blankSpace3, 0, 3);
		topGrid.add(blankSpace4, 0, 4);
		
		Label detail = new Label("Detail: ");
		Label name = new Label("Name: ");
		Label category = new Label("Category: ");
		Label price = new Label("Price: ");
		Label desc = new Label("Description: ");
		
		Button btnOrder = new Button("Order");
		
		VBox vbox = new VBox(15);
		vbox.getChildren().add(detail);
		vbox.getChildren().add(name);
		vbox.getChildren().add(category);
		vbox.getChildren().add(price);
		vbox.getChildren().add(desc);
		vbox.getChildren().add(btnOrder);
		
		
		
		HBox hbox = new HBox(25);
		hbox.getChildren().add(list);
		hbox.getChildren().add(vbox);

		topGrid.add(hbox, 0, 5);

		// add all grid into main grid
		GridPane mainGrid = new GridPane();
		mainGrid.setAlignment(Pos.BASELINE_LEFT);
		mainGrid.setPadding(new Insets(10, 10, 10, 10));
		mainGrid.add(topGrid, 0, 1);

		Scene scene = new Scene(mainGrid, 550, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		AquaFx.style();

		// StackPane layout = new StackPane();
		// layout.setStyle("-fx-padding: 10; -fx-background-color: cornsilk;
		// -fx-font-size: 25px;");
		// layout.getChildren().add(listview);
		// primaryStage.setScene(new Scene(layout, 600, 550));
		// primaryStage.show();

		for (Node node : list.lookupAll(".scroll-bar")) {
			if (node instanceof ScrollBar) {
				final ScrollBar bar = (ScrollBar) node;
				bar.valueProperty().addListener(new ChangeListener<Number>() {
					@Override
					public void changed(ObservableValue<? extends Number> value, Number oldValue, Number newValue) {
						System.out.println(bar.getOrientation() + " " + newValue);

					}
				});
			}
		}

		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println(
						"ListView selection changed from oldValue = " + oldValue + " to newValue = " + newValue);
				
				String query = "SELECT * FROM tblItems WHERE item_name='"+newValue+"'";

				try {
					Statement stmt = Connection.getConnection().createStatement();
					ResultSet rs = stmt.executeQuery(query);

					while (rs.next()) {
						name.setText("Name: "+rs.getString("item_name"));
						category.setText("Category: "+ rs.getString("identifier"));
						price.setText("Price: " + rs.getDouble("price"));
						desc.setText("Description: " + rs.getString("description"));
					}

				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						Connection.getConnection().close();
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}

}
