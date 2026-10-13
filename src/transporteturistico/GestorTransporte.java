/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transporteturistico;

/**
 *
 * @author germa
 */


import java.util.ArrayList;

public class GestorTransporte {

    private final ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public boolean existePatente(String patente) {
        return buscarPorPatente(patente) != null;
    }

    public void agregar(Vehiculo v) {
        if (existePatente(v.getPatente())) {
            throw new IllegalArgumentException("Ya existe un vehiculo con la patente " + v.getPatente() + ".");
        }
        vehiculos.add(v);
    }

    public Vehiculo buscarPorPatente(String patente) {
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getPatente().equalsIgnoreCase(patente.trim())) {
                return vehiculos.get(i);
            }
        }
        return null;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public ArrayList<Vehiculo> mayoresACapacidad(int valor) {
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getCapacidadPasajeros() > valor) {
                resultado.add(vehiculos.get(i));
            }
        }
        return resultado;
    }

    public ArrayList<Vehiculo> ordenadosPorAnioDesc() {
        ArrayList<Vehiculo> copia = new ArrayList<>(vehiculos);
        for (int i = 0; i < copia.size() - 1; i++) {
            int max = i;
            for (int j = i + 1; j < copia.size(); j++) {
                if (copia.get(j).getAnioFabricacion() > copia.get(max).getAnioFabricacion()) {
                    max = j;
                }
            }
            Vehiculo aux = copia.get(i);
            copia.set(i, copia.get(max));
            copia.set(max, aux);
        }
        return copia;
    }

    public ArrayList<Vehiculo> ordenadosPorCapacidadDesc() {
        ArrayList<Vehiculo> copia = new ArrayList<>(vehiculos);
        for (int i = 0; i < copia.size() - 1; i++) {
            int max = i;
            for (int j = i + 1; j < copia.size(); j++) {
                if (copia.get(j).getCapacidadPasajeros() > copia.get(max).getCapacidadPasajeros()) {
                    max = j;
                }
            }
            Vehiculo aux = copia.get(i);
            copia.set(i, copia.get(max));
            copia.set(max, aux);
        }
        return copia;
    }
}