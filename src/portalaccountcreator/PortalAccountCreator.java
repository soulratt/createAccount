package portalaccountcreator;


import java.net.URL;
import javafx.application.Application;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import static javafx.scene.input.KeyCode.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class PortalAccountCreator extends Application {
    
    @Override
  public void start(Stage stage) throws Exception {
    try {
        URL resource = getClass().getResource("/portalaccountcreator/FXMLDocument.fxml");
        System.out.println("obtener ruta:   " + resource); // Imprimir la ruta para depuración

        if (resource == null) {
            System.err.println("No se pudo encontrar el archivo FXML.");
            return; // Salir si el recurso no se encuentra
        }

        FXMLLoader loader = new FXMLLoader(resource); // Pasar la URL al FXMLLoader

        Parent root = loader.load();

        FXMLDocumentController controller = loader.getController();

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == Y && event.isControlDown())
                    controller.setOptionsTrue();
            }
        });
        stage.setTitle("Agfa HealthCare - Portal de pacientes - Gestión de acceso de pacientes - v2.0");

        stage.setScene(scene);
        stage.show();
    } catch (Exception e) {
        System.err.println("Error al cargar FXML: " + e.getMessage());
        e.printStackTrace();
    }
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
