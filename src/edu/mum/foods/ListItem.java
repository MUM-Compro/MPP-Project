package edu.mum.foods;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListItem extends Application implements ActionListener {
	
	static String sch = "";

	Button btnOrder = new Button("Order");
	Scene scene1, scene2, scene3;
	Stage thestage;
	
	static Stage listitemStage = new Stage();

	public static void main(String[] arg) {
		launch(arg);
	}
	
	static Stage listStage = new Stage();

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
//		Label lblAdmin = new Label("Admin? ");
		TextField txtSearch = new TextField();
		Button btnSearch = new Button("Search");
		Button btnAdmin = new Button("Log In");
		btnSearch.setMinSize(60, 20);
		btnAdmin.setMinSize(60, 20);
//		HBox hbox1= new HBox();
//		hbox1.getChildren().addAll(lblAdmin, btnAdmin);
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
		topGrid.add(txtSearch, 0, 0);
		topGrid.add(btnSearch, 1, 0);
		topGrid.add(btnAdmin, 2, 0);
		topGrid.add(blankSpace, 0, 1);
		topGrid.add(blankSpace3, 0, 3);
		topGrid.add(blankSpace4, 0, 4);

		Label detail = new Label("Detail ");
		Label name = new Label("Name: ");
		Label category = new Label("Category: ");
		Label price = new Label("Price: ");
		Label desc = new Label("Description: ");

		ImageView imv = new ImageView();
		Image image2 = new Image(ListItem2.class.getResourceAsStream("resource/food.jpg"), 200, 200, false, false);
		imv.setImage(image2);
		imv.autosize();

		System.out.println(this.getClass());

		Label lblQty = new Label("Quality: ");
		ComboBox<String> cboQty = new ComboBox<String>();
		cboQty.getItems().addAll("1", "2", "3", "4", "5");
		cboQty.setValue("1");
		cboQty.setPrefWidth(100);

		VBox vbox = new VBox(15);
		vbox.getChildren().add(detail);
		vbox.getChildren().add(name);
		vbox.getChildren().add(category);
		vbox.getChildren().add(price);
		vbox.getChildren().add(desc);
		vbox.getChildren().add(imv);
		vbox.getChildren().add(lblQty);
		vbox.getChildren().add(cboQty);
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

		// all component for scene2
		// title grid
		GridPane titleGrid = new GridPane();
		titleGrid.setAlignment(Pos.CENTER);
		titleGrid.setHgap(10);

		// top grid
		GridPane topGrid2 = new GridPane();
		titleGrid.setAlignment(Pos.CENTER);
		titleGrid.setHgap(10);

		Label lblEmail = new Label("Email");
		TextField txtEmail = new TextField();
		txtEmail.setPrefWidth(300);
		titleGrid.add(lblEmail, 0, 0);
		titleGrid.add(txtEmail, 0, 1);

		Label lblPassword = new Label("Password");
		TextField txtPassword = new TextField();
		txtPassword.setPrefWidth(300);
		titleGrid.add(lblPassword, 0, 2);
		titleGrid.add(txtPassword, 0, 3);

		Label lblLogin = new Label("");
		Button btnLogin = new Button("Login");
		Button btnRegister = new Button("Register");

		// Image imageRegister = new
		// Image(getClass().getResourceAsStream("add-user.png"));
		// btnSubmit.setGraphic(new ImageView(imageRegister));
		btnLogin.setId("btnRegister");
		btnRegister.setId("btnReset");

		HBox hbox2 = new HBox(20);
		hbox2.getChildren().addAll(btnLogin, btnRegister);
		titleGrid.add(lblLogin, 0, 4);
		titleGrid.add(hbox2, 0, 5);

		// Label lblSubmit = new Label("");
		// Button btnSubmit = new Button("Login");
		// titleGrid.add(lblSubmit, 0, 10);
		// titleGrid.add(btnSubmit, 0, 11);
		//
		// Label lblRegister = new Label("");
		// Button btnRegister = new Button("Register");
		// titleGrid.add(lblRegister, 1, 10);
		// titleGrid.add(btnRegister, 1, 11);

		// add all grid into main grid
		titleGrid.setAlignment(Pos.CENTER);
		titleGrid.setPadding(new Insets(10, 10, 10, 10));
		titleGrid.add(topGrid2, 0, 1);

		// make 2 scenes from 2 panes
		scene1 = new Scene(mainGrid, 550, 600);
		scene2 = new Scene(titleGrid, 550, 600);

		primaryStage.setScene(scene1);
		primaryStage.show();

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

				String query = "SELECT * FROM tblItems WHERE item_name='" + newValue + "'";

				try {
					Statement stmt = Connection.getConnection().createStatement();
					ResultSet rs = stmt.executeQuery(query);

					while (rs.next()) {
						name.setText("Name: " + rs.getString("item_name"));
						category.setText("Category: " + rs.getString("identifier"));
						price.setText("Price: $" + rs.getDouble("price"));
						desc.setText("Description: " + rs.getString("description"));
						Image image2 = new Image(
								ListItem2.class.getResourceAsStream("resource/" + rs.getString("image")), 200, 200,
								false, false);
						imv.setImage(image2);

						id = rs.getInt("iid");
						p = rs.getDouble("price");

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

		btnOrder.setOnAction(event -> {
			qty = Integer.valueOf((String) cboQty.getValue());
			getVariables(id, qty);
			System.out.println("food id: " + id + " quantity: " + qty);

			primaryStage.setScene(scene2);
		});

		// Login part
		btnRegister.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				Register reg = new Register();

				try {
					reg.start(Register.classStage);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		btnSearch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				sch = txtSearch.getText();
				System.out.println(sch);

				primaryStage.hide();
				SearchFoodFromCustomer dreg = new SearchFoodFromCustomer();

				try {
					dreg.start(SearchFoodFromCustomer.classStage);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		
		
		btnAdmin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				Login reg = new Login();

				try {
					reg.start(Login.loginStage);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				String enteredfname = txtEmail.getText();
				String enteredpw = txtPassword.getText();
				System.out.println(enteredfname);
				System.out.println(enteredpw);

				String email = "";
				String pw = "";
				String st = "1";

				String query = "select cid, email, password, access_level FROM tblperson";
				try {
					Statement stmt = Connection.getConnection().createStatement();
					ResultSet rs = stmt.executeQuery(query);

					while (rs.next()) {
						// Retrieve by column name
						email = rs.getString("email");
						pw = rs.getString("password");
						st = rs.getString("access_level");
						

						if (enteredfname.equals(email) && enteredpw.equals(pw) && st.equals("1")) {
							primaryStage.hide();
												
							
							//System.out.println(email);
							OrderCheckOut dreg = new OrderCheckOut();

							try {
								dreg.start(OrderCheckOut.classStage);

							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else if (enteredfname.equals(email) && enteredpw.equals(pw) && st.equals("2")) {
							primaryStage.hide();
							OrderCheckOut dreg = new OrderCheckOut();

							try {
								dreg.start(OrderCheckOut.classStage);

							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							Label lblEror1 = new Label("");
							titleGrid.add(lblEror1, 0, 9);
							Label lblEror = new Label("Password or Username is not matched");
							titleGrid.add(lblEror, 0, 10);

						}
						


						

						cid = rs.getInt("cid");
						
						String sql = "INSERT INTO tblOrder (order_status, qty, price, sid, iid) VALUES('New'," + qty+","+p+"," + cid+","+id+")";

						try {
							Statement s = Connection.getConnection().createStatement();
							s.executeUpdate(sql);



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
						
						System.out.println(id);
						System.out.println(cid);
						System.out.println(qty);
						System.out.println(p);
					}
					



					rs.close();

				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					//insert order into table

				}

				System.out.println();
				
				

			}
		});

	}

	public int getVariables(int variable, int qty) {
		return variable;
	}
	
	public static String halka() {
		// TODO Auto-generated method stub
		return sch;
	}
	

	private int variable;
	private int id;
	private int cid; 
	private int qty;
	private double p;


	@Override
	public void actionPerformed(java.awt.event.ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == btnOrder) {
			thestage.setScene(scene2);
			System.out.println("change scene");
		} else {
			thestage.setScene(scene1);
		}

	}
	

}
