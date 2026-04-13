package pck_proyecto;

import java.io.Serializable;

public class Fecha implements Serializable{
    public boolean fechaCorrecta() {
        if (mes < 1 || mes > 12) return false;

        if (dia < 1) return false;

        if (mes == 2) {
            if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
                if (dia > 29) return false;
            } else {
                if (dia > 28) return false;
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia > 30) return false;
        } else {
            if (dia > 31) return false;
        }

        return true;
    }
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
        return (dia < 10 ? "0" : "") + dia + "/" +
               (mes < 10 ? "0" : "") + mes + "/" +
               anio;
    }
    
}
