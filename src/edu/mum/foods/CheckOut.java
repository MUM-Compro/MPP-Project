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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import edu.mum.foods.*;

public class CheckOut extends Application {
	
	static Stage classStage = new Stage();

	public static void main(String[] arg) {
		launch(arg);
	}

	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {

		primaryStage.setTitle("Check Out");

		Label lblPageTitle = new Label("Check Out");
		Label blankSpace = new Label("");
		Label lblItem = new Label("Items");		
		Label blankSpace2 = new Label("");
		lblPageTitle.setAlignment(Pos.CENTER);

		// get the latest order (temporary)

		String query = "SELECT * FROM tblOrder AS o INNER JOIN tblItems AS i "
				+ "WHERE o.iid = i.iid ORDER BY o.oid DESC LIMIT 1";

		try {
			Statement stmt = Connection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				System.out.println(rs.getInt("oid"));
				oid = rs.getInt("oid");
				
				name = rs.getString("i.item_name");
				qty = rs.getInt("o.qty");
				price = rs.getDouble("o.price");
				amount = qty * price;
				

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
		topGrid.add(lblItem, 0, 2);
		topGrid.add(blankSpace2, 0, 3);
		
		
		HBox hbox = new HBox(120);
		Label name = new Label("Name");
		Label qty = new Label("Qty");
		Label uprice = new Label ("Unit Price");
		Label amout = new Label("Amount");
		hbox.getChildren().add(name);
		hbox.getChildren().add(qty);
		hbox.getChildren().add(uprice);
		hbox.getChildren().add(amout);
		
		topGrid.add(hbox, 0, 4);
		
		HBox hbox2 = new HBox(25);
		TextField n = new TextField(this.name);
		ComboBox<String> cboQty = new ComboBox<String>();
		cboQty.getItems().addAll("1", "2", "3", "4", "5");
		cboQty.setValue(String.valueOf(this.qty));
		cboQty.setPrefWidth(100);
		
		TextField unit_price = new TextField();
		unit_price.setText(String.valueOf(price));
		
		TextField amount = new TextField();
		amount.setText(String.valueOf(this.amount));
		hbox2.getChildren().add(n);
		hbox2.getChildren().add(cboQty);
		hbox2.getChildren().add(unit_price);
		hbox2.getChildren().add(amount);
		
		topGrid.add(hbox2, 0, 5);
		
		Label blankSpace4 = new Label("");
		topGrid.add(blankSpace4, 0, 4);
		
		//declare some components for customer address and delivery
		Label customerinfo = new Label("Customer Delivery Info");
		Label lblCustomerName = new Label("Name");
		Label lblAddress = new Label("Address");
		Label lblCity = new Label("City");
		Label lblState = new Label("State");
		Label lblZip = new Label("Zip");
		Label lblPhone = new Label("Phone");
		Label lblStatus = new Label("Status");
		Label lblTracking = new Label("Tracking Purpose (Optional)");
		Label lblLongtitude = new Label("Longitude");
		Label lblLatitude = new Label("Latitude");
		TextField txtCustomerName = new TextField();
		txtCustomerName.setMaxWidth(300);
		TextField txtAddress = new TextField();
		TextField txtCity = new TextField();
		TextField txtState = new TextField();
		TextField txtZip = new TextField();
		TextField txtPhone = new TextField();
		TextField txtStatus = new TextField();
		TextField txtLongitude = new TextField();
		TextField txtLatitude = new TextField();
		
		//customer delivery address
		Label blankSpace5 = new Label("");
		topGrid.add(blankSpace5, 0, 6);
		Label blankSpace6 = new Label("");
		topGrid.add(customerinfo, 0, 7);
		topGrid.add(blankSpace6, 0, 8);
		topGrid.add(lblCustomerName, 0, 9);
		topGrid.add(txtCustomerName, 0, 10);
		topGrid.add(lblAddress, 0, 11);
		topGrid.add(txtAddress, 0, 12);
	
		HBox addressHBox = new HBox(25);
		VBox addressVBox1 = new VBox();
		addressVBox1.getChildren().add(lblCity);
		addressVBox1.getChildren().add(txtCity);
		addressVBox1.getChildren().add(lblPhone);
		addressVBox1.getChildren().add(txtPhone);
		VBox addressVBox2 = new VBox();
		addressVBox2.getChildren().add(lblState);
		addressVBox2.getChildren().add(txtState);
		VBox addressVBox3 = new VBox();
		addressVBox3.getChildren().add(lblZip);
		addressVBox3.getChildren().add(txtZip);
		addressHBox.getChildren().add(addressVBox1);
		addressHBox.getChildren().add(addressVBox2);
		addressHBox.getChildren().add(addressVBox3);
		topGrid.add(addressHBox, 0, 13);
		
		
		//customer input long and lat ***this is optional but good if they input
		Label blankSpace7 = new Label("");
		topGrid.add(blankSpace7, 0, 14);
		topGrid.add(lblTracking, 0, 15);
		Label blankSpace8 = new Label("");
		topGrid.add(blankSpace8, 0, 16);

		HBox tracking = new HBox (25);
		VBox trackingvbox = new VBox(10);
		trackingvbox.getChildren().add(lblLongtitude);
		trackingvbox.getChildren().add(lblLatitude);
		VBox trackingvboxtext = new VBox(10);
		trackingvboxtext.getChildren().add(txtLongitude);
		trackingvboxtext.getChildren().add(txtLatitude);
		tracking.getChildren().add(trackingvbox);
		tracking.getChildren().add(trackingvboxtext);
		topGrid.add(tracking, 0, 18);
		
		Label blankSpac10 = new Label("");
		topGrid.add(blankSpac10, 0, 19);
		
		
		
		//checkout part
		HBox hbox3 = new HBox(25);
		Button checkout = new Button("Check Out");
		Button cancel = new Button("Cancel");
		hbox3.getChildren().add(checkout);
		hbox3.getChildren().add(cancel);
		
		topGrid.add(hbox3, 0, 50);
		
		//check out button event on click
		checkout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				String query = "INSERT INTO tblDelivery (oid, cname, address, city, state, zip, phone, status, longtitude, latitude) VALUES("+oid+",'"+txtCustomerName.getText()+"'"+
						",'"+txtAddress.getText()+"','"+txtCity.getText()+"','"+txtState.getText()+"','"+
						txtZip.getText()+"','"+txtPhone.getText()+"','New','"+txtLongitude.getText()+"','"+
						txtLatitude.getText()+"')";

				try {
					Statement stmt = Connection.getConnection().createStatement();
					stmt.executeUpdate(query);
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText("Successful!");
					alert.setContentText("You have successful order item with us, check dashboard to track your order!");

					alert.showAndWait();
					

						CustomerDashboard dreg = new CustomerDashboard();

						try {
							dreg.start(CustomerDashboard.customerdashstage);
							primaryStage.close();

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
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		//cancel button event on click
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ListItem dreg = new ListItem();

				try {
					dreg.start(ListItem.listitemStage);
					primaryStage.close();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
		
		

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
	
	private String name;
	private int qty;
	private double price;
	private int cid;
	private double amount;
	private int oid;

}
