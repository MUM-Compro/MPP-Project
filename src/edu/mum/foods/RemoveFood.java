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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RemoveFood extends Application {

	public static void main(String[] arg) {
		launch(arg);
	}

	static Stage classStage = new Stage();

	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {

		ListView<String> list = new ListView<>();

		ObservableList<String> items = FXCollections.observableArrayList();

		String query = "SELECT * FROM tblitems where status='0'";

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

		Label lblPageTitle = new Label("Manage Food");
		Label blankSpace = new Label("");
		Label blankSpace2 = new Label("");
		Label blankSpace3 = new Label("Select Item Name to Remove it");
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

		topGrid.add(new Label(""), 0, 6);
		Button btnBack = new Button("Back");
		topGrid.add(btnBack, 0, 23);

		Label itemName = new Label("Item Name:");
		Label descr = new Label("Description:");
		Label cat = new Label("Category:        ");
		Label price = new Label("price: ");

		System.out.println(this.getClass());

		Button btnDelete = new Button("Delete");

		VBox vbox = new VBox(15);
		vbox.getChildren().add(itemName);
		vbox.getChildren().add(descr);
		vbox.getChildren().add(cat);
		vbox.getChildren().add(price);
		vbox.getChildren().add(btnDelete);

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

				String query = "SELECT * FROM tblitems WHERE status='0' AND item_name='" + newValue + "'";

				try {
					Statement stmt = Connection.getConnection().createStatement();
					ResultSet rs = stmt.executeQuery(query);

					while (rs.next()) {
						itemName.setText("Item Name: " + rs.getString("item_name"));
						descr.setText("Description: " + rs.getString("description"));
						cat.setText("Category: " + rs.getString("identifier"));
						price.setText("Price: " + rs.getString("price"));

						iid = rs.getInt("iid");

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

				btnDelete.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						String query = "UPDATE tblitems SET status=1 WHERE iid=" + iid;

						try {

							Statement stmt = Connection.getConnection().createStatement();
							stmt.executeUpdate(query);
							System.out.println("im here");

							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Information Dialog");
							alert.setHeaderText("Successful!");
							alert.setContentText("You have successful removed the user from our system!");
							alert.showAndWait();

							primaryStage.hide();

							try {
								RemoveFood r = new RemoveFood();
								r.start(RemoveFood.classStage);

							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} finally {
							try {
								Connection.getConnection().close();
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});
			}
		});

		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				FoodAdminDashboard lreg = new FoodAdminDashboard();

				try {
					lreg.start(FoodAdminDashboard.classStage);
				} catch (Exception e) {

				}
			}
		});

	}

	private int iid;
}
