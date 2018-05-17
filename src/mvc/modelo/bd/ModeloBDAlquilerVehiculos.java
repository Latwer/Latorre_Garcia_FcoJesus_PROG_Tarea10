package mvc.modelo.bd;

import java.util.List;
import mvc.modelo.IModeloAlquilerVehiculos;
import mvc.modelo.bd.dao.Alquileres;
import mvc.modelo.bd.dao.Clientes;
import mvc.modelo.bd.dao.Vehiculos;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.vehiculo.TipoVehiculo;
import mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class ModeloBDAlquilerVehiculos implements IModeloAlquilerVehiculos{
    private Clientes clientes;
    private Alquileres alquileres;
    private Vehiculos vehiculos;

    public ModeloBDAlquilerVehiculos() {
        clientes = new Clientes();
        alquileres = new Alquileres();
        vehiculos = new Vehiculos();
    }

    @Override
    public List<Alquiler> obtenerAlquileres() {
        return alquileres.getAlquiler();
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculos.getVehiculo();
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return clientes.getClientes();
    }

    @Override
    public Cliente buscarCliente(String dni) {
        return clientes.buscar(dni);
    }

    @Override
    public void anadirCliente(Cliente cliente) {
        clientes.anadir(cliente);
    }

    @Override
    public void borrarCliente(String dni) {
        clientes.borrar(dni);
    }

    @Override
    public void leerClientes() {
        //clientes.leerClientes();
    }

    @Override
    public void escribirClientes() {
        //clientes.escribirClientes();
    }

    @Override
    public void anadirVehiculo(Vehiculo vehiculo , TipoVehiculo tipoVehiculo) {
        vehiculos.anadir(vehiculo, tipoVehiculo);
    }

    @Override
    public void borrarVehiculo(String matricula) {
        vehiculos.borrar(matricula);
    }

    @Override
    public Vehiculo buscarVehiculo(String matricula) {
        return vehiculos.buscar(matricula);
    }

    @Override
    public void leerVehiculos() {
        //vehiculos.leerVehiculos();
    }

    @Override
    public void escribirVehiculos() {
        //vehiculos.escribirVehiculos();
    }

    @Override
    public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
        alquileres.abrir(cliente, vehiculo);
    }

    @Override
    public void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {
        alquileres.cerrar(cliente, vehiculo);
    }

    @Override
    public List<Alquiler> obtenerAlquileresAbiertos() {
        //return alquileres.obtenerAlquileresAbiertos();
    	return null;
    }

    @Override
    public List<Alquiler> obtenerAlquileresCliente(String dni) {
        //return alquileres.obtenerAlquileresCliente(dni);
    	return null;
    }

    @Override
    public List<Alquiler> obtenerAlquileresVehiculo(String matricula) {
        //return alquileres.obtenerAlquileresVehiculo(matricula);
    	return null;
    }

    @Override
    public void leerAlquileres() {
        //alquileres.leerAlquileres();
    }

    @Override
    public void escribirAlquileres() {
        //alquileres.escribirAlquileres();
    }
    
}
