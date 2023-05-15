package dam2.recuperaciom06uf2;

import Classes.Llibre;
import Conexio.SingleSession;
import com.github.javafaker.Faker;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ControladorAltaLlibres {

    @FXML
    TableView<Llibre> taula;

    @FXML
    TextField txt_isbn, txt_titol, txt_autor, txt_editorial, txt_dataPrestec;

    @FXML
    TableColumn<Llibre, Integer> isbn;

    @FXML
    TableColumn<Llibre, String> titol, autor, editorial;

    @FXML
    TableColumn<Llibre, Date> data_prestec;

    private final ObservableList<Llibre> dadesTaula = FXCollections.observableArrayList();

    public void initialize() {
        isbn = new TableColumn<>("ISBN");
        titol = new TableColumn<>("Titol");
        autor = new TableColumn<>("Autor");
        editorial = new TableColumn<>("Editorial");
        data_prestec = new TableColumn<>("Data Prestec");

        isbn.setCellValueFactory(new PropertyValueFactory("isbn"));
        titol.setCellValueFactory(new PropertyValueFactory("titol"));
        autor.setCellValueFactory(new PropertyValueFactory("autor"));
        editorial.setCellValueFactory(new PropertyValueFactory("editorial"));
        data_prestec.setCellValueFactory(new PropertyValueFactory("data_prestec"));

        taula.getColumns().addAll(isbn, titol, autor, editorial, data_prestec);

        carregarDades();
    }

    @FXML
    private void tornarEnrere(Event event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Obtiene el Stage de la ventana actual
            currentStage.close(); // Oculta la ventana actual

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

        session.beginTransaction();

        Llibre llibre = new Llibre(txt_isbn.getText(), txt_titol.getText(), txt_autor.getText(), txt_editorial.getText(),
                faker.date().birthday());

        session.save(llibre);

        session.getTransaction().commit();

    }

    public void carregarDades() {
        SingleSession session = new SingleSession();

        Query query = session.getSessio().createQuery("FROM Llibre");
        List<Llibre> llista = query.list();

        for (Llibre llibre : llista) {
            this.dadesTaula.add(llibre);
        }

        this.taula.setItems(dadesTaula);
    }
}
