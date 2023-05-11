package dam2.recuperaciom06uf2;

import Classes.Usuari;
import Conexio.SingleSession;
import com.github.javafaker.Faker;
import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;

public class ControladorAltaUsuari {

    @FXML
    TableView<Usuari> taula;

    @FXML
    TextField txt_id, txt_nom, txt_direccio, txt_telefon, txt_dataPrestec;

    @FXML
    private void tornarEnrere(Event event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Obtiene el Stage de la ventana actual
            currentStage.hide(); // Oculta la ventana actual

            Stage newStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaUsuaris.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 700, 500); // Establece las dimensiones deseadas
            newStage.setScene(scene);
            newStage.setResizable(false);
            newStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void afegir() throws IOException {
        Faker faker = new Faker();
        Session session = SingleSession.getInstance().getSessio();
        int id = Integer.parseInt(txt_id.getText()), telefon = Integer.parseInt(txt_telefon.getText());
        session.beginTransaction();

        Usuari usuari = new Usuari(id, txt_nom.getText(), txt_direccio.getText(), telefon,
                faker.date().birthday());

        session.save(usuari);

        session.getTransaction().commit();
    }

}
