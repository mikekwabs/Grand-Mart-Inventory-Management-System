import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import Models.Bill;

public class viewBillsController implements Initializable {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    private TableColumn<Bill, String> balanceColumn;

    @FXML
    private TableColumn<Bill, String> billedAmountColumn;

    @FXML
    private TableColumn<Bill, String> dueDateColumn;

    @FXML
    private TableColumn<Bill, String> inDateColumn;

    @FXML
    private TableColumn<Bill, String> invoiceNumberColumn;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TableColumn<Bill, String> prodNameColumn;

    @FXML
    private TableView<Bill> productsTable;

    @FXML
    private TableColumn<Bill, String> quantityColumn;

    @FXML
    private Button sortButon;

    // sort items

    @FXML
    void onClickSort(ActionEvent event) {

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
        invoiceNumberColumn.setCellValueFactory(new PropertyValueFactory<>("invoiceNumber"));
        prodNameColumn.setCellValueFactory(new PropertyValueFactory<>("prodName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        inDateColumn.setCellValueFactory(new PropertyValueFactory<>("invoiceDate"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        billedAmountColumn.setCellValueFactory(new PropertyValueFactory<>("billAmount"));
        balanceColumn.setCellValueFactory(new PropertyValueFactory<>("balance"));

    }

    // load data
    private void loadData() {
        ObservableList<Bill> tableData = FXCollections.observableArrayList();

        try {

            String sql = "SELECT * FROM `bills`";
            connection = DriverManager.getConnection("jdbc:mysql://localhost/grandmart_db", "root", "");
            pst = connection.prepareStatement(sql);

            // run query
            ResultSet results = pst.executeQuery();

            while (results.next()) {
                tableData.add(new Bill(results.getString(1), results.getString(2), results.getString(3),
                        results.getString(4), results.getString(5), results.getString(6), results.getString(7)));
            }
            productsTable.setItems(tableData);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
