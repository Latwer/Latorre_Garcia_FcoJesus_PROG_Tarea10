package mvc.vista.iugrafica.controladoresvista;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.DireccionPostal;

public class ControladorDatosCliente {

    @FXML
    private TextField tfNombre, tfDni, tfCalle, tfLocalidad, tfCodigoPostal;

    public Cliente getCliente() {
        DireccionPostal direccion = new DireccionPostal(tfCalle.getText(), tfLocalidad.getText(), tfCodigoPostal.getText());
        return new Cliente(tfNombre.getText(), tfDni.getText(), direccion);
    }

    public void setCliente(Cliente cliente) {
        if (cliente != null) {
            tfNombre.setText(cliente.getNombre());
            tfDni.setText(cliente.getDni());
            tfCalle.setText(cliente.getDireccionPostal().getCalle());
            tfLocalidad.setText(cliente.getDireccionPostal().getLocalidad());
            tfCodigoPostal.setText(cliente.getDireccionPostal().getCodigoPostal());
        } else {
            tfNombre.setText("");
            tfDni.setText("");
            tfCalle.setText("");
            tfLocalidad.setText("");
            tfCodigoPostal.setText("");
        }
    }

    public void inhabilitaEdicionCampos() {
        tfNombre.setDisable(true);
        tfDni.setDisable(true);
        tfCalle.setDisable(true);
        tfLocalidad.setDisable(true);
        tfCodigoPostal.setDisable(true);
    }

}
