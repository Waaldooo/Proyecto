package pck_Proyecto;

import javax.swing.JOptionPane;

public class MenuRenta {
   public static void main(String[] args){
       Vehiculo[] vehiculo = new Vehiculo[20]; 
       Renta[] renta = new Renta[20];
       Cliente[] cliente = new Cliente[20];
       Fecha[] fecha = new Fecha[20];
       
       int op, idVehiculo, anio, noPuertas, noVelocidades, noLlantas, idRenta, dia, mes, contV=0;
       String tipo, transmision, modelo, marca, color, idCliente, nombre, telefono, correo;
       
       String menu = " - - - MENU RENTA DE AUTOS Y MOTOS - - -\n\n" +
               "1) Alta de automóvil\n" +
               "2) Alta de una motocicleta\n" +
               "3) Alta de un cliente\n" +
               "4) Alta de una renta\n" +
               "5) Listar automóviles\n" +
               "6) Listar motocicletas\n" +
               "7) Listar clientes\n" +
               "8) Listar rentas\n" +
               "9) Ver detalles de un automóvil\n" +
               "10) Ver detalles de una motocicleta\n" +
               "11) Ver detalles de un cliente\n" +
               "12) Ver detalles de una renta\n" +
               "13) Eliminar un automóvil\n" + 
               "14) Eliminar una motocicleta\n" +
               "15) Eliminar un cliente\n" +
               "16) Eliminar una renta\n" +
               "17) Salir\n" +
               "\nElija una opcion:";
       
       do{
            do{
                op = 0;
                try{
                    op = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Menu de opciones", 3));
                } catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "La opción debe ser numerica", "Error de entrada", 2);
                }
            } while(op == 0);
            
            switch (op){
                case 1:
                    // Alta de automóvil
                   do{
                       idVehiculo = -1;
                       try{
                            idVehiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "Id del Automovil", "Alta de un Automóvil", 3));
                            if(idVehiculo <= 0){
                                JOptionPane.showMessageDialog(null, "El Id del Automóvil debe ser positivo", "Dato Erroneo", 2);
                            } else if(existeVehiculo(vehiculo, idVehiculo, contV)){
                                JOptionPane.showMessageDialog(null, "Id de vehiculo ya existente", "ERROR", 2);
                                idVehiculo = -1;
                            }
                       } catch (NumberFormatException e){
                           JOptionPane.showMessageDialog(null, "El id del automóvil debe ser numerico", "Dato erroneo", 2);
                       }
                   } while (idVehiculo <= 0);
                   
                    modelo = JOptionPane.showInputDialog(null, "Modelo:", "Alta de un Automóvil", 3);
                    
                    marca = JOptionPane.showInputDialog(null, "Marca:", "Alta de un Automóvil", 3);
                    
                    anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Anio:", "Alta de un Automóvil"));
                    
                    color = JOptionPane.showInputDialog(null, "Color:", "Alta de un Automóvil", 3);
                    
                    tipo = JOptionPane.showInputDialog(null, "Tipo:", "Alta de un Automóvil", 3);
                    
                    transmision = JOptionPane.showInputDialog(null, "Transmisión:", "Alta de un Automóvil", 3);
                    
                    noPuertas = Integer.parseInt(JOptionPane.showInputDialog(null, "No. de puertas:", "Alta de un Automóvil", 3));
                    break;
                    
                case 2:
                    // Alta de una motocicleta
                    break;
                    
                case 3:
                    // Alta de un cliente
                    break;
                    
                case 4:
                    // Alta de una renta
                    break;
                    
                case 5:
                    // Listar automóviles
                    break;
                    
                case 6: 
                    // Listar motocicletas
                    break;
                    
                case 7:
                    // Listar clientes
                    break;
                case 8:
                    // Listar rentas
                    break;
                    
                case 9:
                    // Ver detalles de un automóvil
                    break;
                    
                case 10:
                    // Ver detalles de una motocicleta
                    break;
                    
                case 11:
                    // Ver detalles de un cliente
                    break;
                    
                case 12:
                    // Ver detalles de una renta
                    break;
                    
                case 13:
                    // Eliminar un automóvil
                    break;
                    
                case 14:
                    // Eliminar una motocicleta
                    break;
                    
                case 15: 
                    // Eliminar un cliente
                    break;
                    
                case 16:
                    // Eliminar una renta
                    break;
                    
                case 17:
                    // Salir
                    break;
                    
            }
            
       } while( op != 17);
   } 
   
   public static boolean existeVehiculo(Vehiculo[] E, int idVehiculo, int cont){
       boolean existe = false;
       for(int i = 0; i < cont; i++){
           existe = true;
           break;
       }
       return existe;
   }
}
