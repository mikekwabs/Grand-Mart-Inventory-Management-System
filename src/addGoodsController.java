import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Models.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class addGoodsController {
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    Stacks stack = new Stacks();

    @FXML
    private Button addButton;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Label inputLabel;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TextField inputTextField;

    @FXML
    private TextField prodIdTextField;

    @FXML
    private TextField prodNameTextFiield;

    @FXML
    private TextField quantityTextField;

    @FXML
    private Button removeButton;

    @FXML
    private TextField stockqTextfield;

    @FXML
    void onAdd(ActionEvent event) {
        stack.push(prodIdTextField.getText(), prodNameTextFiield.getText(), quantityTextField.getText(),
                stockqTextfield.getText());
        prodIdTextField.clear();
        prodNameTextFiield.clear();
        quantityTextField.clear();
        stockqTextfield.clear();
        show();

    }

    private void show() {
        String temp = "";
        for (String s : stack.items) {
            temp += s + "\n \n";
        }
        inputLabel.setText(temp);
    }

    @FXML
    void onCombo(ActionEvent event) {

    }

    @FXML
    void onRemove(ActionEvent event) {
        stack.pop(prodIdTextField.getText(), prodNameTextFiield.getText(), quantityTextField.getText(),
                stockqTextfield.getText());
        prodIdTextField.clear();
        prodNameTextFiield.clear();
        quantityTextField.clear();
        stockqTextfield.clear();
        show();
    }

}
