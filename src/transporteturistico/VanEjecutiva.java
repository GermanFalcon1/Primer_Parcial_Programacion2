/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transporteturistico;

/**
 *
 * @author germa
 */


public class VanEjecutiva extends Vehiculo {

    private boolean aireAcondicionado;

    public VanEjecutiva(String patente, String marca, int capacidadPasajeros,
            int anioFabricacion, boolean aireAcondicionado) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    @Override
    public String realizarServicio() {
        String aire = aireAcondicionado ? "con aire acondicionado" : "sin aire acondicionado";
        return "Van " + getPatente() + ": realizando traslado ejecutivo " + aire + ".";
    }

    @Override
    public String toString() {
        return "[Van] " + super.toString() + " | Aire: " + (aireAcondicionado ? "Si" : "No");
    }
}