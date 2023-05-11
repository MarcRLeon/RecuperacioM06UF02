package dam2.recuperaciom06uf2;

import Classes.Llibre;
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

public class ControladorLlibres {

    @FXML
    private TableView<Llibre> taula;
    @FXML
    private TableColumn<Llibre, String> colIsbn;
    @FXML
    private TableColumn<Llibre, String> colTitol;
    @FXML
    private TableColumn<Llibre, String> colAutor;
    @FXML
    private TableColumn<Llibre, String> colEditorial;
    @FXML
    private TableColumn<Llibre, Date> colDataPrestec;

    private ObservableList<Llibre> datosTabla;

    public void initialize(URL url, ResourceBundle rb) {
        // Configuración de las columnas
        colIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colTitol.setCellValueFactory(new PropertyValueFactory<>("titol"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colEditorial.setCellValueFactory(new PropertyValueFactory<>("editorial"));
        colDataPrestec.setCellValueFactory(new PropertyValueFactory<>("data_prestec"));

        // Carga de los datos en la tabla
        datosTabla = FXCollections.observableArrayList();
        taula.setItems(datosTabla);
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
}
