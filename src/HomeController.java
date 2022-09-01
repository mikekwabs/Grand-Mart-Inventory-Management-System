
import java.io.IOException;

import Models.Products;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;

public class HomeController {

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
    private AnchorPane mainAnchor;

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
    private BorderPane borderNav;

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
    void onClickAddGoods(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        AnchorPane view = object.getPage("addGoods");
        borderNav.setRight(view);

        // changeScreenToGoods(event);
    }

    @FXML
    void onClickDeleteGoods(ActionEvent event) {

    }

    @FXML
    void onClickIsGoods(ActionEvent event) {

    }

    @FXML
    void onClickViewBills(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        AnchorPane view = object.getPage("viewBills");
        borderNav.setRight(view);

    }

    @FXML
    void onClickViewGoods(ActionEvent event) throws IOException {
        FxmlLoader object = new FxmlLoader();
        AnchorPane view = object.getPage("viewGoods");
        borderNav.setRight(view);

    }

    @FXML
    void onClickViewIsGoods(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        AnchorPane view = object.getPage("viewVendors");
        borderNav.setRight(view);

    }

}
