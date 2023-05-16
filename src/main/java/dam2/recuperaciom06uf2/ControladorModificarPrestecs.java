package dam2.recuperaciom06uf2;

import Classes.Llibre;
import Classes.Prestec;
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
import org.hibernate.query.Query;

public class ControladorModificarPrestecs {

    @FXML
    TableView<Prestec> taula;

    @FXML
    TextField txt_idPrestec, txt_idUsuari, txt_dataDevolucio, txt_dataPrestec;

    @FXML
    TableColumn<Prestec, Integer> id_prestec = new TableColumn<>("ID Prestec"), id_usuari;

    @FXML
    TableColumn<Prestec, Date> data_prestec, data_devolucio;

    private final ObservableList<Prestec> dadesTaula = FXCollections.observableArrayList();

    public void initialize() {

        id_prestec.setCellValueFactory(new PropertyValueFactory("id_prestec"));
        data_devolucio.setCellValueFactory(new PropertyValueFactory("data_devolucio"));
        data_prestec.setCellValueFactory(new PropertyValueFactory("data_prestec"));
        id_usuari.setCellValueFactory(new PropertyValueFactory("id_usuari"));

        carregarDades();
    }

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
    private void modificar() throws IOException {
        SingleSession sessio = new SingleSession();

        Prestec p1 = this.taula.getSelectionModel().getSelectedItem();
        if (p1 == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Tents que seleccionar un Llibre");
            alert.showAndWait();
        } else {

            Date data_prestec = Date.valueOf(txt_dataPrestec.getText()), data_devolucio = Date.valueOf(txt_dataDevolucio.getText());
            int idUsuari = Integer.parseInt(txt_idUsuari.getText());
            Prestec p2 = new Prestec(data_prestec, data_devolucio, idUsuari);
            if (!this.dadesTaula.contains(p2)) {
                p1.setData_prestec(p2.getData_prestec());
                p1.setData_devolucio(p2.getData_devolucio());
                p1.setId_usuari(p2.getId_usuari());

                sessio.getSessio().beginTransaction();

                sessio.getSessio().update(p1);
                sessio.getSessio().getTransaction().commit();
                this.taula.refresh();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El llibre ja existeix");
                alert.showAndWait();
            }
        }
    }

    public void carregarDades() {
        SingleSession session = new SingleSession();

        Query query = session.getSessio().createQuery("FROM Prestec");
        List<Prestec> llista = query.list();

        for (Prestec prestec : llista) {
            this.dadesTaula.add(prestec);
        }

        this.taula.setItems(dadesTaula);
    }

}
