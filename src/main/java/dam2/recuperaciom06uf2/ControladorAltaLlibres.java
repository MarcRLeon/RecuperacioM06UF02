package dam2.recuperaciom06uf2;

import Classes.Llibre;
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

public class ControladorAltaLlibres {

    @FXML
    TableView<Llibre> taula;

    @FXML
    TextField txt_isbn, txt_titol, txt_autor, txt_editorial, txt_dataPrestec;

    @FXML
    private void tornarEnrere(Event event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Obtiene el Stage de la ventana actual
            currentStage.hide(); // Oculta la ventana actual

            Stage newStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaLlibres.fxml"));
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
        System.out.println(session.beginTransaction());

        for (int i = 0; i < 1000; i++) {

            Llibre llibre = new Llibre(faker.book().genre(), faker.book().title(), faker.book().author(), faker.book().publisher(),
                    faker.date().birthday());

            session.persist(llibre);
        }

        session.getTransaction().commit();

    }
}
