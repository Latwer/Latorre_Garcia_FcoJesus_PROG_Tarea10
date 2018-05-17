package mvc.vista.iutextual;

import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.vehiculo.Vehiculo;
import mvc.vista.iutextual.utilidades.Consola;
import mvc.controlador.ControladorAlquilerVehiculos;
import mvc.controlador.IControladorAlquilerVehiculos;
import mvc.modelo.dominio.vehiculo.TipoVehiculo;
import mvc.vista.IVistaAlquilerVehiculos;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class IUTextual implements IVistaAlquilerVehiculos {

    IControladorAlquilerVehiculos controlador;

    public IUTextual() {
        Opcion.setVista(this);
    }

    @Override
    public void setControlador(IControladorAlquilerVehiculos controlador) {
        this.controlador = controlador;
    }

    @Override
    public void comenzar() {
        int ordinalOpcion;
        do {
            Consola.mostrarMenu();
            ordinalOpcion = Consola.elegirOpcion();
            Opcion opcion = Opcion.getOpcionSegunOridnal(ordinalOpcion);
            opcion.ejecutar();
        } while (ordinalOpcion != Opcion.SALIR.ordinal());
    }

    public void salir() {
        System.out.println("Hasta la proxima!");
        controlador.salir();
    }

    public void anadirCliente() {
        Consola.mostrarCabecera("Añadir cliente");
        Cliente cliente = Consola.leerCliente();
        try {
            controlador.anadirCliente(cliente);
            System.out.println("Cliente añadido satisfactoriamente\n");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("ERROR: %s%n%n", e.getMessage());
        }
    }

    public void borrarCliente() {
        Consola.mostrarCabecera("Borrar cliente");
        String dni = Consola.leerDni();
        try {
            controlador.borrarCliente(dni);
            System.out.println("Cliente borrado satisfactoriamente\n");
        } catch (Exception e) {
            System.out.printf("ERROR: %s%n%n", e.getMessage());
        }
    }

    public void buscarCliente() {
        Consola.mostrarCabecera("Buscar cliente");
        String dni = Consola.leerDni();
        Cliente cliente = controlador.buscarCliente(dni);
        String mensaje = (cliente != null) ? cliente.toString() : "El cliente no existe";
        System.out.printf("%s%n%n", mensaje);
    }

    public void listarClientes() {
        Consola.mostrarCabecera("Listar clientes");
        controlador.obtenerClientes().stream().filter((cliente) -> (cliente != null)).forEachOrdered((cliente) -> {
            System.out.println(cliente);
        });
        System.out.println("");
    }

    public void anadirVehiculo() {
        Consola.mostrarCabecera("Añadir vehiculo");
        Vehiculo vehiculo = Consola.leerVehiculo();
        int tipoVehiculo = 0;
        try {
            controlador.anadirVehiculo(vehiculo, TipoVehiculo.getTipoVehiculoSegunOrdinal(tipoVehiculo));
            System.out.println("Vehiculo añadido satisfactoriamente\n");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("ERROR: %s%n%n", e.getMessage());
        }
    }

    public void borrarVehiculo() {
        Consola.mostrarCabecera("Borrar turismo");
        String matricula = Consola.leerMatricula();
        try {
            controlador.borrarVehiculo(matricula);
            System.out.println("Vehiculo borrado satisfactoriamente\n");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("ERROR: %s%n%n", e.getMessage());
        }
    }

    public void buscarVehiculo() {
        Consola.mostrarCabecera("Buscar turismo");
        String matricula = Consola.leerMatricula();
        Vehiculo vehiculoBuscado = controlador.buscarVehiculo(matricula);
        String mensaje = (vehiculoBuscado != null) ? vehiculoBuscado.toString() : "El vehiculo no existe";
        System.out.printf("%s%n%n", mensaje);
    }

    public void listarVehiculos() {
        Consola.mostrarCabecera("Listar vehiculos");
        controlador.obtenerVehiculos().stream().filter((vehiculo) -> (vehiculo != null)).forEachOrdered((vehiculo) -> {
            System.out.println(vehiculo);
        });
        System.out.println("");
    }

    public void abrirAlquiler() {
        Consola.mostrarCabecera("Abrir alquiler");
        String dni = Consola.leerDni();
        Cliente cliente = controlador.buscarCliente(dni);
        String matricula = Consola.leerMatricula();
        Vehiculo turismo = controlador.buscarVehiculo(matricula);
        if (cliente == null && turismo == null) {
            System.out.println("ERROR: No existe un cliente con dicho dni o un vehículo con dicha matrícula\n");
        } else {
            try {
                controlador.abrirAlquiler(cliente, turismo);
                System.out.println("Alquiler abierto satisfactoriamente\n");
            } catch (ExcepcionAlquilerVehiculos e) {
                System.out.printf("ERROR: %s%n%n", e.getMessage());
            }
        }
    }

    public void cerrarAlquiler() {
        Consola.mostrarCabecera("Cerrar alquiler");
        String dni = Consola.leerDni();
        Cliente cliente = controlador.buscarCliente(dni);
        String matricula = Consola.leerMatricula();
        Vehiculo turismo = controlador.buscarVehiculo(matricula);
        if (cliente == null && turismo == null) {
            System.out.println("ERROR: No existe un cliente con dicho dni o un vehículo con dicha matrícula\n");
        } else {
            try {
                controlador.cerrarAlquiler(cliente, turismo);
                System.out.println("Alquiler cerrado satisfactoriamente\n");
            } catch (ExcepcionAlquilerVehiculos e) {
                System.out.printf("ERROR: %s%n%n", e.getMessage());
            }
        }
    }

    public void listarAlquileres() {
        Consola.mostrarCabecera("Listar alquileres");
        controlador.obtenerAlquileres().stream().filter((alquiler) -> (alquiler != null)).forEachOrdered((alquiler) -> {
            System.out.println(alquiler);
        });
        System.out.println("");
    }

    //@Override
    public void obtenerAlquileresAbiertos() {
        Consola.mostrarCabecera("ALQUILERES ABIERTOS");
        controlador.obtenerAlquileresAbiertos().forEach((alquileresAbiertos) -> {
            System.out.println(alquileresAbiertos);
        });
    }

    //@Override
    public void obtenerAlquileresCliente() {
        String dni = Consola.leerDni();

        try {
            controlador.buscarCliente(dni);
            Consola.mostrarCabecera("Listado de Alquileres por Cliente");
            if (controlador.obtenerAlquileresCliente(dni).isEmpty()) {
                System.out.println("El cliente solicitado no tiene alquileres en curso");
            } else {
                controlador.obtenerAlquileresCliente(dni).forEach((alquileresCliente) -> {
                    System.out.println(alquileresCliente);
                });
            }
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("\nERROR: %s%n%n", e.getMessage());
        }
    }

    //@Override
    public void obtenerAlquileresVehiculo() {
        String matricula = Consola.leerMatricula();

        try {
            controlador.buscarVehiculo(matricula);
            Consola.mostrarCabecera("Listado de Alquileres por vehículo");
            if (controlador.obtenerAlquileresVehiculo(matricula).isEmpty()) {
                System.out.println("El vehículo solicitado no tiene alquileres en curso.");
            } else {
                controlador.obtenerAlquileresVehiculo(matricula).forEach((alquileresVehiculo) -> {
                    System.out.println(alquileresVehiculo);
                });
            }
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("\nERROR: %s%n%n", e.getMessage());
        }
    }
}
