package pck_proyecto;

import java.io.Serializable;

public class Renta implements Serializable{
    private int idRenta;
    private int idVehiculo;
    private String idCliente;
    private Fecha fechaRenta;
    private Fecha fechaEntrega;

    public Renta(int idRenta, int idVehiculo, String idCliente, Fecha fechaRenta, Fecha fechaEntrega) {
        this.idRenta = idRenta;
        this.idVehiculo = idVehiculo;
        this.idCliente = idCliente;
        this.fechaRenta = fechaRenta;
        this.fechaEntrega = fechaEntrega;
    }
    public Renta() {
        this(0,0,null,null,null);
    }

    public void setIdRenta(int idRenta) {
        this.idRenta = idRenta;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setFechaRenta(Fecha fechaRenta) {
        this.fechaRenta = fechaRenta;
    }

    public void setFechaEntrega(Fecha fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getIdRenta() {
        return idRenta;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public Fecha getFechaRenta() {
        return fechaRenta;
    }

    public Fecha getFechaEntrega() {
        return fechaEntrega;
    }
    public String getDatos() {
        return "ID Renta: " + getIdRenta() +
               "\nID Vehiculo: " + getIdVehiculo() +
               "\nID Cliente: " + getIdCliente() +
               "\nFecha Renta: " + getFechaRenta() +
               "\nFecha Entrega: " + getFechaEntrega();
    }
}
