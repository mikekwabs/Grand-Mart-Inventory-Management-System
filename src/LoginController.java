
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;;

public class LoginController {
    Scene dashboard;

    @FXML
    private Button buttonLogin;

    @FXML
    private Text forgotPassword;

    @FXML
    private Label isConnected;

    @FXML
    private PasswordField textPassword;

    @FXML
    private TextField textUsername;

    // connection and Sql statement object.
    Connection connection;
    PreparedStatement pst;
    ResultSet queryResult;

    @FXML
    void login(ActionEvent event) {
        String username = textUsername.getText();
        String password = textPassword.getText();

        // Check if fields are empty
        if (username.equals("") && password.equals("")) {
            JOptionPane.showMessageDialog(null, "Username or Password cannot be empty.");
        } else {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/grandmart_db", "root", "");

                // sql query
                pst = connection.prepareStatement("select * from userauth where username = ? and password = ?");
                pst.setString(1, username);
                pst.setString(2, password);

                queryResult = pst.executeQuery();

                // if result is returned:

                if (queryResult.next()) {
                    JOptionPane.showMessageDialog(null, "Logged in successful.");
                    changeScreenButtonPressed(event);
                    connection.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Account does not exist.");

                    // Clear input fields
                    textUsername.setText("");
                    textPassword.setText("");

                    // return focus to input
                    textUsername.requestFocus();

                }

            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    // handle change of scenes
    public void changeScreenButtonPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("./Views/Dashboard.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        // Line to get the Stage information from main method
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setTitle("Dashboard");
        window.show();
    }

}
