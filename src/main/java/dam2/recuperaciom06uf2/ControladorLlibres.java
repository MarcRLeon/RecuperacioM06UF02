package dam2.recuperaciom06uf2;

import java.io.IOException;
import javafx.fxml.FXML;

public class ControladorLlibres {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}