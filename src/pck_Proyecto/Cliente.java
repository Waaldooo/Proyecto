//Acosta Morales María Fernanda 
//Camacho Mendoza Waldo Oziel
//Santamaria Martínez Iker Ilan
package pck_proyecto;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String idCliente;
    private String nombre;
    private String tipo;
    private String telefono;
    private Fecha fechaNacimiento;
    private String correo;

    public Cliente(String idCliente, String nombre, String tipo, String telefono, Fecha fechaNacimiento, String correo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.tipo = tipo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
    }
    public Cliente() {
        this(null,null,null,null,null,null);
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTelefono() {
        return telefono;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }
    public String getDatos() {
        return "ID: " + getIdCliente () +
               "\nNombre: " + getNombre() +
               "\nTelefono: " + getTelefono() +
               "\nCorreo: " + getCorreo() +
               "\nFecha Nacimiento: " + getFechaNacimiento().getFecha();
    }
}
