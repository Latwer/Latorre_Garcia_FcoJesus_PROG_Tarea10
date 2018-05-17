package mvc.modelo.ficheros.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.vehiculo.TipoVehiculo;
import mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 *
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Vehiculos {

    private Map<String, Vehiculo> vehiculos;

    private final String FICHERO_VEHICULOS = "datos/vehiculos.dat";

    public Vehiculos() {
        vehiculos = new HashMap<String, Vehiculo>();
    }

    public List<Vehiculo> getVehiculos() {
        return new Vector<Vehiculo>(vehiculos.values());
    }

    public void leerVehiculos() {
        File fichero = new File(FICHERO_VEHICULOS);
        ObjectInputStream entrada;
        try {
            entrada = new ObjectInputStream(new FileInputStream(fichero));
            try {
                while (true) {
                    Vehiculo vehiculo = (Vehiculo) entrada.readObject();
                    vehiculos.put(vehiculo.getMatricula(), vehiculo);
                }
            } catch (EOFException eo) {
                entrada.close();
                System.out.println("Fichero vehículos leído satisfactoriamente.");
            } catch (ClassNotFoundException e) {
                System.out.println("No puedo encontrar la clase que tengo que leer.");
            } catch (IOException e) {
                System.out.println("Error inesperado de Entrada/Salida.");
            }
        } catch (IOException e) {
            System.out.println("No puedo abrir el fihero de vehículos.");
        }
    }

    public void escribirVehiculos() {
        File fichero = new File(FICHERO_VEHICULOS);
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fichero));
            for (Vehiculo vehiculo : vehiculos.values()) {
                salida.writeObject(vehiculo);
            }
            salida.close();
            System.out.println("Fichero vehículos escrito satisfactoriamente");
        } catch (FileNotFoundException e) {
            System.out.println("No puedo crear el fichero de vehículos");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida");
        }
    }

    public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
        if (vehiculos.containsKey(vehiculo.getMatricula())) {
            throw new ExcepcionAlquilerVehiculos("Ya existe un vehículo con esa matríucula");
        } else {
            vehiculos.put(vehiculo.getMatricula(), vehiculo);
        }
    }

    public void borrarVehiculo(String matricula) {
        if (vehiculos.containsKey(matricula)) {
            vehiculos.remove(matricula);
        } else {
            throw new ExcepcionAlquilerVehiculos("El vehículo a borrar no existe");
        }
    }

    public Vehiculo buscarVehiculo(String matricula) {
        if (vehiculos.containsKey(matricula)) {
            return vehiculos.get(matricula);
        } else {
            return null;
        }
    }

}
