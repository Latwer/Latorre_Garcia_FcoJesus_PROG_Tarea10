package mvc.vista.iugrafica.controladoresvista;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.vista.iugrafica.IUGrafica;
import mvc.vista.iugrafica.utilidades.Dialogos;

public class ControladorMostrarAlquiler {

    private Cliente cliente;
    private Alquiler alquiler;
    private List<Alquiler> alquileresCliente;

    @FXML
    private TextField tfDniCliente, tfMatricula, tfFecha, tfDias, tfPrecio, tfPrecioFijo;

    @FXML
    private Button btCerrar;

    @FXML
    private void initialize() {

    }

    @FXML
    private void cerrarAlquiler() {
        IUGrafica.controladorMVC.cerrarAlquiler(alquiler.getCliente(), alquiler.getVehiculo());
        Stage propietario = (Stage) btCerrar.getScene().getWindow();
        Dialogos.mostrarDialogoInformacion("Cerrar Alquiler", "Alquiler cerrado satisfactoriamente", propietario);
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
        actualizaAlquiler();
    }

    public void setAlquileresCliente(List<Alquiler> alquileresCliente) {
        this.alquileresCliente = alquileresCliente;
        actualizaAlquiler();
    }

    private void actualizaAlquiler() {
        if (alquiler != null) {
            tfDniCliente.setText(alquiler.getCliente().getDni());
            tfMatricula.setText(alquiler.getVehiculo().getMatricula());
            tfFecha.setText(alquiler.getFecha().toString());
            tfDias.setText("" + alquiler.getDias());
            tfPrecio.setText("" + alquiler.getPrecio());
            tfPrecioFijo.setText("" + alquiler.getPrecioFijo());
        } else {
            tfDniCliente.setText("");
            tfMatricula.setText("");
            tfFecha.setText("");
            tfDias.setText("");
            tfPrecio.setText("");
            tfPrecioFijo.setText("");
        }
    }

    public void inhabilitaEdicionCampos() {
        tfDniCliente.setDisable(true);
        tfMatricula.setDisable(true);
        tfFecha.setDisable(true);
        tfDias.setDisable(true);
        tfPrecio.setDisable(true);
        tfPrecioFijo.setDisable(true);
    }
}
