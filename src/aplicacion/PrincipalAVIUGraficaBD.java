package aplicacion;

import mvc.controlador.ControladorAlquilerVehiculos;
import mvc.controlador.IControladorAlquilerVehiculos;
import mvc.modelo.bd.ModeloBDAlquilerVehiculos;
import mvc.modelo.IModeloAlquilerVehiculos;
import mvc.vista.iugrafica.IUGrafica;
import mvc.vista.IVistaAlquilerVehiculos;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class PrincipalAVIUGraficaBD {

    public static void main(String[] args) {
        IModeloAlquilerVehiculos modelo = new ModeloBDAlquilerVehiculos();
        IVistaAlquilerVehiculos vista = new IUGrafica();
        IControladorAlquilerVehiculos controlador = new ControladorAlquilerVehiculos(vista, modelo);

        controlador.comenzar();
    }
}
