package pck_proyecto;

public class Motocicleta extends Vehiculo{
    private String tipo;
    private int noVelocidades;
    private int noLlantas;

    public Motocicleta(String tipo, int noVelocidades, int noLlantas, int idVehiculo, String modelo, String marca, int anio, String color) {
        super(idVehiculo, modelo, marca, anio, color);
        this.tipo = tipo;
        this.noVelocidades = noVelocidades;
        this.noLlantas = noLlantas;
    }
    public Motocicleta() {
        this(null,0,0,0,null,null,0,null);
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNoVelocidades(int noVelocidades) {
        this.noVelocidades = noVelocidades;
    }

    public void setNoLlantas(int noLlantas) {
        this.noLlantas = noLlantas;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNoVelocidades() {
        return noVelocidades;
    }

    public int getNoLlantas() {
        return noLlantas;
    }
    public String getDatos() {
        return super.getDatos() +
               "\nTipo: " + getTipo ()+
               "\nTransmision: " + getNoVelocidades() +
               "\nNo. Puertas: " + getNoLlantas();
    }
}
