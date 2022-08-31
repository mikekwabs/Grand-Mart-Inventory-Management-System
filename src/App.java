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
        primaryStage.setTitle("Login");
        Scene scene = new Scene(myPane, 450, 476);
        scene.setRoot(myPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}