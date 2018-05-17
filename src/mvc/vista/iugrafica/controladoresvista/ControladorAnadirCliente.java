package mvc.vista.iugrafica.controladoresvista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.vista.iugrafica.IUGrafica;
import mvc.vista.iugrafica.utilidades.Dialogos;

public class ControladorAnadirCliente {

    private ControladorDatosCliente datosCliente;

    public void setDatosCliente(ControladorDatosCliente datosCliente) {
        this.datosCliente = datosCliente;
    }

    @FXML
    private Button btAnadir, btCancelar;

    @FXML
    private void anadirCliente() {
        Cliente cliente = null;
        try {
            cliente = datosCliente.getCliente();
            if (IUGrafica.controladorMVC.buscarCliente(cliente.getDni()) == null) {
                IUGrafica.controladorMVC.anadirCliente(cliente);
                Stage propietario = ((Stage) btAnadir.getScene().getWindow());
                Dialogos.mostrarDialogoInformacion("Añadir Cliente", "Cliente añadido satisfactoriamente", propietario);
            } else {
                Dialogos.mostrarDialogoError("Añadir cliente", "Ya existe un cliente con ese DNI");
            }
        } catch (ExcepcionAlquilerVehiculos e) {
            Dialogos.mostrarDialogoError("Añadir cliente", e.getMessage());
        }
    }

    @FXML
    private void cancelar() {
        ((Stage) btCancelar.getScene().getWindow()).close();
    }

}
