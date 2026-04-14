//Acosta Morales María Fernanda 
//Camacho Mendoza Waldo Oziel
//Santamaria Martínez Iker Ilan
package pck_proyecto;

import java.io.Serializable;

public class Automovil extends Vehiculo implements Serializable {
    private String tipo;
    private String transmision;
    private int noPuertas;

    public Automovil(String tipo, String transmision, int noPuertas, int idVehiculo, String modelo, String marca, int anio, String color) {
        super(idVehiculo, modelo, marca, anio, color);
        this.tipo = tipo;
        this.transmision = transmision;
        this.noPuertas = noPuertas;
    }
    public Automovil() {
        this(null, null, 0,0,null,null,0, null);
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public void setNoPuertas(int noPuertas) {
        this.noPuertas = noPuertas;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTransmision() {
        return transmision;
    }

    public int getNoPuertas() {
        return noPuertas;
    }
    public String getDatos() {
        return super.getDatos() +
               "\nTipo: " + getTipo() +
               "\nTransmision: " + getTransmision() +
               "\nNo. Puertas: " + getNoPuertas();
    }
    
}
