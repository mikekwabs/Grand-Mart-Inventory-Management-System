import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class viewVendorsController {

    @FXML
    private TableColumn<?, ?> addressColumn;

    @FXML
    private TableColumn<?, ?> cNameColumn;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TableColumn<?, ?> phoneColumn;

    @FXML
    private TableView<?> productsTable;

    @FXML
    private TableColumn<?, ?> vendorIdColumn;

    @FXML
    private TableColumn<?, ?> vendorNameColumn;

}
