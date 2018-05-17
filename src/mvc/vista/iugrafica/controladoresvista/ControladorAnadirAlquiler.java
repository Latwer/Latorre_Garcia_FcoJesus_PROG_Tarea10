package mvc.vista.iugrafica.controladoresvista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.vehiculo.Vehiculo;
import mvc.vista.iugrafica.IUGrafica;
import mvc.vista.iugrafica.utilidades.Dialogos;

public class ControladorAnadirAlquiler {

    private Vehiculo vehiculo;
    private Cliente cliente;

    public void setAlquiler(Cliente cliente, Vehiculo vehiculo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        tfDni.setText(cliente.getDni());
        tfMatricula.setText(vehiculo.getMatricula());
    }

    @FXML
    private TextField tfDni, tfMatricula;

    @FXML
    private Button btAnadir, btCancelar;

    @FXML
    private void cancelar() {
        ((Stage) btCancelar.getScene().getWindow()).close();
    }

    @FXML
    private void crearAlquiler() {
        Stage propietario = ((Stage) btAnadir.getScene().getWindow());
        try {
            IUGrafica.controladorMVC.abrirAlquiler(cliente, vehiculo);
            Dialogos.mostrarDialogoInformacion("Crear alquiler", "Alquiler creado satisfactoriamente", propietario);
        } catch (ExcepcionAlquilerVehiculos e) {
            Dialogos.mostrarDialogoError("Crear alquiler", e.getMessage(), propietario);
        }
    }

}
