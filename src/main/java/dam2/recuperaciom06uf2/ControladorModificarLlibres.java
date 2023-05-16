package dam2.recuperaciom06uf2;

import Classes.Llibre;
import Classes.Usuari;
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
import javafx.scene.control.Alert;
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
        Llibre llibre = this.taula.getSelectionModel().getSelectedItem();
        if (llibre == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Tents que seleccionar un Llibre");
            alert.showAndWait();
        } else {

            int isbn = Integer.parseInt(txt_isbn.getText()), idPrestec = Integer.parseInt(txt_idPrestec.getText());
            Llibre llibre2 = new Llibre(isbn, txt_titol.getText(), txt_autor.getText(), txt_editorial.getText(), idPrestec);
            if (!this.dadesTaula.contains(llibre2)) {
                llibre.setIsbn(llibre2.getIsbn());
                llibre.setTitol(llibre2.getTitol());
                llibre.setAutor(llibre2.getAutor());
                llibre.setEditorial(llibre2.getEditorial());
                llibre.setId_prestec(llibre2.getId_prestec());
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

        Query query = session.getSessio().createQuery("FROM Llibre");
        List<Llibre> llista = query.list();

        for (Llibre llibre : llista) {
            this.dadesTaula.add(llibre);
        }

        this.taula.setItems(dadesTaula);
    }
}
