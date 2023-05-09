package dam2.recuperaciom06uf2;

import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorUsuaris {

    @FXML
    private void tornarEnrere(Event event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Obtiene el Stage de la ventana actual
            currentStage.hide();

            Stage newStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Principal.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 550, 350);
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void afegir(Event event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Obtiene el Stage de la ventana actual
        currentStage.hide();

        Stage newStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DonarAltaUsuari.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 800, 500);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    private void modificar(Event event) throws IOException {
        System.out.println("Aquest metode encara no fa res");
    }

    @FXML
    private void eliminar(Event event) throws IOException {
        System.out.println("Aquest metode encara no fa res");
    }
}
