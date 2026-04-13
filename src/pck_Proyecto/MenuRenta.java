package pck_proyecto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MenuRenta {

    public static void main(String[] args) {
        //Arreglos
        ArrayList<Automovil> autos = new ArrayList<>();
        ArrayList<Motocicleta> motos = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Renta> rentas = new ArrayList<>();
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("datos.txt");
            ObjectInputStream entrada = new ObjectInputStream(fin);

            autos = (ArrayList<Automovil>) entrada.readObject();
            motos = (ArrayList<Motocicleta>) entrada.readObject();
            clientes = (ArrayList<Cliente>) entrada.readObject();
            rentas = (ArrayList<Renta>) entrada.readObject();

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error de clase");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de lectura");
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar");
            }
        }
        //Variables
        int op, idVehiculo, anio, noPuertas, noVelocidades, noLlantas, idRenta, dia, mes, contV = 0, contR = 0, busVehiculo, posV, posR, posC, res;
        String tipo, transmision, modelo, marca, color, idCliente = null, nombre, telefono, correo, listaAutomoviles, listaMotocicletas, listaClientes, listaRentas;
        boolean encontrado;
        boolean fechaValida;

        String menu = " - - - MENU RENTA DE AUTOS Y MOTOS - - -\n\n"
                + "1) Alta de automóvil\n"
                + "2) Alta de una motocicleta\n"
                + "3) Alta de un cliente\n"
                + "4) Alta de una renta\n"
                + "5) Listar automóviles\n"
                + "6) Listar motocicletas\n"
                + "7) Listar clientes\n"
                + "8) Listar rentas\n"
                + "9) Ver detalles de un automóvil\n"
                + "10) Ver detalles de una motocicleta\n"
                + "11) Ver detalles de un cliente\n"
                + "12) Ver detalles de una renta\n"
                + "13) Eliminar un automóvil\n"
                + "14) Eliminar una motocicleta\n"
                + "15) Eliminar un cliente\n"
                + "16) Eliminar una renta\n"
                + "17) Salir\n"
                + "\nElija una opcion:";

        do {
            do {
                op = 0;
                try {
                    op = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Menu de Opciones", 3));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "La opción debe ser numerica", "Error de Entrada", 2);
                }
            } while (op == 0);

            switch (op) {
                case 1:
                    do {
                        idVehiculo = -1;
                        try {
                            idVehiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "Id del Automovil:", "Alta de un Automóvil", 3));
                            if (idVehiculo <= 0) {
                                JOptionPane.showMessageDialog(null, "El Id del Automóvil debe ser positivo", "Dato Erroneo", 2);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "El id del automóvil debe ser numerico", "Dato erroneo", 2);
                        }
                    } while (idVehiculo <= 0);

                    do {
                        modelo = JOptionPane.showInputDialog(null, "Modelo:", "Alta de un Automóvil", 3);
                    } while (modelo.isBlank());

                    do {
                        marca = JOptionPane.showInputDialog(null, "Marca:", "Alta de un Automóvil", 3);
                    } while (marca.isBlank());

                    do {
                        anio = 0;
                        try {
                            anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Año:"));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "El año debe ser numerico");
                        }
                    } while (anio < 1900 || anio > 2027);

                    do {
                        color = JOptionPane.showInputDialog(null, "Color:", "Alta de un Automóvil", 3);
                    } while (color.isBlank());

                    do {
                        tipo = JOptionPane.showInputDialog(null, "Tipo:", "Alta de un Automóvil", 3);
                    } while (tipo.isBlank());

                    do {
                        transmision = JOptionPane.showInputDialog(null, "Transmisión:", "Alta de un Automóvil", 3);
                    } while (transmision.isBlank());

                    do {
                        noPuertas = 0;
                        try {
                            noPuertas = Integer.parseInt(JOptionPane.showInputDialog(null, "No. de puertas:", "Alta de un Automóvil", 3));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Debe ser numerico");
                        }
                    } while (noPuertas < 2 || noPuertas > 4);

                    autos.add(new Automovil(tipo, transmision, noPuertas, idVehiculo, modelo, marca, anio, color));
                    JOptionPane.showMessageDialog(null, "Automóvil registrado");
                break;

                case 2:
                    do {
                        idVehiculo = -1;
                        try {
                            idVehiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "Id de la Motocicleta:", "Alta de una Motocicleta", 3));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Debe ser numerico");
                        }
                    } while (idVehiculo <= 0);

                    do {
                        modelo = JOptionPane.showInputDialog("Modelo:");
                    } while (modelo.isBlank());

                    do {
                        marca = JOptionPane.showInputDialog("Marca:");
                    } while (marca.isBlank());

                    do {
                        anio = Integer.parseInt(JOptionPane.showInputDialog("Año:"));
                    } while (anio < 1900 || anio > 2027);

                    do {
                        color = JOptionPane.showInputDialog("Color:");
                    } while (color.isBlank());

                    do {
                        tipo = JOptionPane.showInputDialog("Tipo:");
                    } while (tipo.isBlank());

                    do {
                        noVelocidades = Integer.parseInt(JOptionPane.showInputDialog("No velocidades:"));
                    } while (noVelocidades < 4 || noVelocidades > 7);

                    do {
                        noLlantas = Integer.parseInt(JOptionPane.showInputDialog("No llantas:"));
                    } while (noLlantas != 2);

                    motos.add(new Motocicleta(tipo, noVelocidades, noLlantas, idVehiculo, modelo, marca, anio, color));
                    JOptionPane.showMessageDialog(null, "Motocicleta registrada");
                break;

                case 3:
                    do {
                        idCliente = JOptionPane.showInputDialog(null, "Id del cliente:", "Alta de un Cliente", 3);
                        if (idCliente.isBlank()) {
                            JOptionPane.showMessageDialog(null, "El id del cliente es algo requerido", "Dato Erroneo", 2);
                        }
                    } while (idCliente.isBlank());

                    do {
                        nombre = JOptionPane.showInputDialog(null, "Nombre del cliente:", "Alta de un Cliente", 3);
                        if (nombre.isBlank()) {
                            JOptionPane.showMessageDialog(null, "El nombre del cliente es algo requerido", "Dato Erroneo", 2);
                        }
                    } while (nombre.isBlank());

                    do {
                        tipo = JOptionPane.showInputDialog(null, "Tipo:", "Alta de un Cliente", 3);
                        if (tipo.isBlank()) {
                            JOptionPane.showMessageDialog(null, "El tipo es algo requerido", "Dato Erroneo", 2);
                        }
                    } while (tipo.isBlank());

                    do {
                        telefono = JOptionPane.showInputDialog(null, "Telefono:", "Alta de un Cliente", 3);
                        if (telefono.isBlank()) {
                            JOptionPane.showMessageDialog(null, "El telefono es algo requerido", "Dato Erroneo", 2);
                        }
                    } while (telefono.isBlank());

                    Fecha f = null;

                    do {
                        do {
                            dia = 0;
                            try {
                                dia = Integer.parseInt(JOptionPane.showInputDialog("Dia:"));
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Debe ser numerico");
                            }
                        } while (dia <= 0);

                        do {
                            mes = 0;
                            try {
                                mes = Integer.parseInt(JOptionPane.showInputDialog("Mes:"));
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Debe ser numerico");
                            }
                        } while (mes <= 0);

                        do {
                            anio = 0;
                            try {
                                anio = Integer.parseInt(JOptionPane.showInputDialog("Año:"));
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Debe ser numerico");
                            }
                        } while (anio <= 0);

                        f = new Fecha(dia, mes, anio);
                        fechaValida = f.fechaCorrecta();

                        if (!fechaValida) {
                            JOptionPane.showMessageDialog(null, "Fecha incorrecta");
                        }

                    } while (!fechaValida);

                    do {
                        correo = JOptionPane.showInputDialog(null, "Correo:", "Alta de un Cliente", 3);
                        if (correo.isBlank()) {
                            JOptionPane.showMessageDialog(null, "El correo es requerido");
                        }
                    } while (correo.isBlank());

                    clientes.add(new Cliente(idCliente, nombre, tipo, telefono, f, correo));
                    JOptionPane.showMessageDialog(null, "Cliente registrado");
                break;

                case 4:
                    if (clientes.size() == 0) {
                        JOptionPane.showMessageDialog(null, "No hay clientes registrados");
                        break;
                    }

                    if (autos.size() == 0 && motos.size() == 0) {
                        JOptionPane.showMessageDialog(null, "No hay vehículos registrados");
                        break;
                    }

                    boolean existe;

                    do {
                        idRenta = -1;
                        existe = false;

                        try {
                            idRenta = Integer.parseInt(JOptionPane.showInputDialog("Id de la renta:"));

                            if (idRenta <= 0) {
                                JOptionPane.showMessageDialog(null, "Debe ser positivo");
                            }

                            for (int i = 0; i < rentas.size(); i++) {
                                if (rentas.get(i).getIdRenta() == idRenta) {
                                    JOptionPane.showMessageDialog(null, "Ese ID ya existe");
                                    existe = true;
                                    break;
                                }
                            }

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Dato incorrecto");
                        }

                    } while (idRenta <= 0 || existe);

                    do {
                        idVehiculo = -1;

                        try {
                            idVehiculo = Integer.parseInt(JOptionPane.showInputDialog("Id del vehiculo:"));

                            if (idVehiculo <= 0) {
                                JOptionPane.showMessageDialog(null, "Debe ser positivo");
                            }

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Dato incorrecto");
                        }

                        busVehiculo = -1;

                        for (int i = 0; i < autos.size(); i++) {
                            if (autos.get(i).getIdVehiculo() == idVehiculo) {
                                busVehiculo = i;
                                break;
                            }
                        }

                        if (busVehiculo == -1) {
                            for (int i = 0; i < motos.size(); i++) {
                                if (motos.get(i).getIdVehiculo() == idVehiculo) {
                                    busVehiculo = i;
                                    break;
                                }
                            }
                        }

                        if (busVehiculo == -1) {
                            JOptionPane.showMessageDialog(null, "El vehículo no existe");
                        }

                    } while (idVehiculo <= 0 || busVehiculo == -1);

                    do {
                        idCliente = JOptionPane.showInputDialog("Id del cliente:");

                        if (idCliente == null || idCliente.isBlank()) {
                            JOptionPane.showMessageDialog(null, "Campo obligatorio");
                            idCliente = "";
                        }

                        posC = -1;

                        for (int i = 0; i < clientes.size(); i++) {
                            if (idCliente.equalsIgnoreCase(clientes.get(i).getIdCliente())) {
                                posC = i;
                                break;
                            }
                        }

                        if (posC == -1) {
                            JOptionPane.showMessageDialog(null, "El cliente no existe");
                        }

                    } while (idCliente.isBlank() || posC == -1);

                    Fecha fechaR = null;

                    do {
                        do {
                            dia = 0;
                            try {
                                dia = Integer.parseInt(JOptionPane.showInputDialog("Dia de renta:"));
                                if (dia <= 0 || dia > 31) {
                                    JOptionPane.showMessageDialog(null, "El día debe estar entre 1 y 31");
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Dato incorrecto");
                            }
                        } while (dia <= 0 || dia > 31);

                        do {
                            mes = 0;
                            try {
                                mes = Integer.parseInt(JOptionPane.showInputDialog("Mes de renta:"));
                                if (mes <= 0 || mes > 12) {
                                    JOptionPane.showMessageDialog(null, "El mes debe estar entre 1 y 12");
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Dato incorrecto");
                            }
                        } while (mes <= 0 || mes > 12);

                        do {
                            anio = 0;
                            try {
                                anio = Integer.parseInt(JOptionPane.showInputDialog("Año de renta:"));
                                if (anio <= 0) {
                                    JOptionPane.showMessageDialog(null, "El año debe ser positivo");
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Dato incorrecto");
                            }
                        } while (anio <= 0);

                        fechaR = new Fecha(dia, mes, anio);

                        if (!fechaR.fechaCorrecta()) {
                            JOptionPane.showMessageDialog(null, "Fecha incorrecta");
                            fechaR = null;
                        }

                    } while (fechaR == null);

                    Fecha fechaE = null;

                    do {
                        do {
                            dia = 0;
                            try {
                                dia = Integer.parseInt(JOptionPane.showInputDialog("Dia de entrega:"));
                                if (dia <= 0 || dia > 31) {
                                    JOptionPane.showMessageDialog(null, "El día debe estar entre 1 y 31");
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Dato incorrecto");
                            }
                        } while (dia <= 0 || dia > 31);

                        do {
                            mes = 0;
                            try {
                                mes = Integer.parseInt(JOptionPane.showInputDialog("Mes de entrega:"));
                                if (mes <= 0 || mes > 12) {
                                    JOptionPane.showMessageDialog(null, "El mes debe estar entre 1 y 12");
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Dato incorrecto");
                            }
                        } while (mes <= 0 || mes > 12);

                        do {
                            anio = 0;
                            try {
                                anio = Integer.parseInt(JOptionPane.showInputDialog("Año de entrega:"));
                                if (anio <= 0) {
                                    JOptionPane.showMessageDialog(null, "El año debe ser positivo");
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Dato incorrecto");
                            }
                        } while (anio <= 0);

                        fechaE = new Fecha(dia, mes, anio);

                        if (!fechaE.fechaCorrecta()) {
                            JOptionPane.showMessageDialog(null, "Fecha incorrecta");
                            fechaE = null;
                        } else if (fechaE.getAnio() < fechaR.getAnio()) {
                            JOptionPane.showMessageDialog(null, "La fecha de entrega no puede ser menor que la de renta");
                            fechaE = null;
                        } else if (fechaE.getAnio() == fechaR.getAnio() && fechaE.getMes() < fechaR.getMes()) {
                            JOptionPane.showMessageDialog(null, "La fecha de entrega no puede ser menor que la de renta");
                            fechaE = null;
                        } else if (fechaE.getAnio() == fechaR.getAnio() && fechaE.getMes() == fechaR.getMes() && fechaE.getDia() < fechaR.getDia()) {
                            JOptionPane.showMessageDialog(null, "La fecha de entrega no puede ser menor que la de renta");
                            fechaE = null;
                        }

                    } while (fechaE == null);

                    rentas.add(new Renta(idRenta, idVehiculo, idCliente, fechaR, fechaE));

                    JOptionPane.showMessageDialog(null, "Renta registrada");

                break;

                case 5:
                    listaAutomoviles = "        LISTA DE AUTOMÓVILES\n";
                    listaAutomoviles += "ID   MODELO     MARCA      TIPO      TRANS\n";
                    listaAutomoviles += "-------------------------------------------\n";

                    if (autos.size() == 0) {
                        JOptionPane.showMessageDialog(null, "No hay automóviles");
                    } else {
                        for (int i = 0; i < autos.size(); i++) {
                            listaAutomoviles += autos.get(i).getIdVehiculo() + "    "
                                    + autos.get(i).getModelo() + "    "
                                    + autos.get(i).getMarca() + "    "
                                    + autos.get(i).getTipo() + "    "
                                    + autos.get(i).getTransmision() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, listaAutomoviles);
                    }
                break;

                case 6:
                    listaMotocicletas = "        LISTA DE MOTOCICLETAS\n";
                    listaMotocicletas += "ID   MODELO     MARCA      LLANTAS   TIPO\n";
                    listaMotocicletas += "------------------------------------------\n";

                    if (motos.size() == 0) {
                        JOptionPane.showMessageDialog(null, "No hay motocicletas");
                    } else {
                        for (int i = 0; i < motos.size(); i++) {
                            listaMotocicletas += motos.get(i).getIdVehiculo() + "    "
                                    + motos.get(i).getModelo() + "    "
                                    + motos.get(i).getMarca() + "    "
                                    + motos.get(i).getNoLlantas() + "    "
                                    + motos.get(i).getTipo() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, listaMotocicletas);
                    }
                break;

                case 7:
                    listaClientes = "        LISTA DE CLIENTES\n";
                    listaClientes += "ID   NOMBRE     TIPO\n";
                    listaClientes += "---------------------------\n";

                    if (clientes.size() == 0) {
                        JOptionPane.showMessageDialog(null, "No hay clientes");
                    } else {
                        for (int i = 0; i < clientes.size(); i++) {
                            listaClientes += clientes.get(i).getIdCliente() + "    "
                                    + clientes.get(i).getNombre() + "    "
                                    + clientes.get(i).getTipo() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, listaClientes);
                    }
                break;
                
                case 8:
                    listaRentas = "        LISTA DE RENTAS\n";
                    listaRentas += "ID   VEHICULO   CLIENTE   FECHA\n";
                    listaRentas += "--------------------------------------\n";

                    if (rentas.size() == 0) {
                        JOptionPane.showMessageDialog(null, "No hay rentas");
                    } else {
                        for (int i = 0; i < rentas.size(); i++) {
                            listaRentas += rentas.get(i).getIdRenta() + "    "
                                    + rentas.get(i).getIdVehiculo() + "    "
                                    + rentas.get(i).getIdCliente() + "    "
                                    + rentas.get(i).getFechaRenta().getFecha() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, listaRentas);
                    }
                break;

                case 9:
                    do {
                        idVehiculo = -1;
                        try {
                            idVehiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id del Automovil:", "Consulta", 3));
                            if (idVehiculo <= 0) {
                                JOptionPane.showMessageDialog(null, "Debe ser positivo");
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Debe ser numerico");
                        }
                    } while (idVehiculo <= 0);

                    posV = -1;

                    for (int i = 0; i < autos.size(); i++) {
                        if (autos.get(i).getIdVehiculo() == idVehiculo) {
                            JOptionPane.showMessageDialog(null, autos.get(i).getDatos());
                            posV = i;
                            break;
                        }
                    }

                    if (posV == -1) {
                        JOptionPane.showMessageDialog(null, "El automóvil no existe");
                    }
                break;

                case 10:
                    do {
                        idVehiculo = -1;
                        try {
                            idVehiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id de la motocicleta:", "Consulta", 3));
                            if (idVehiculo <= 0) {
                                JOptionPane.showMessageDialog(null, "Debe ser positivo");
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Debe ser numerico");
                        }
                    } while (idVehiculo <= 0);

                    posV = -1;

                    for (int i = 0; i < motos.size(); i++) {
                        if (motos.get(i).getIdVehiculo() == idVehiculo) {
                            JOptionPane.showMessageDialog(null, motos.get(i).getDatos());
                            posV = i;
                            break;
                        }
                    }

                    if (posV == -1) {
                        JOptionPane.showMessageDialog(null, "La motocicleta no existe");
                    }
                break;

                case 11:
                    do {
                        idCliente = JOptionPane.showInputDialog(null, "Ingrese el Id del cliente:", "Consulta", 3);
                        if (idCliente.isBlank()) {
                            JOptionPane.showMessageDialog(null, "El Id es obligatorio");
                        }
                    } while (idCliente.isBlank());

                    posC = -1;

                    for (int i = 0; i < clientes.size(); i++) {
                        if (idCliente.equalsIgnoreCase(clientes.get(i).getIdCliente())) {
                            JOptionPane.showMessageDialog(null, clientes.get(i).getDatos());
                            posC = i;
                            break;
                        }
                    }

                    if (posC == -1) {
                        JOptionPane.showMessageDialog(null, "El cliente no existe");
                    }
                break;

                case 12:
                    do {
                        idRenta = -1;
                        try {
                            idRenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Id de la renta:", "Consulta", 3));
                            if (idRenta <= 0) {
                                JOptionPane.showMessageDialog(null, "Debe ser positivo");
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Debe ser numerico");
                        }
                    } while (idRenta <= 0);

                    posR = -1;

                    for (int i = 0; i < rentas.size(); i++) {
                        if (rentas.get(i).getIdRenta() == idRenta) {
                            posR = i;
                            break;
                        }
                    }

                    if (posR == -1) {
                        JOptionPane.showMessageDialog(null, "La renta no existe");
                    } else {

                        Renta r = rentas.get(posR);

                        String datos = "DETALLE DE RENTA\n\n";

                        int encontradoVehiculo = -1;

                        for (int i = 0; i < autos.size(); i++) {
                            if (autos.get(i).getIdVehiculo() == r.getIdVehiculo()) {
                                datos += "AUTOMOVIL\n" + autos.get(i).getDatos() + "\n\n";
                                encontradoVehiculo = 1;
                                break;
                            }
                        }

                        if (encontradoVehiculo == -1) {
                            for (int i = 0; i < motos.size(); i++) {
                                if (motos.get(i).getIdVehiculo() == r.getIdVehiculo()) {
                                    datos += "MOTOCICLETA\n" + motos.get(i).getDatos() + "\n\n";
                                    break;
                                }
                            }
                        }

                        for (int i = 0; i < clientes.size(); i++) {
                            if (clientes.get(i).getIdCliente().equalsIgnoreCase(r.getIdCliente())) {
                                datos += "CLIENTE\n" + clientes.get(i).getDatos() + "\n\n";
                                break;
                            }
                        }

                        datos += "Fecha renta: " + r.getFechaRenta().getFecha() + "\n";
                        datos += "Fecha entrega: " + r.getFechaEntrega().getFecha();

                        JOptionPane.showMessageDialog(null, datos);
                    }
                break;

                case 13:
                    idVehiculo = Integer.parseInt(JOptionPane.showInputDialog("Id del automóvil a eliminar:"));

                    posV = -1;

                    for (int i = 0; i < autos.size(); i++) {
                        if (autos.get(i).getIdVehiculo() == idVehiculo) {
                            res = JOptionPane.showConfirmDialog(null, autos.get(i).getDatos() + "\n¿Eliminar?");
                            if (res == JOptionPane.YES_OPTION) {
                                autos.remove(i);
                                JOptionPane.showMessageDialog(null, "Automóvil eliminado");
                            }
                            posV = i;
                            break;
                        }
                    }

                    if (posV == -1) {
                        JOptionPane.showMessageDialog(null, "No existe ese automóvil");
                    }
                break;

                case 14:
                    idVehiculo = Integer.parseInt(JOptionPane.showInputDialog("Id de la motocicleta a eliminar:"));

                    posV = -1;

                    for (int i = 0; i < motos.size(); i++) {
                        if (motos.get(i).getIdVehiculo() == idVehiculo) {
                            res = JOptionPane.showConfirmDialog(null, motos.get(i).getDatos() + "\n¿Eliminar?");
                            if (res == JOptionPane.YES_OPTION) {
                                motos.remove(i);
                                JOptionPane.showMessageDialog(null, "Motocicleta eliminada");
                            }
                            posV = i;
                            break;
                        }
                    }

                    if (posV == -1) {
                        JOptionPane.showMessageDialog(null, "No existe esa motocicleta");
                    }
                break;

                case 15:
                    idCliente = JOptionPane.showInputDialog("Id del cliente a eliminar:");

                    posC = -1;

                    for (int i = 0; i < clientes.size(); i++) {
                        if (idCliente.equalsIgnoreCase(clientes.get(i).getIdCliente())) {
                            res = JOptionPane.showConfirmDialog(null, clientes.get(i).getDatos() + "\n¿Eliminar?");
                            if (res == JOptionPane.YES_OPTION) {
                                clientes.remove(i);
                                JOptionPane.showMessageDialog(null, "Cliente eliminado");
                            }
                            posC = i;
                            break;
                        }
                    }

                    if (posC == -1) {
                        JOptionPane.showMessageDialog(null, "No existe ese cliente");
                    }
                break;

                case 16:
                    idRenta = Integer.parseInt(JOptionPane.showInputDialog("Id de la renta a eliminar:"));

                    posR = -1;

                    for (int i = 0; i < rentas.size(); i++) {
                        if (rentas.get(i).getIdRenta() == idRenta) {
                            res = JOptionPane.showConfirmDialog(null, rentas.get(i).getDatos() + "\n¿Eliminar?");
                            if (res == JOptionPane.YES_OPTION) {
                                rentas.remove(i);
                                JOptionPane.showMessageDialog(null, "Renta eliminada");
                            }
                            posR = i;
                            break;
                        }
                    }

                    if (posR == -1) {
                        JOptionPane.showMessageDialog(null, "No existe esa renta");
                    }
                break;

                case 17:
                    JOptionPane.showMessageDialog(null, "Gracias por su visita..." + "\nElaborado por: MFAM  WOCM   IISM" + "\nCopyright 2026");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida", "Error", 2);
            }

        } while (op != 17);
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("datos.txt");
            ObjectOutputStream salida = new ObjectOutputStream(fout);

            salida.writeObject(autos);
            salida.writeObject(motos);
            salida.writeObject(clientes);
            salida.writeObject(rentas);

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar archivo");
            }
        }
    }

    //funcion para ver si el vehiculo ya exhiste
    public static boolean existeVehiculo(Vehiculo[] E, int idVehiculo, int cont) {
        boolean existe = false;
        for (int i = 0; i < cont; i++) {
            if (E[i].getIdVehiculo() == idVehiculo) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    //funcion para ver si la renta ya exhiste
    public static boolean existeRenta(Renta[] E, int idRenta, int cont) {
        boolean existe = false;
        for (int i = 0; i < cont; i++) {
            if (E[i].getIdRenta() == idRenta) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    //Funcion para buscar vehiculo
    public static int buscaVehiculo(Vehiculo[] E, int idVehiculo, int cont) {

        for (int i = 0; i < cont; i++) {
            if (idVehiculo == E[i].getIdVehiculo()) {
                return i;
            }
        }
        return -1;
    }

    //Funcion para buscar RENTA
    public static int buscaRenta(Renta[] E, int idRenta, int cont) {

        for (int i = 0; i < cont; i++) {
            if (idRenta == E[i].getIdRenta()) {
                return i;
            }
        }
        return -1;
    }
}