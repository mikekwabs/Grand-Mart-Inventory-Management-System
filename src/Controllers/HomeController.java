package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Models.Products;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;

public class HomeController implements Initializable {
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    private Button addGoodsButton;

    @FXML
    private RadioButton addRadioBtn;

    @FXML
    private TableColumn<Products, String> categoryColumn;

    @FXML
    private TextField categoryTextfield;

    @FXML
    private Button deleteGoodsButton;

    @FXML
    private RadioButton deleteRadioBtn;

    @FXML
    private Button enterButton;

    @FXML
    private Button issuedGoodsButton;

    @FXML
    private Button logoutButton;

    @FXML
    private VBox vbox;

    @FXML
    private TextArea textArea;

    @FXML
    private TableColumn<Products, String> columnPrice;

    @FXML
    private TextField priceTextField;

    @FXML
    private TableColumn<Products, String> prodIdColumn;

    @FXML
    private TableColumn<Products, String> prodNameColumn;

    @FXML
    private TextField productIdTextField;

    @FXML
    private TextField productNameTextField;

    @FXML
    private TableView<Products> productsTable;

    @FXML
    private Button refreshButton;

    @FXML
    private TextField stockQTextField;

    // handle search
    @FXML
    void searchButtonSelected(ActionEvent event) {

    }

    // handle delete
    @FXML
    void deleteButtonSelected(ActionEvent event) {

    }

    // @FXML
    // private TableColumn<?, ?> stockQuantityColumn;

    @FXML
    private TableColumn<Products, String> quantityColumn;

    @FXML
    private Label title;

    @FXML
    private Label userLabel;

    @FXML
    private Button viewBillsButton;

    @FXML
    private Button viewGoodsButton;

    @FXML
    private Button viewIsGoodsButton;

    @FXML
    void enterButtonClicked(ActionEvent event) {

    }

    @FXML
    void onClickAddGoods(ActionEvent event) throws IOException {
        changeScreenToGoods(event);
    }

    private void changeScreenToGoods(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../Views/addGoods.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        // Line to get the Stage information from main method
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setTitle("Dashboard");
        window.show();
    }

    @FXML
    void onClickDeleteGoods(ActionEvent event) {

    }

    @FXML
    void onClickIsGoods(ActionEvent event) {

    }

    @FXML
    void onClickViewBills(ActionEvent event) {

    }

    @FXML
    void onClickViewGoods(ActionEvent event) throws IOException {
        changeToViewGoods(event);

    }

    // handle back to view
    private void changeToViewGoods(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../Views/Dashboard.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        // Line to get the Stage information from main method
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setTitle("Dashboard");
        window.show();
    }

    @FXML
    void onClickViewIsGoods(ActionEvent event) {

    }

    @FXML
    void radioButtonSelected(ActionEvent event) {

    }

    @FXML
    void refreshTable(ActionEvent event) {

    }



    // Handle navigation
    public void changeScreenButtonPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../Views/Login.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        // Line to get the Stage information from main method
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setTitle("Dashboard");
        window.show();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        loadData();

    }

    private void initTable() {
        initCols();
    }

    private void initCols() {
        prodIdColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
        prodNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("Category"));

    }

    // load data
    private void loadData() {
        ObservableList<Products> tableData = FXCollections.observableArrayList();

        try {

            String sql = "SELECT * FROM `products`";
            connection = DriverManager.getConnection("jdbc:mysql://localhost/grandmart_db", "root", "");
            pst = connection.prepareStatement(sql);

            // run query
            ResultSet results = pst.executeQuery();

            while (results.next()) {
                tableData.add(new Products(results.getString(1), results.getString(2), results.getString(3),
                        results.getString(4), results.getString(5)));
            }
            productsTable.setItems(tableData);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
