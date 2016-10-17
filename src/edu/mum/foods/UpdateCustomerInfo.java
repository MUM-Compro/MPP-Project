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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpdateCustomerInfo extends Application {

	public static void main(String[] arg) {
		launch(arg);
	}

	static Stage classStage = new Stage();

	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {

		ListView<String> list = new ListView<>();

		ObservableList<String> items = FXCollections.observableArrayList();

		String query = "SELECT * FROM tblperson where status='1'";

		try {
			Statement stmt = Connection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getString("firstname"));

				items.addAll(rs.getString("firstname"));

				list.setItems(items);

			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Connection.getConnection().close();
		}

		primaryStage.setTitle("Food Menu");

		Label lblPageTitle = new Label("Update User Info");
		Label blankSpace = new Label("");
		Label blankSpace2 = new Label("");
		Label blankSpace3 = new Label("Select User to Update its Information");
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

		Label fname = new Label("First Name:");
		Label lname = new Label("Last Name:");
		Label email = new Label("Email:        ");
		Label password = new Label("Password: ");
		// Label acess = new Label("Access Status: ");

		TextField txtFname = new TextField("First Name  ");
		TextField txtLname = new TextField("Last Name   ");
		TextField txtEmail = new TextField("Email       ");
		TextField txtPassword = new TextField("Password ");
		// TextField txtAc = new TextField("Access Status: ");

		HBox hbox1 = new HBox(20);
		hbox1.getChildren().addAll(fname, txtFname);
		HBox hbox2 = new HBox(20);
		hbox2.getChildren().addAll(lname, txtLname);
		HBox hbox3 = new HBox(20);
		hbox3.getChildren().addAll(email, txtEmail);
		HBox hbox4 = new HBox(20);
		hbox4.getChildren().addAll(password, txtPassword);

		System.out.println(this.getClass());

		Button btnUpdate = new Button("Update");

		VBox vbox = new VBox(15);
		vbox.getChildren().add(hbox1);
		vbox.getChildren().add(hbox2);
		vbox.getChildren().add(hbox3);
		vbox.getChildren().add(hbox4);
		vbox.getChildren().add(btnUpdate);

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

				String query = "SELECT * FROM tblperson WHERE status='1' AND firstname='" + newValue + "'";

				try {
					Statement stmt = Connection.getConnection().createStatement();
					ResultSet rs = stmt.executeQuery(query);

					while (rs.next()) {
						txtFname.setText(rs.getString("firstname"));
						txtLname.setText(rs.getString("lastname"));
						txtEmail.setText(rs.getString("email"));
						txtPassword.setText(rs.getString("password"));
						// String ac = rs.getString("access_level");
						// if (ac.equals("1")) {
						// txtAc.setText("Access Status: Admin");
						// } else {
						// txtAc.setText("Access Status: Customer");
						// }
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

				btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						String upFName = txtFname.getText();
						String upLName = txtLname.getText();
						String upEmail = txtEmail.getText();
						String upPassword = txtPassword.getText();
						String query = "UPDATE tblperson SET firstname='" + upFName + "' , lastname='" + upLName
								+ "' , email='" + upEmail + "' , password='" + upPassword + "' WHERE firstname='"
								+ newValue + "'";

						try {

							Statement stmt = Connection.getConnection().createStatement();
							stmt.executeUpdate(query);
							System.out.println("im here");

							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Information Dialog");
							alert.setHeaderText("Successful!");
							alert.setContentText("You have successful Updated the user info from our system!");
							alert.showAndWait();
							primaryStage.hide();

							try {
								UpdateCustomerInfo upi = new UpdateCustomerInfo();
								upi.start(RemoveCustomer.classStage);

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
				ManageCustomer lreg = new ManageCustomer();

				try {
					lreg.start(ManageCustomer.mcStage);
				} catch (Exception e) {

				}
			}
		});

	}
}
