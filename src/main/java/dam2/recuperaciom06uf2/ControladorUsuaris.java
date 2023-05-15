package dam2.recuperaciom06uf2;

import Classes.Usuari;
import Conexio.SingleSession;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.query.Query;

public class ControladorUsuaris {

    @FXML
    TableView<Usuari> taula;

    @FXML
    TableColumn<Usuari, Integer> id;

    @FXML
    TableColumn<Usuari, String> nom, direccio;

    @FXML
    TableColumn<Usuari, Integer> telefon;

    @FXML
    TableColumn<Usuari, Date> data_prestec;

    private final ObservableList<Usuari> dadesTaula = FXCollections.observableArrayList();

    public void initialize() {
        id = new TableColumn<>("ID");
        nom = new TableColumn<>("nom");
        direccio = new TableColumn<>("direccio");
        telefon = new TableColumn<>("telefon");
        data_prestec = new TableColumn<>("Data Prestec");

        id.setCellValueFactory(new PropertyValueFactory("ID"));
        nom.setCellValueFactory(new PropertyValueFactory("nom"));
        direccio.setCellValueFactory(new PropertyValueFactory("direccio"));
        telefon.setCellValueFactory(new PropertyValueFactory("telefon"));
        data_prestec.setCellValueFactory(new PropertyValueFactory("data_prestec"));

        taula.getColumns().addAll(id, nom, direccio, telefon, data_prestec);

        carregarDades();
    }

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

    public void carregarDades() {
        SingleSession session = new SingleSession();

        Query query = session.getSessio().createQuery("FROM Usuari");
        List<Usuari> llista = query.list();

        for (Usuari usuari : llista) {
            this.dadesTaula.add(usuari);
        }

        this.taula.setItems(dadesTaula);
    }
}
