/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transporteturistico;

/**
 *
 * @author germa
 */


public enum TipoMotor {
    NAFTA, DIESEL, ELECTRICO;

    public static TipoMotor desde(String texto) {
        try {
            return TipoMotor.valueOf(texto.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de motor invalido. Use NAFTA, DIESEL o ELECTRICO.");
        }
    }
}
