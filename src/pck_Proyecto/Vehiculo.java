package pck_proyecto;

public class Vehiculo {
    protected int idVehiculo;
    protected String modelo;
    protected String marca;
    protected int anio;
    protected String color;

    public Vehiculo(int idVehiculo, String modelo, String marca, int anio, String color) {
        this.idVehiculo = idVehiculo;
        this.modelo = modelo;
        this.marca = marca;
        this.anio = anio;
        this.color = color;
    }
    public Vehiculo() {
         this(0,null,null,0,null);
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getAnio() {
        return anio;
    }

    public String getColor() {
        return color;
    }
    public String getDatos() {
        return "ID: " + getIdVehiculo() +
               "\nMarca: " + getMarca ()+
               "\nModelo: " + getModelo() +
               "\nAño: " + getAnio() +
               "\nColor: " + getColor();
    }
    
}
