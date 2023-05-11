package dam2.recuperaciom06uf2;

import Classes.Prestec;
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

public class ControladorAltaPrestecs {

    @FXML
    TableView<Prestec> taula;

    @FXML
    TextField txt_idUsuari, txt_dataDevolucio, txt_dataPrestec;
    
    

    @FXML
    private void tornarEnrere(Event event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Obtiene el Stage de la ventana actual
            currentStage.close(); // Oculta la ventana actual

            Stage newStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaPrestec.fxml"));
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

        session.beginTransaction();
        int id = Integer.parseInt(txt_idUsuari.getText());
        Prestec prestec = new Prestec(faker.date().birthday(), faker.date().birthday(), id);

        session.save(prestec);

        session.getTransaction().commit();
    }

}
