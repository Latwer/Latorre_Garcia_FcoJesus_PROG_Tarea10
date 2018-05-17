package aplicacion;

import mvc.controlador.ControladorAlquilerVehiculos;
import mvc.controlador.IControladorAlquilerVehiculos;
import mvc.modelo.ficheros.ModeloFicherosAlquilerVehiculos;
import mvc.modelo.IModeloAlquilerVehiculos;
import mvc.vista.iutextual.IUTextual;
import mvc.vista.IVistaAlquilerVehiculos;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class PrincipalAVIUTextualFicheros {

    public static void main(String[] args) {
        IModeloAlquilerVehiculos modelo = new ModeloFicherosAlquilerVehiculos();
        IVistaAlquilerVehiculos vista = new IUTextual();
        IControladorAlquilerVehiculos controlador = new ControladorAlquilerVehiculos(vista, modelo);

        controlador.comenzar();
    }
}
