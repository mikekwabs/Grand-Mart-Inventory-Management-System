
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class FxmlLoader {

    private AnchorPane view;

    public AnchorPane getPage(String filename) {
        try {
            URL fileUrl = App.class.getResource("./Views/" + filename + ".fxml");
            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("FXML file cannot be found");

            }
            new FXMLLoader();
            view = FXMLLoader.load(fileUrl);

        } catch (Exception e) {
            System.out.println("No view");

        }
        return view;
    }

}
