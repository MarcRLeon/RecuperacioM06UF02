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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ControladorPrestec {

    @FXML
    TableView<Prestec> taula;

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
        currentStage.hide();

        Stage newStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DonarAltaPrestecs.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 800, 500);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    private void modificar(Event event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Obtiene el Stage de la ventana actual
        currentStage.close(); // Oculta la ventana actual

        Stage newStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModificarPrestecs.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 820, 500); // Establece las dimensiones deseadas
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    private void eliminar() throws IOException {
        Prestec p = this.taula.getSelectionModel().getSelectedItem();

        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Tents que seleccionar un Prestec");
            alert.showAndWait();
        } else {
            this.dadesTaula.remove(p);
            taula.refresh();

            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            Session session = null;
            Transaction transaction = null;

            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();

                // Supongamos que "TuEntidad" es el nombre de tu entidad y "id" es el identificador del registro que deseas eliminar
                p = session.get(Prestec.class, p.getId_prestec());

                session.delete(p);

                transaction.commit();
            } catch (HibernateException e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                if (session != null) {
                    session.close();
                }
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
