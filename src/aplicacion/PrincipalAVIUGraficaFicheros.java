package aplicacion;

import mvc.controlador.ControladorAlquilerVehiculos;
import mvc.controlador.IControladorAlquilerVehiculos;
import mvc.modelo.AlquilerVehiculos;
import mvc.modelo.IModeloAlquilerVehiculos;
import mvc.vista.iugrafica.IUGrafica;
import mvc.vista.IVistaAlquilerVehiculos;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class PrincipalAVIUGraficaFicheros {

    public static void main(String[] args) {
        IModeloAlquilerVehiculos modelo = new AlquilerVehiculos();
        IVistaAlquilerVehiculos vista = new IUGrafica();
        IControladorAlquilerVehiculos controlador = new ControladorAlquilerVehiculos(vista, modelo);

        controlador.comenzar();
    }
}

