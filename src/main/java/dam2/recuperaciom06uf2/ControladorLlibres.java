package dam2.recuperaciom06uf2;

import Classes.Llibre;
import Conexio.SingleSession;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.query.Query;

public class ControladorLlibres {

    @FXML
    private TableView<Llibre> taula;
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
            currentStage.hide(); // Oculta la ventana actual

            Stage newStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Principal.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 550, 350); // Establece las dimensiones deseadas
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void afegir(Event event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Obtiene el Stage de la ventana actual
        currentStage.close(); // Oculta la ventana actual

        Stage newStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DonarAltaLlibres.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 820, 500); // Establece las dimensiones deseadas
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    private void modificar() throws IOException {
        System.out.println("Aquest metode encara no fa res");
    }

    @FXML
    private void eliminar() throws IOException {
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
