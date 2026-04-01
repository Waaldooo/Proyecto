package pck_Proyecto;

public class Automovil {
    protected String tipo;
    protected String transmicion;
    protected int noPuertas;
    
    public Automovil(String tipo, String transmicion, int noPuertas){
        this.tipo = tipo;
        this.transmicion = transmicion;
        this.noPuertas = noPuertas;
    }
    
    public Automovil(){
        this(null, null, 0);
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTransmicion(String transmicion) {
        this.transmicion = transmicion;
    }

    public void setNoPuertas(int noPuertas) {
        this.noPuertas = noPuertas;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTransmicion() {
        return transmicion;
    }

    public int getNoPuertas() {
        return noPuertas;
    }
    
    public String getDatos(){
        return "\nTipo:" + getTipo() +
                "\nTransmicion: " + getTransmicion() +
                "\nnoPuertas: " +getNoPuertas();
    }
}
