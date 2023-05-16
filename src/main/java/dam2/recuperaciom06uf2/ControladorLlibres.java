package dam2.recuperaciom06uf2;

import Classes.Llibre;
import Conexio.SingleSession;
import java.io.IOException;
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

public class ControladorLlibres {

    @FXML
    private TableView<Llibre> taula;
    @FXML
    TableColumn<Llibre, Integer> id = new TableColumn<>("ID"), isbn, id_prestec;

    @FXML
    TableColumn<Llibre, String> titol, autor, editorial;

    private final ObservableList<Llibre> dadesTaula = FXCollections.observableArrayList();

    public void initialize() {

        id.setCellValueFactory(new PropertyValueFactory("id"));
        isbn.setCellValueFactory(new PropertyValueFactory("isbn"));
        titol.setCellValueFactory(new PropertyValueFactory("titol"));
        autor.setCellValueFactory(new PropertyValueFactory("autor"));
        editorial.setCellValueFactory(new PropertyValueFactory("editorial"));
        id_prestec.setCellValueFactory(new PropertyValueFactory("id_prestec"));


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
    private void modificar(Event event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Obtiene el Stage de la ventana actual
        currentStage.close(); // Oculta la ventana actual

        Stage newStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModificarLlibres.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 820, 500); // Establece las dimensiones deseadas
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    private void eliminar() throws IOException {

        Llibre llibre = this.taula.getSelectionModel().getSelectedItem();

        if (llibre == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Tents que seleccionar un Llibre");
            alert.showAndWait();
        } else {
            this.dadesTaula.remove(llibre);
            taula.refresh();

            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            Session session = null;
            Transaction transaction = null;

            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();

                // Supongamos que "TuEntidad" es el nombre de tu entidad y "id" es el identificador del registro que deseas eliminar
                llibre = session.get(Llibre.class, llibre.getId());

                session.delete(llibre);

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

        Query query = session.getSessio().createQuery("FROM Llibre");
        List<Llibre> llista = query.list();

        for (Llibre llibre : llista) {
            this.dadesTaula.add(llibre);
        }

        this.taula.setItems(dadesTaula);
    }
}
