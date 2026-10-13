/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transporteturistico;

/**
 *
 * @author germa
 */


public class LanchaTuristica extends Vehiculo {

    private TipoMotor tipoMotor;

    public LanchaTuristica(String patente, String marca, int capacidadPasajeros,
            int anioFabricacion, TipoMotor tipoMotor) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        setTipoMotor(tipoMotor);
    }

    public TipoMotor getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(TipoMotor tipoMotor) {
        if (tipoMotor == null) {
            throw new IllegalArgumentException("El tipo de motor es obligatorio.");
        }
        this.tipoMotor = tipoMotor;
    }

    @Override
    public String realizarServicio() {
        return "Lancha " + getPatente() + ": realizando paseo fluvial con motor " + tipoMotor + ".";
    }

    @Override
    public String toString() {
        return "[Lancha] " + super.toString() + " | Motor: " + tipoMotor;
    }
}