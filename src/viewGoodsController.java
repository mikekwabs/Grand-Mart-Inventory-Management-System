import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Models.Products;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class viewGoodsController implements Initializable {
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    private TableColumn<Products, String> categoryColumn;

    @FXML
    private TableColumn<Products, String> columnPrice;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TableColumn<Products, String> prodIdColumn;

    @FXML
    private TableColumn<Products, String> prodNameColumn;

    @FXML
    private TableView<Products> productsTable;

    @FXML
    private TableColumn<Products, String> quantityColumn;

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
