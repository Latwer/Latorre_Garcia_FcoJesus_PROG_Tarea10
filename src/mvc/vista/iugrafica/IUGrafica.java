package mvc.vista.iugrafica;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mvc.controlador.IControladorAlquilerVehiculos;
import mvc.vista.IVistaAlquilerVehiculos;
import mvc.vista.iugrafica.utilidades.Dialogos;

/**
 *
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class IUGrafica extends Application implements IVistaAlquilerVehiculos {

    public static IControladorAlquilerVehiculos controladorMVC;

    @Override
    public void start(Stage escenarioPrincipal) {
        try {
            HBox raiz = (HBox) FXMLLoader.load(
                    getClass().getResource("/mvc/vista/iugrafica/vistas/VentanaPrincipal.fxml"));
            Scene escena = new Scene(raiz);
            escenarioPrincipal.setOnCloseRequest(e -> confirmarSalida(escenarioPrincipal, e));
            escenarioPrincipal.setTitle("Alquiler de Vehiculos");
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.setResizable(false);
            escenarioPrincipal.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void confirmarSalida(Stage escenarioPrincipal, WindowEvent e) {
        if (Dialogos.mostrarDialogoConfirmacion("Salir", "¿Estás deguro de que quieres salir de la aplicación?", escenarioPrincipal)) {
            controladorMVC.salir();
            escenarioPrincipal.close();
        } else {
            e.consume();
        }

    }

    @Override
    public void setControlador(IControladorAlquilerVehiculos controlador) {
        IUGrafica.controladorMVC = controlador;
    }

    public IControladorAlquilerVehiculos getControladorMVC() {
        return controladorMVC;
    }

    @Override
    public void comenzar() {
        launch(this.getClass());
    }

}
