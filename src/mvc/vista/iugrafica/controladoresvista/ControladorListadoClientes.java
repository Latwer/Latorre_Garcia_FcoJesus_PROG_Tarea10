package mvc.vista.iugrafica.controladoresvista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.DireccionPostal;
import mvc.vista.iugrafica.IUGrafica;

public class ControladorListadoClientes {

    @FXML
    private ListView<String> lvClientes;

    @FXML
    private Label lbTitulo;

    @FXML
    private void initialize() {
        actualizaClientes();
    }

    public void actualizaClientes() {
        ObservableList<String> clientes = FXCollections.observableArrayList();
        for (Cliente cliente : IUGrafica.controladorMVC.obtenerClientes()) {
            DireccionPostal direccion = cliente.getDireccionPostal();
            String clienteStr = String.format(
                    "Nombre: %s\tDNI: %s\tCalle: %s\tLocalidad: %s\tCódigo Postal:%s",
                    cliente.getNombre(), cliente.getDni(),
                    direccion.getCalle(), direccion.getLocalidad(), direccion.getCodigoPostal());
            clientes.add(clienteStr);
        }
        lvClientes.setItems(clientes);
    }

}
