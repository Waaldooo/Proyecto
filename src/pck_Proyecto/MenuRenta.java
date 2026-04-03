package pck_Proyecto;

import javax.swing.JOptionPane;

public class MenuRenta {

    public static void main(String[] args) {
        //Arreglos
        Vehiculo[] vehiculo = new Vehiculo[20];
        Renta[] renta = new Renta[20];
        Cliente[] cliente = new Cliente[20];
        Fecha[] fecha = new Fecha[20];
        //Variables
        int op, idVehiculo, anio, noPuertas, noVelocidades, noLlantas, idRenta, dia, mes, contV = 0, contR = 0, busVehiculo, posV, posR, posC, res;
        String tipo, transmision, modelo, marca, color, idCliente, nombre, telefono, correo, listaAutomoviles, listaMotocicletas, listaClientes, listaRentas;
        boolean encontrado;

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
                    // Alta de automóvil
                    do {
                        idVehiculo = -1;
                        try {
                            idVehiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "Id del Automovil:", "Alta de un Automóvil", 3));
                            if (idVehiculo <= 0) {
                                JOptionPane.showMessageDialog(null, "El Id del Automóvil debe ser positivo", "Dato Erroneo", 2);
                            } else if (existeVehiculo(vehiculo, idVehiculo, contV)) {
                                JOptionPane.showMessageDialog(null, "Id de vehiculo ya existente", "Dato Erroneo", 2);
                                idVehiculo = -1;
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "El id del automóvil debe ser numerico", "Dato erroneo", 2);
                        }
                    } while (idVehiculo <= 0);

                    do {
                        modelo = JOptionPane.showInputDialog(null, "Modelo:", "Alta de un Automóvil", 3);
                        if (modelo.isBlank()) {
                            JOptionPane.showMessageDialog(null, "El modelo es algo requerido.", "Dato Erroneo", 2);
                        }
                    } while (modelo.isBlank());

                    do {
                        marca = JOptionPane.showInputDialog(null, "Marca:", "Alta de un Automóvil", 3);
                        if (marca.isBlank()) {
                            JOptionPane.showMessageDialog(null, "La marca es algo requerido.", "Dato Erroneo", 2);
                        }
                    } while (marca.isBlank());

                    do {
                        anio = 0;
                        try {
                            anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Año:", "Alta de un Automóvil"));
                            if (anio < 1900 || anio > 2027) {
                                JOptionPane.showMessageDialog(null, "El año debe se estar entre 1900 y 2027", "Dato Erroneo", 2);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "El año debe ser numerico", "Dato Erroneo", 2);
                        }
                    } while (anio < 1900 || anio > 2027);

                    do {
                        color = JOptionPane.showInputDialog(null, "Color:", "Alta de un Automóvil", 3);
                        if (color.isBlank()) {
                            JOptionPane.showMessageDialog(null, "El color es algo requerido", "Dato Erroneo", 2);
                        }
                    } while (color.isBlank());

                    do {
                        tipo = JOptionPane.showInputDialog(null, "Tipo:", "Alta de un Automóvil", 3);
                        if (tipo.isBlank()) {
                            JOptionPane.showMessageDialog(null, "El tipo es algo requerido", "Dato Erroneo", 2);
                        }
                    } while (tipo.isBlank());

                    do {
                        transmision = JOptionPane.showInputDialog(null, "Transmisión:", "Alta de un Automóvil", 3);
                        if (transmision.isBlank()) {
                            JOptionPane.showMessageDialog(null, "La transmision es algo requerido", "Dato Erroneo", 2);
                        }
                    } while (transmision.isBlank());

                    do {
                        noPuertas = 0;
                        try {
                            noPuertas = Integer.parseInt(JOptionPane.showInputDialog(null, "No. de puertas:", "Alta de un Automóvil", 3));
                            if (noPuertas < 2 || noPuertas > 4) {
                                JOptionPane.showMessageDialog(null, "El no. de puertas debe ser entre 2 y 4", "Dato Erroneo", 2);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "El no. de puertas de ser numerico", "Dato Erroneo", 2);
                        }
                    } while (noPuertas < 2 || noPuertas > 4);
                    break;

                case 2:
                    // Alta de una motocicleta
                    do {
                        idVehiculo = -1;
                        try {
                            idVehiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "Id de la Motocicleta:", "Alta de una Motocicleta", 3));
                            if (idVehiculo <= 0) {
                                JOptionPane.showMessageDialog(null, "El Id de la motocicleta debe ser positivo", "Dato Erroneo", 2);
                            } else if (existeVehiculo(vehiculo, idVehiculo, contV)) {
                                JOptionPane.showMessageDialog(null, "Id de vehiculo ya existente", "Dato Erroneo", 2);
                                idVehiculo = -1;
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "El id de la mocicleta debe ser numerico", "Dato Erroneo", 2);
                        }
                    } while (idVehiculo <= 0);

                    do {
                        modelo = JOptionPane.showInputDialog(null, "Modelo:", "Alta de una Motocicleta", 3);
                        if (modelo.isBlank()) {
                            JOptionPane.showMessageDialog(null, "El modelo es algo requerido.", "Dato Erroneo", 2);
                        }
                    } while (modelo.isBlank());

                    do {
                        marca = JOptionPane.showInputDialog(null, "Marca:", "Alta de una Motocicleta", 3);
                        if (marca.isBlank()) {
                            JOptionPane.showMessageDialog(null, "La marca es algo requerido.", "Dato Erroneo", 2);
                        }
                    } while (marca.isBlank());

                    do {
                        anio = 0;
                        try {
                            anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Año:", "Alta de una Motocicleta"));
                            if (anio < 1900 || anio > 2027) {
                                JOptionPane.showMessageDialog(null, "El año debe se estar entre 1900 y 2027", "Dato Erroneo", 2);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "El año debe ser numerico", "Dato Erroneo", 2);
                        }
                    } while (anio < 1900 || anio > 2027);

                    do {
                        color = JOptionPane.showInputDialog(null, "Color:", "Alta de una Motocicleta", 3);
                        if (color.isBlank()) {
                            JOptionPane.showMessageDialog(null, "El color es algo requerido", "Dato Erroneo", 2);
                        }
                    } while (color.isBlank());

                    do {
                        tipo = JOptionPane.showInputDialog(null, "Tipo:", "Alta de una Motocicleta", 3);
                        if (tipo.isBlank()) {
                            JOptionPane.showMessageDialog(null, "El tipo es algo requerido", "Dato Erroneo", 2);
                        }
                    } while (tipo.isBlank());

                    do {
                        noVelocidades = 0;
                        try {
                            noVelocidades = Integer.parseInt(JOptionPane.showInputDialog(null, "No. de velocidades:", "Alta de una motocicleta", 3));
                            if (noVelocidades < 4 || noVelocidades > 7) {
                                JOptionPane.showMessageDialog(null, "El no. de velocidades debe estar entre 4 y 7", "Dato Erroneo", 2);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "El no. de velocidades debe ser numerico", "Dato Erroneo", 2);
                        }
                    } while (noVelocidades < 4 || noVelocidades > 7);

                    do {
                        noLlantas = 0;
                        try {
                            noLlantas = Integer.parseInt(JOptionPane.showInputDialog(null, "No. de llantas:", "Alta de una motocicleta", 3));
                            if (noLlantas != 2) {
                                JOptionPane.showMessageDialog(null, "El no. de llantas debe ser igual a 2 para que sea moto", "Dato erroneo", 2);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "El no. de llantas debe ser numerico", "Dato erroneo", 2);
                        }
                    } while (noLlantas != 2);
                    break;

                case 3:
                    // Alta de un cliente
                    do {
                        idCliente = JOptionPane.showInputDialog(null, "Id del cliente:", "Alta de un Cliente", 3);
                        if (idCliente.isBlank()) {
                            JOptionPane.showMessageDialog(null, "El id del cliente es algo requerido", "Dato ]Erroneo", 2);
                        }
                    } while (idCliente.isBlank());

                    do {
                        nombre = JOptionPane.showInputDialog(null, "Nombre del cliente:", "Alta de un Cliente", 3);
                        if (idCliente.isBlank()) {
                            JOptionPane.showMessageDialog(null, "El nombre del cliente es algo requerido", "Dato ]Erroneo", 2);
                        }
                    } while (idCliente.isBlank());

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

                    boolean fechaValida;
                    do {
                        do {
                            dia = 0;
                            try {
                                dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Dia de nacimiento:", "Alte de un cliente", 3));
                                if (dia <= 0 || dia > 31) {
                                    JOptionPane.showMessageDialog(null, "El dia debe estar entre 1 y 31", "Dato erroneo", 2);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El dia debe ser numerico", "Error", 2);
                            }
                        } while (dia <= 0 || dia > 31);

                        do {
                            mes = 0;
                            try {
                                mes = Integer.parseInt(
                                        JOptionPane.showInputDialog(null, "Mes de nacimioento:", "Alta de un cliente", 3));
                                if (mes <= 0 || mes > 12) {
                                    JOptionPane.showMessageDialog(null, "El mes debe estar entre 1 y 12", "Dato erroneo", 2);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El mes debe ser numerico", "Error", 2);
                            }
                        } while (mes <= 0 || mes > 12);

                        do {
                            anio = 0;
                            try {
                                anio = Integer.parseInt(
                                        JOptionPane.showInputDialog(null, "Año de nacimiento:", "Alta de un cliente", 3));
                                if (anio > 2008 || anio > 1920) {
                                    JOptionPane.showMessageDialog(null, "El Cliente debe ser mayor de edad", "Dato erroneo", 2);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El año debe ser numerico", "Error", 2);
                            }
                        } while (anio > 2008 || anio > 1920);
                        fecha.setFecha(dia, mes, anio);
                        fechaValida = fecha.fechaCorrecta();
                        if (!fechaValida) {
                            JOptionPane.showMessageDialog(null, "La fecha completa no es valida", "Error", 2);
                        }
                    } while (!fechaValida);

                    do {
                        correo = JOptionPane.showInputDialog(null, "Correo:", "Alta de un Cliente", 3);
                        if (correo.isBlank()) {
                            JOptionPane.showMessageDialog(null, "El correo es algo requerido", "Dato Erroneo", 2);
                        }
                    } while (correo.isBlank());
                    break;

                case 4:
                    // Alta de una renta
                    do {
                        idRenta = -1;
                        try {
                            idRenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Id de la Renta:", "Alta de una Renta", 3));
                            if (idRenta <= 0) {
                                JOptionPane.showMessageDialog(null, "El Id de la renta debe ser positivo", "Dato Erroneo", 2);
                            } else if (existeRenta(renta, idRenta, contR)) {
                                JOptionPane.showMessageDialog(null, "Id de la renta ya existente", "Dato Erroneo", 2);
                                idVehiculo = -1;
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "El id de la renta debe ser numerico", "Dato Erroneo", 2);
                        }
                    } while (idRenta <= 0);

                    do {
                        idVehiculo = -1;
                        try {
                            idVehiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "Id del Vehiculo:", "Alta de una Renta", 3));
                            if (idVehiculo <= 0) {
                                JOptionPane.showMessageDialog(null, "El Id de la motocicleta debe ser positivo", "Dato Erroneo", 2);
                            } else {
                                busVehiculo = buscaVehiculo(vehiculo, idVehiculo, contV);
                            }
                            if (busVehiculo == -1) {
                                JOptionPane.showMessageDialog(null, "El id del vehiculo no existe", "Sin datos", 1);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "El id del vehiculo debe ser numerico", "Dato Erroneo", 2);
                        }
                    } while (idVehiculo <= 0);

                    do {
                        idCliente = JOptionPane.showInputDialog(null, "Id del cliente:", "Alta de un Cliente", 3);
                        if (idCliente.isBlank()) {
                            JOptionPane.showMessageDialog(null, "El id del cliente es algo requerido", "Dato ]Erroneo", 2);
                        }
                    } while (idCliente.isBlank());
                    // Fecha de renta
                    boolean fechaValida;
                    do {
                        do {
                            dia = 0;
                            try {
                                dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Dia de Renta:", "Alte de una Renta", 3));
                                if (dia <= 0 || dia > 31) {
                                    JOptionPane.showMessageDialog(null, "El dia debe estar entre 1 y 31", "Dato erroneo", 2);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El dia debe ser numerico", "Error", 2);
                            }
                        } while (dia <= 0 || dia > 31);

                        do {
                            mes = 0;
                            try {
                                mes = Integer.parseInt(
                                        JOptionPane.showInputDialog(null, "Mes de Renta:", "Alta de una Renta", 3));
                                if (mes <= 0 || mes > 12) {
                                    JOptionPane.showMessageDialog(null, "El mes debe estar entre 1 y 12", "Dato erroneo", 2);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El mes debe ser numerico", "Error", 2);
                            }
                        } while (mes <= 0 || mes > 12);

                        do {
                            anio = 0;
                            try {
                                anio = Integer.parseInt(
                                        JOptionPane.showInputDialog(null, "Año de Renta:", "Alta de una Renta", 3));
                                if (anio > 2026 || anio > 1900) {
                                    JOptionPane.showMessageDialog(null, "El año debe ser entre 2026 y 2000", "Dato erroneo", 2);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El año debe ser numerico", "Error", 2);
                            }
                        } while (anio > 2026 || anio > 1900);
                        fecha.setFecha(dia, mes, anio);
                        fechaValida = fecha.fechaCorrecta();
                        if (!fechaValida) {
                            JOptionPane.showMessageDialog(null, "La fecha completa no es valida", "Error", 2);
                        }
                    } while (!fechaValida);
                    //Fecha de entrega
                    boolean fechaValida;
                    do {
                        do {
                            dia = 0;
                            try {
                                dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Dia de Renta:", "Alte de una Renta", 3));
                                if (dia <= 0 || dia > 31) {
                                    JOptionPane.showMessageDialog(null, "El dia debe estar entre 1 y 31", "Dato erroneo", 2);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El dia debe ser numerico", "Error", 2);
                            }
                        } while (dia <= 0 || dia > 31);

                        do {
                            mes = 0;
                            try {
                                mes = Integer.parseInt(
                                        JOptionPane.showInputDialog(null, "Mes de Renta:", "Alta de una Renta", 3));
                                if (mes <= 0 || mes > 12) {
                                    JOptionPane.showMessageDialog(null, "El mes debe estar entre 1 y 12", "Dato erroneo", 2);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El mes debe ser numerico", "Error", 2);
                            }
                        } while (mes <= 0 || mes > 12);

                        do {
                            anio = 0;
                            try {
                                anio = Integer.parseInt(
                                        JOptionPane.showInputDialog(null, "Año de Renta:", "Alta de una Renta", 3));
                                if (anio > 2026 || anio > 1900) {
                                    JOptionPane.showMessageDialog(null, "El año debe ser entre 2026 y 2000", "Dato erroneo", 2);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El año debe ser numerico", "Error", 2);
                            }
                        } while (anio > 2026 || anio > 1900);
                        fecha.setFecha(dia, mes, anio);
                        fechaValida = fecha.fechaCorrecta();
                        if (!fechaValida) {
                            JOptionPane.showMessageDialog(null, "La fecha completa no es valida", "Error", 2);
                        }
                    } while (!fechaValida);
                    break;

                case 5:
                    // Listar automóviles
                    encontrado = false;
                    listaAutomoviles = "        LISTA DE AUTOMÓVILES        " + "\nId Vehículo    Modelo    Marca   Tipo     Transmisión\n" + "- - - - - - - - - - - - - - - -\n";
                    for (int i = 0; i < contV; i++) {
                        if (vehiculo[i] instanceof Automovil) {
                            encontrado = true;
                            Automovil a = (Automovil) vehiculo[i];
                            listaAutomoviles += a.getIdVehiculo() + "      "
                                    + a.getModelo() + "       "
                                    + a.getMarca() + "      "
                                    + a.getTipo() + "      "
                                    + a.getTransmision();
                        }
                    }
                    if (encontrado) {
                        JOptionPane.showMessageDialog(null, listaAutomoviles, "Lista de Automoviles", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Aun no hay Automóviles registrados...", "Sin registro", 1);
                    }
                    break;

                case 6:
                    // Listar motocicletas
                    encontrado = false;
                    listaMotocicletas = "        LISTA DE MOTOCICLETAS        " + "\nId Vehículo    Modelo    Marca   No. Llantas     Tipo\n" + "- - - - - - - - - - - - - - - -\n";
                    for (int i = 0; i < contV; i++) {
                        if (vehiculo[i] instanceof Motocicleta) {
                            encontrado = true;
                            Motocicleta m = (Motocicleta) vehiculo[i];
                            listaAutomoviles += m.getIdVehiculo() + "      "
                                    + m.getModelo() + "       "
                                    + m.getMarca() + "      "
                                    + m.getNoLanta() + "      "
                                    + m.getTipo();
                        }
                    }
                    if (encontrado) {
                        JOptionPane.showMessageDialog(null, listaMotocicletas, "Lista de Motocicletas", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Aun no hay Motocicletas registrados...", "Sin registro", 1);
                    }
                    break;

                case 7:
                    // Listar clientes - error del ciclo
                    encontrado = false;
                    listaClientes = "        LISTA DE CLIENTES        " + "\nId Cliente    Nombre    Tipo   Fecha de Nacimiento\n" + "- - - - - - - - - - - - - - - -\n";
                    for (int i = 0; i < cont; i++) {
                        if (cliente[i] instanceof Cliente) {
                            encontrado = true;
                            Cliente c = (Cliente) cliente[i];
                            listaClientes += c.getIdCliente() + "      "
                                    + c.getNombre() + "       "
                                    + c.getTipo() + "      "
                                    + c.getFechaNacimiento() + "      ";
                        }
                    }
                    if (encontrado) {
                        JOptionPane.showMessageDialog(null, listaClientes, "Lista de Clientes", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Aun no hay Clientes registrados...", "Sin registro", 1);
                    }
                    break;
                case 8:
                    // Listar rentas
                    encontrado = false;
                    listaRentas = "        LISTA DE RENTAS        " + "\nId Renta    Id Vehículo    Id Cliente   Fecha Renta\n" + "- - - - - - - - - - - - - - - -\n";
                    for (int i = 0; i < contR; i++) {
                        if (renta[i] instanceof Renta) {
                            encontrado = true;
                            Renta a = (Renta) renta[i];
                            listaRentas += a.getIdRenta() + "      "
                                    + a.getIdVehiculo() + "       "
                                    + a.getIdCliente() + "      "
                                    + a.getFechaRenta() + "      ";
                        }
                    }
                    if (encontrado) {
                        JOptionPane.showMessageDialog(null, listaRentas, "Lista de Rentas", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Aun no hay Rentas registrados...", "Sin registro", 1);
                    }
                    break;

                case 9:
                    // Ver detalles de un automóvil
                    do {
                        idVehiculo = -1;
                        try {
                            idVehiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id del Automovil que desea consultar: ", "Consulta de un Automovil", 3));
                            if (idVehiculo <= 0) {
                                JOptionPane.showMessageDialog(null, "El id del automovil debe ser positivo", "Dato Erroneo", 2);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "El id del automovil debe ser numerico", "Dato Erroneo", 2);
                        }
                    } while (idVehiculo <= 0);
                    posV = buscaVehiculo(vehiculo, idVehiculo, contV, 1);
                    if (posV == -1) {
                        JOptionPane.showMessageDialog(null, "No se encontro ese id de automovil\n Verifique", "No Registrado", 1);
                    } else if (posV == -2) {
                        JOptionPane.showMessageDialog(null, "El id no corresponde al de un automovil", "Id de Automovil Incorrecto", 2);
                    } else {
                        JOptionPane.showMessageDialog(null, vehiculo[posV].getDatos(), "Consulta de un Automovil", 1);
                    }
                    break;

                case 10:
                    // Ver detalles de una motocicleta
                    do {
                        idVehiculo = -1;
                        try {
                            idVehiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id de la Motocicleta que desea consultar: ", "Consulta de una Motocicleta", 3));
                            if (idVehiculo <= 0) {
                                JOptionPane.showMessageDialog(null, "El id de la motocicleta debe ser positivo", "Dato Erroneo", 2);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "El id de la motocicleta debe ser numerico", "Dato Erroneo", 2);
                        }
                    } while (idVehiculo <= 0);
                    posV = buscaVehiculo(vehiculo, idVehiculo, contV, 2);
                    if (posV == -1) {
                        JOptionPane.showMessageDialog(null, "No se encontro ese id de automovil\n Verifique", "No Registrado", 1);
                    } else if (posV == -2) {
                        JOptionPane.showMessageDialog(null, "El id no corresponde al de un automovil", "Id de Motocicleta Incorrecto", 2);
                    } else {
                        JOptionPane.showMessageDialog(null, vehiculo[posV].getDatos(), "Consulta de una Motocicleta", 1);
                    }
                    break;

                case 11:
                    // Ver detalles de un cliente
                    idCliente = JOptionPane.showInputDialog(null, "Id del cliente: ", "Buscar Cliente", 3);
                    posC = -1;
                    for (int i = 0; i < idCliente.size(); i++) {
                        if (idCliente.equalsIgnoreCase(cliente.get(i).getIdCliente())) {
                            JOptionPane.showMessageDialog(null, cliente.get(i).getDatos());
                            posC = i;
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "El Id del Cliente no esta registrado.", "Cliente no  encontrado", 1);
                        }
                    }
                    if (posC == -1) {
                        JOptionPane.showMessageDialog(null, "El Id del Cliente no esta disponible", "Cliente no encontrado", 1);
                    }
                    break;

                case 12:
                    // Ver detalles de una renta
                    do {
                        idRenta = -1;
                        try {
                            idRenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id de la Renta que desea consultar: ", "Consulta de una Renta", 3));
                            if (idRenta <= 0) {
                                JOptionPane.showMessageDialog(null, "El id de la renta debe ser positivo", "Dato Erroneo", 2);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "El id de la renta debe ser numerico", "Dato Erroneo", 2);
                        }
                    } while (idRenta <= 0);
                    posR = buscaRenta(renta, idRenta, contR, 1);
                    if (posR == -1) {
                        JOptionPane.showMessageDialog(null, "No se encontro ese id de la renta\n Verifique", "No Registrado", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, renta[posR].getDatos(), "Consulta de una Motocicleta", 1);
                    }
                    break;

                case 13:
                    // Eliminar un automóvil
                    String input = JOptionPane.showInputDialog(null, "Id del automóvil que desea eliminar: ", "Eliminar un Automóvil", 3);
                    idVehiculo = Integer.parseInt(input);
                    res;
                    posV = -1;
                    // Buscar vehículo
                    for (int i = 0; i < vehiculo.length; i++) {
                        if (vehiculo[i] != null && idVehiculo == vehiculo[i].getIdVehiculo()) {
                            JOptionPane.showMessageDialog(null, vehiculo[i].getDatos());
                            res = JOptionPane.showConfirmDialog(null, vehiculo[i].getDatos() + "\n\n¿Está seguro de eliminar este Automóvil?", "Automóvil Encontrado", JOptionPane.YES_NO_OPTION);
                            if (res == JOptionPane.YES_OPTION) {
                                posV = i;
                                // Eliminar (corrimiento)
                                for (int j = i; j < vehiculo.length - 1; j++) {
                                    vehiculo[j] = vehiculo[j + 1];
                                }
                                vehiculo[vehiculo.length - 1] = null;
                                JOptionPane.showMessageDialog(null, "Automóvil Eliminado", "Eliminar Automóvil", 3);
                            }
                            break;
                        }
                    }
                    // No encontrado
                    if (posV == -1) {
                        JOptionPane.showMessageDialog(null, "El id del automóvil no está disponible", "Automóvil no encontrado", 2);
                    }
                    break;

                case 14:
                    // Eliminar una motocicleta
                    String input = JOptionPane.showInputDialog(null, "Id de la Motocicleta que desea eliminar: ", "Eliminar una Motocicleta", 3);
                    idVehiculo = Integer.parseInt(input);
                    res;
                    posV = -1;
                    // Buscar vehículo
                    for (int i = 0; i < vehiculo.length; i++) {
                        if (vehiculo[i] != null && idVehiculo == vehiculo[i].getIdVehiculo()) {
                            JOptionPane.showMessageDialog(null, vehiculo[i].getDatos());
                            res = JOptionPane.showConfirmDialog(null,
                                    vehiculo[i].getDatos() + "\n\n¿Está seguro de eliminar esta Motocicleta?", "Motocicleta Encontrada", JOptionPane.YES_NO_OPTION);
                            if (res == JOptionPane.YES_OPTION) {
                                posV = i;
                                // Eliminar (corrimiento)
                                for (int j = i; j < vehiculo.length - 1; j++) {
                                    vehiculo[j] = vehiculo[j + 1];
                                }
                                vehiculo[vehiculo.length - 1] = null;
                                JOptionPane.showMessageDialog(null, "Automóvil Eliminado", "Eliminar Motocicleta", 3);
                            }
                            break;
                        }
                    }
                    // No encontrado
                    if (posV == -1) {
                        JOptionPane.showMessageDialog(null, "El id de la Motocicleta no está disponible", "Motocicleta no encontrado", 2);
                    }
                    break;

                case 15:
                    // Eliminar un cliente
                    idCliente = JOptionPane.showInputDialog(null, "Id del cliente que desea eliminar: ", "Eliminar un Cliente", 3);
                    res;
                    posC = -1;
                    // Buscar cliente
                    for (int i = 0; i < cliente.length; i++) {
                        if (cliente[i] != null && idCliente.equalsIgnoreCase(cliente[i].getIdCliente())) {
                            JOptionPane.showMessageDialog(null, cliente[i].getDatos());
                            res = JOptionPane.showConfirmDialog(null, cliente[i].getDatos() + "\n\n¿Está seguro de eliminar este Cliente?", "Cliente Encontrado", JOptionPane.YES_NO_OPTION);
                            if (res == JOptionPane.YES_OPTION) {
                                posC = i;
                                // Eliminar (corrimiento)
                                for (int j = i; j < cliente.length - 1; j++) {
                                    cliente[j] = cliente[j + 1];
                                }
                                cliente[cliente.length - 1] = null;
                                JOptionPane.showMessageDialog(null, "Cliente Eliminado", "Eliminar Cliente", 3);
                            }
                            break;
                        }
                    }
                    // No encontrado
                    if (posC == -1) {
                        JOptionPane.showMessageDialog(null, "El id del cliente no está disponible", "Cliente no encontrado", 2);
                    }
                    break;

                case 16:
                    // Eliminar una renta
                    String input = JOptionPane.showInputDialog(null, "Id de la Renta que desea eliminar: ", "Eliminar una Renta", 3);
                    idRenta = Integer.parseInt(input);
                    res;
                    posR = -1;
                    // Buscar vehículo
                    for (int i = 0; i < renta.length; i++) {
                        if (renta[i] != null && idRenta == renta[i].getIdRenta()) {
                            JOptionPane.showMessageDialog(null, renta[i].getDatos());
                            res = JOptionPane.showConfirmDialog(null, renta[i].getDatos() + "\n\n¿Está seguro de eliminar esta Renta?", "Renta Encontrada", JOptionPane.YES_NO_OPTION);
                            if (res == JOptionPane.YES_OPTION) {
                                posR = i;
                                // Eliminar (corrimiento)
                                for (int j = i; j < renta.length - 1; j++) {
                                    renta[j] = renta[j + 1];
                                }
                                renta[renta.length - 1] = null; JOptionPane.showMessageDialog(null, "Renta Eliminada", "Eliminar Renta", 3);
                            }
                            break;
                        }
                    }
                    // No encontrado
                    if (posR == -1) {
                        JOptionPane.showMessageDialog(null, "El id de la renta no está disponible", "Renta no encontrada", 2);
                    }
                    break;

                case 17:
                    // Salir
                    JOptionPane.showMessageDialog(null, "Gracias por su visita..." + "\nElaborado por: MFAM  WOCM   IISM" + "\nCopyright 2026");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida", "Error", 2);
            }

        } while (op != 17);
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