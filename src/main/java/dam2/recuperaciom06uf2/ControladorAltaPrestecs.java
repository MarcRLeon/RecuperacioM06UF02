package dam2.recuperaciom06uf2;

import Classes.Prestec;
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

public class ControladorAltaPrestecs {

    @FXML
    TableView<Prestec> taula;

    @FXML
    TextField txt_idPrestec, txt_idUsuari, txt_dataDevolucio, txt_dataPrestec;

    @FXML
    TableColumn<Prestec, Integer> id_prestec, id_usuari;

    @FXML
    TableColumn<Prestec, Date> data_prestec, data_devolucio;

    private final ObservableList<Prestec> dadesTaula = FXCollections.observableArrayList();

    public void initialize() {
        id_prestec = new TableColumn<>("ID Prestec");
        data_devolucio = new TableColumn<>("Data Devolucio");
        data_prestec = new TableColumn<>("Data Prestec");
        id_usuari = new TableColumn<>("ID Usuari");

        id_prestec.setCellValueFactory(new PropertyValueFactory("id_prestec"));
        data_devolucio.setCellValueFactory(new PropertyValueFactory("data_devolucio"));
        data_prestec.setCellValueFactory(new PropertyValueFactory("data_prestec"));
        id_usuari.setCellValueFactory(new PropertyValueFactory("id_usuari"));

        taula.getColumns().addAll(id_prestec, data_devolucio, data_prestec, id_usuari);

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
    private void afegir() throws IOException {
        Faker faker = new Faker();
        Session session = SingleSession.getInstance().getSessio();

        session.beginTransaction();
        int id = Integer.parseInt(txt_idPrestec.getText()), id_usuari = Integer.parseInt(txt_idUsuari.getText());
        Prestec prestec = new Prestec(id, faker.date().birthday(), faker.date().birthday(), id_usuari);

        System.out.println(prestec.toString());
        session.save(prestec);
        session.getTransaction().commit();

        dadesTaula.clear();
        carregarDades();
        taula.refresh();
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
