package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class addGoodsController  implements Initializable{
    Stacks stack = new Stacks();

    @FXML
    private Button addGoodsButton;

    @FXML
    private TableColumn<?, ?> categoryColumn;

    @FXML
    private VBox vbox;

    @FXML
    private TextField categoryTextfield;

    @FXML
    private Button deleteGoodsButton;

    @FXML
    private Button enterButton;

    @FXML
    private Button issuedGoodsButton;

    @FXML
    private Button peekButton;

    @FXML
    private Label labelVbox;

    @FXML
    private Label userLabel;

    @FXML
    private Button logoutButton;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    private TextField priceTextField;

    @FXML
    private TableColumn<?, ?> prodIdColumn;

    @FXML
    private TableColumn<?, ?> prodNameColumn;

    @FXML
    private Button popButton;

    @FXML
    private TextField productIdTextField;

    @FXML
    private TextField productNameTextField;

    @FXML
    private TableView<?> productsTable;

    @FXML
    private TableColumn<?, ?> quantityColumn;

    @FXML
    private Button pushButton;

    @FXML
    private Button refreshButton;

    @FXML
    private RadioButton searchRadioBtn;

    @FXML
    private TextField stockQTextField;

    @FXML
    private TableColumn<?, ?> stockQuantityColumn;

    @FXML
    private Label title;

    @FXML
    private Button viewBillsButton;

    @FXML
    private Button viewGoodsButton;

    @FXML
    private Button viewIsGoodsButton;

    @FXML
    private Button viewIsGoodsButton1;

    @FXML
    void changeScreenButtonPressed(ActionEvent event) {

    }

    @FXML
    void enterButtonClicked(ActionEvent event) {

    }

    @FXML
    void onClickAddGoods(ActionEvent event) {

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
    void onClickViewGoods(ActionEvent event) {

    }

    @FXML
    void onClickViewIsGoods(ActionEvent event) {

    }

    @FXML
    void searchButtonSelected(ActionEvent event) {

    }

    @FXML
    void popButtonClicked(ActionEvent event) {
        if (!stack.isEmpty())
            stack.pop(productNameTextField.getText(), priceTextField.getText(), stockQTextField.getText(),
                    categoryTextfield.getText());
        show();

    }

    @FXML
    void pushButtonClicked(ActionEvent event) {
        stack.push(productNameTextField.getText(), priceTextField.getText(), stockQTextField.getText(),
                categoryTextfield.getText());
        productNameTextField.clear();
        priceTextField.clear();
        stockQTextField.clear();
        categoryTextfield.clear();
        show();

    }

    @FXML
    void peekButtonClicked(ActionEvent event) {

    }

    @FXML
    void refreshTable(ActionEvent event) {

    }

    @FXML
    void onTextfield(ActionEvent event) {

    }

    // show items in the textview
    private void show() {
        String temp = "";
        for (String s : stack.items) {
            temp += s + "\n";
        }
        labelVbox.setText(temp);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
    }

}
