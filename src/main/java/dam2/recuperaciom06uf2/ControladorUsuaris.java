package dam2.recuperaciom06uf2;

import java.io.IOException;
import javafx.fxml.FXML;

public class ControladorUsuaris {

    @FXML
    private void tornarEnrere() {
        try {
            App.setRoot("Principal");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void afegir() throws IOException {
        System.out.println("Aquest metode encara no fa res");
    }

    @FXML
    private void modificar() throws IOException {
        System.out.println("Aquest metode encara no fa res");
    }

    @FXML
    private void eliminar() throws IOException {
        System.out.println("Aquest metode encara no fa res");
    }
}
