/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package transporteturistico;

/**
 *
 * @author german
 */




import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final GestorTransporte gestor = new GestorTransporte();

    public static void main(String[] args) {
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = leerEntero("Opcion: ");
            switch (opcion) {
                case 1:
                    agregarVehiculo();
                    break;
                case 2:
                    mostrarLista(gestor.getVehiculos());
                    break;
                case 3:
                    realizarServicios();
                    break;
                case 4:
                    buscarVehiculo();
                    break;
                case 5:
                    mostrarMayoresCapacidad();
                    break;
                case 6:
                    mostrarLista(gestor.ordenadosPorAnioDesc());
                    break;
                case 7:
                    mostrarLista(gestor.ordenadosPorCapacidadDesc());
                    break;
                case 8:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion invalida. Elija un numero del 1 al 8.");
            }
        } while (opcion != 8);
    }

    private static void mostrarMenu() {
        System.out.println("\n===== TRANSPORTE TURISTICO =====");
        System.out.println("1. Agregar vehiculo");
        System.out.println("2. Mostrar todos los vehiculos");
        System.out.println("3. Realizar servicios turisticos");
        System.out.println("4. Buscar vehiculo por patente");
        System.out.println("5. Mostrar vehiculos con capacidad mayor a un valor");
        System.out.println("6. Mostrar vehiculos ordenados por anio descendente");
        System.out.println("7. Mostrar vehiculos ordenados por capacidad descendente");
        System.out.println("8. Salir");
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un numero entero valido.");
            }
        }
    }

    private static String leerPatente() {
        while (true) {
            System.out.print("Patente: ");
            String patente = sc.nextLine().trim().toUpperCase();
            try {
                Vehiculo.validarPatente(patente);
                if (gestor.existePatente(patente)) {
                    System.out.println("Error: ya existe un vehiculo con esa patente.");
                } else {
                    return patente;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static String leerMarca() {
        while (true) {
            System.out.print("Marca: ");
            String marca = sc.nextLine().trim();
            try {
                Vehiculo.validarMarca(marca);
                return marca;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static int leerCapacidad() {
        while (true) {
            int capacidad = leerEntero("Capacidad de pasajeros: ");
            try {
                Vehiculo.validarCapacidad(capacidad);
                return capacidad;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static int leerAnio() {
        while (true) {
            int anio = leerEntero("Anio de fabricacion: ");
            try {
                Vehiculo.validarAnio(anio);
                return anio;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static int leerPisos() {
        while (true) {
            int pisos = leerEntero("Cantidad de pisos (1 o 2): ");
            try {
                ColectivoTuristico.validarPisos(pisos);
                return pisos;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static boolean leerAire() {
        while (true) {
            System.out.print("Aire acondicionado (S/N): ");
            String r = sc.nextLine().trim().toUpperCase();
            if (r.equals("S")) {
                return true;
            }
            if (r.equals("N")) {
                return false;
            }
            System.out.println("Error: responda S o N.");
        }
    }

    private static TipoMotor leerMotor() {
        while (true) {
            System.out.print("Tipo de motor (NAFTA, DIESEL, ELECTRICO): ");
            try {
                return TipoMotor.desde(sc.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void agregarVehiculo() {
        int tipo = 0;
        while (tipo < 1 || tipo > 3) {
            System.out.println("Tipo: 1. Colectivo  2. Van  3. Lancha");
            tipo = leerEntero("Tipo: ");
            if (tipo < 1 || tipo > 3) {
                System.out.println("Error: elija 1, 2 o 3.");
            }
        }
        String patente = leerPatente();
        String marca = leerMarca();
        int capacidad = leerCapacidad();
        int anio = leerAnio();

        Vehiculo v;
        if (tipo == 1) {
            v = new ColectivoTuristico(patente, marca, capacidad, anio, leerPisos());
        } else if (tipo == 2) {
            v = new VanEjecutiva(patente, marca, capacidad, anio, leerAire());
        } else {
            v = new LanchaTuristica(patente, marca, capacidad, anio, leerMotor());
        }
        gestor.agregar(v);
        System.out.println("Vehiculo agregado correctamente.");
    }

    private static void mostrarLista(ArrayList<Vehiculo> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay vehiculos para mostrar.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    private static void realizarServicios() {
        ArrayList<Vehiculo> lista = gestor.getVehiculos();
        if (lista.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).realizarServicio());
        }
    }

    private static void buscarVehiculo() {
        System.out.print("Patente a buscar: ");
        String patente = sc.nextLine().trim();
        if (patente.isEmpty()) {
            System.out.println("Error: la patente no puede estar vacia.");
            return;
        }
        Vehiculo v = gestor.buscarPorPatente(patente);
        if (v == null) {
            System.out.println("No se encontro un vehiculo con esa patente.");
        } else {
            System.out.println(v);
        }
    }

    private static void mostrarMayoresCapacidad() {
        int valor = leerEntero("Capacidad minima (se muestran los mayores a este valor): ");
        ArrayList<Vehiculo> resultado = gestor.mayoresACapacidad(valor);
        if (resultado.isEmpty()) {
            System.out.println("No hay vehiculos con capacidad mayor a " + valor + ".");
        } else {
            mostrarLista(resultado);
        }
    }
}
