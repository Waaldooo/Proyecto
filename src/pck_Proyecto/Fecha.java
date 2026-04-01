package pck_Proyecto;

public class Fecha {
    private int dia, mes,anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    public Fecha() {
        this(0,0,0);
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public int getDia() {
        return dia;
    }
    public int getMes() {
        return mes;
    }
    public int getAnio() {
        return anio;
    }
    public String getFecha(){
        return "Día:\n" + getDia() + "Mes:\n" + getMes () + "Año:\n"+ getAnio();
    }
    
}
