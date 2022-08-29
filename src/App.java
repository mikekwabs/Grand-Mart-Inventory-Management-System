import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//main method
public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./Views/Login.fxml"));
        AnchorPane myPane = loader.load();

        // set stage
        primaryStage.setTitle("Welcome to Grand Mart Inventory Management System");
        primaryStage.setScene(new Scene(myPane, 1004, 646));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}