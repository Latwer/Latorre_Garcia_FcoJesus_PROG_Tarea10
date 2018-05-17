package mvc.vista.iugrafica.controladoresvista;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mvc.modelo.dominio.Cliente;
import mvc.vista.iugrafica.IUGrafica;
import mvc.vista.iugrafica.utilidades.Dialogos;

public class ControladorMostrarCliente {

    private Cliente cliente;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @FXML
    private Button btBorrar, btCancelar;

    @FXML
    private void borrarCliente() {
        IUGrafica.controladorMVC.borrarCliente(cliente.getDni());
        Stage propietario = (Stage) btBorrar.getScene().getWindow();
        Dialogos.mostrarDialogoInformacion("Borrar Cliente", "Cliente borrado satisfactoriamente", propietario);
    }

    @FXML
    private void cancelar() {
        ((Stage) btCancelar.getScene().getWindow()).close();
    }

}
