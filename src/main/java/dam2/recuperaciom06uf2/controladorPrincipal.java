package dam2.recuperaciom06uf2;

import java.io.IOException;
import javafx.fxml.FXML;

public class controladorPrincipal {

    @FXML
    private void usuaris() {
        try {
            App.setRoot("PantallaUsuaris");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void prestec() {
        try {
            App.setRoot("PantallaPrestec");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void llibres() {
        try {
            App.setRoot("PantallaLlibres");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
