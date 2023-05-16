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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ControladorModificarUsuari {

    @FXML
    TableView<Usuari> taula;

    @FXML
    TableColumn<Usuari, Integer> id = new TableColumn<>("ID");

    @FXML
    TableColumn<Usuari, String> nom, direccio;

    @FXML
    TableColumn<Usuari, Integer> telefon;

    @FXML
    TableColumn<Usuari, Date> data_prestec;

    private final ObservableList<Usuari> dadesTaula = FXCollections.observableArrayList();

    @FXML
    TextField txt_nom, txt_direccio, txt_telefon, txt_dataPrestec;

    public void initialize() {

        id.setCellValueFactory(new PropertyValueFactory("ID"));
        nom.setCellValueFactory(new PropertyValueFactory("nom"));
        direccio.setCellValueFactory(new PropertyValueFactory("direccio"));
        telefon.setCellValueFactory(new PropertyValueFactory("telefon"));
        data_prestec.setCellValueFactory(new PropertyValueFactory("data_prestec"));

        carregarDades();
    }

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
    private void modificar() throws IOException {
        SingleSession sessio = new SingleSession();
        Usuari u = this.taula.getSelectionModel().getSelectedItem();
        if (u == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Tents que seleccionar un Usuari");
            alert.showAndWait();
        } else {
            Date data = Date.valueOf(txt_dataPrestec.getText());
            int telefon = Integer.parseInt(txt_telefon.getText());

            Usuari usuari = new Usuari(txt_nom.getText(), txt_direccio.getText(), telefon, data);
            if (!this.dadesTaula.contains(usuari)) {
                u.setNom(usuari.getNom());
                u.setDireccio(usuari.getDireccio());
                u.setTelefon(usuari.getTelefon());
                u.setData_prestec(usuari.getData_prestec());

                sessio.getSessio().beginTransaction();

                sessio.getSessio().update(u);
                sessio.getSessio().getTransaction().commit();
                this.taula.refresh();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("L'usuari ja existeix");
                alert.showAndWait();
            }
        }
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
