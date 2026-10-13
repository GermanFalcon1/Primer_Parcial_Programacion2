/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transporteturistico;

/**
 *
 * @author germa
 */

public class ColectivoTuristico extends Vehiculo {

    private int cantidadPisos;

    public ColectivoTuristico(String patente, String marca, int capacidadPasajeros,
            int anioFabricacion, int cantidadPisos) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        setCantidadPisos(cantidadPisos);
    }

    public static void validarPisos(int pisos) {
        if (pisos != 1 && pisos != 2) {
            throw new IllegalArgumentException("La cantidad de pisos debe ser 1 o 2.");
        }
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public void setCantidadPisos(int cantidadPisos) {
        validarPisos(cantidadPisos);
        this.cantidadPisos = cantidadPisos;
    }

    @Override
    public String realizarServicio() {
        return "Colectivo " + getPatente() + ": realizando city tour de " + cantidadPisos
                + " piso(s) con " + getCapacidadPasajeros() + " pasajeros.";
    }

    @Override
    public String toString() {
        return "[Colectivo] " + super.toString() + " | Pisos: " + cantidadPisos;
    }
}