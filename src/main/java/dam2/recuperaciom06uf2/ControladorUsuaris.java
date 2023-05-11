package dam2.recuperaciom06uf2;

import Classes.Usuari;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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

public class ControladorUsuaris {

    @FXML
    TableView<Usuari> taula;

    @FXML
    private TableColumn<Usuari, String> id, nom, direccio;

    @FXML
    private TableColumn<Usuari, Integer> telefon;

    @FXML
    private TableColumn<Usuari, Date> data_prestec;

    private ObservableList<Usuari> dadesTaula;

    
    public void intializable(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        direccio.setCellValueFactory(new PropertyValueFactory<>("direccio"));
        telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        data_prestec.setCellValueFactory(new PropertyValueFactory<>("data_prestec"));

        dadesTaula = FXCollections.observableArrayList();
        taula.setItems(dadesTaula);
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
}
