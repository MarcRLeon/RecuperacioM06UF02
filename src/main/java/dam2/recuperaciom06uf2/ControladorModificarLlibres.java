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

public class ControladorModificarLlibres {

    @FXML
    TableView<Llibre> taula;

    @FXML
    TextField txt_isbn, txt_titol, txt_autor, txt_editorial, txt_idPrestec;

    @FXML
    TableColumn<Llibre, Integer> id, isbn, id_prestec;

    @FXML
    TableColumn<Llibre, String> titol, autor, editorial;

    private final ObservableList<Llibre> dadesTaula = FXCollections.observableArrayList();

    public void initialize() {
        id = new TableColumn<>("ID");
        isbn = new TableColumn<>("ISBN");
        titol = new TableColumn<>("Titol");
        autor = new TableColumn<>("Autor");
        editorial = new TableColumn<>("Editorial");
        id_prestec = new TableColumn<>("ID Prestec");

        id.setCellValueFactory(new PropertyValueFactory("id"));
        isbn.setCellValueFactory(new PropertyValueFactory("isbn"));
        titol.setCellValueFactory(new PropertyValueFactory("titol"));
        autor.setCellValueFactory(new PropertyValueFactory("autor"));
        editorial.setCellValueFactory(new PropertyValueFactory("editorial"));
        id_prestec.setCellValueFactory(new PropertyValueFactory("id_prestec"));

        taula.getColumns().addAll(id, isbn, titol, autor, editorial, id_prestec);

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
    private void modificar() throws IOException {
        System.out.println("Aquest metode encara no fa res");

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
