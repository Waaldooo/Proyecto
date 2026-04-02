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
                            idVehiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "Id del Automovil:", "Alta de un Automóvil", 3));
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
                   
                   do{
                        modelo = JOptionPane.showInputDialog(null, "Modelo:", "Alta de un Automóvil", 3);
                        if(modelo.isBlank()){
                            JOptionPane.showMessageDialog(null, "El modelo es algo requerido.", "Dato erroneo", 2);
                        }
                   } while(modelo.isBlank());
                   
                   do{
                        marca = JOptionPane.showInputDialog(null, "Marca:", "Alta de un Automóvil", 3);
                        if(marca.isBlank()){
                            JOptionPane.showMessageDialog(null, "La marca es algo requerido.", "Dato Erroneo", 2);
                        }
                   } while(marca.isBlank());
                   
                   do{
                       anio = 0;
                       try{
                            anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Año:", "Alta de un Automóvil"));
                            if(anio < 1900 || anio > 2027){
                                JOptionPane.showMessageDialog(null, "El año debe se estar entre 1900 y 2027", "Dato erroneo", 2);
                            }
                       }catch(NumberFormatException e){
                           JOptionPane.showMessageDialog(null, "El año debe ser numerico", "Dato erroneo", 2);
                       }
                   } while (anio < 1900 || anio > 2027);
                   
                   do{
                        color = JOptionPane.showInputDialog(null, "Color:", "Alta de un Automóvil", 3);
                        if(color.isBlank()){
                            JOptionPane.showMessageDialog(null, "El color es algo requerido", "Dato erroneo", 2);
                        }
                   } while(color.isBlank());
                   
                   do{
                        tipo = JOptionPane.showInputDialog(null, "Tipo:", "Alta de un Automóvil", 3);
                        if(tipo.isBlank()){
                            JOptionPane.showMessageDialog(null, "El tipo es algo requerido", "Dato erroneo", 2);
                        }
                   } while(tipo.isBlank());
                   
                   do{
                        transmision = JOptionPane.showInputDialog(null, "Transmisión:", "Alta de un Automóvil", 3);
                        if(transmision.isBlank()){
                            JOptionPane.showMessageDialog(null, "La transmision es algo requerido", "Dato erroneo", 2);
                        }
                   } while(transmision.isBlank());
                   
                   do{
                       noPuertas = 0;
                       try{
                            noPuertas = Integer.parseInt(JOptionPane.showInputDialog(null, "No. de puertas:", "Alta de un Automóvil", 3));
                            if(noPuertas < 2 || noPuertas > 4){
                                JOptionPane.showMessageDialog(null, "El no. de puertas debe ser entre 2 y 4", "Dato erroneo", 2);
                            }
                       }catch(NumberFormatException e){
                           JOptionPane.showMessageDialog(null, "El no. de puertas de ser numerico", "Dato erroneo", 2);
                       }
                   } while(noPuertas < 2 || noPuertas > 4);
                    break;
                    
                case 2:
                    // Alta de una motocicleta
                    do{
                       idVehiculo = -1;
                       try{
                            idVehiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "Id del Automovil:", "Alta de un Automóvil", 3));
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
                   
                   do{
                        modelo = JOptionPane.showInputDialog(null, "Modelo:", "Alta de un Automóvil", 3);
                        if(modelo.isBlank()){
                            JOptionPane.showMessageDialog(null, "El modelo es algo requerido.", "Dato erroneo", 2);
                        }
                   } while(modelo.isBlank());
                   
                   do{
                        marca = JOptionPane.showInputDialog(null, "Marca:", "Alta de un Automóvil", 3);
                        if(marca.isBlank()){
                            JOptionPane.showMessageDialog(null, "La marca es algo requerido.", "Dato Erroneo", 2);
                        }
                   } while(marca.isBlank());
                   
                   do{
                       anio = 0;
                       try{
                            anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Año:", "Alta de un Automóvil"));
                            if(anio < 1900 || anio > 2027){
                                JOptionPane.showMessageDialog(null, "El año debe se estar entre 1900 y 2027", "Dato erroneo", 2);
                            }
                       }catch(NumberFormatException e){
                           JOptionPane.showMessageDialog(null, "El año debe ser numerico", "Dato erroneo", 2);
                       }
                   } while (anio < 1900 || anio > 2027);
                   
                   do{
                        color = JOptionPane.showInputDialog(null, "Color:", "Alta de un Automóvil", 3);
                        if(color.isBlank()){
                            JOptionPane.showMessageDialog(null, "El color es algo requerido", "Dato erroneo", 2);
                        }
                   } while(color.isBlank());
                   
                   do{
                        tipo = JOptionPane.showInputDialog(null, "Tipo:", "Alta de un Automóvil", 3);
                        if(tipo.isBlank()){
                            JOptionPane.showMessageDialog(null, "El tipo es algo requerido", "Dato erroneo", 2);
                        }
                   } while(tipo.isBlank());
                   
                   do{
                        noVelocidades = 0;
                        try{
                            noVelocidades = Integer.parseInt(JOptionPane.showInputDialog(null, "No. de velocidades:", "Alta de una motocicleta", 3));
                            if(noVelocidades < 4 || noVelocidades > 7){
                                JOptionPane.showMessageDialog(null, "El no. de velocidades debe estar entre 4 y 7");
                            }
                        } catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null, "El no. de velocidades debe ser numerico", "Dato erroneo", 2);
                        }
                   } while(noVelocidades < 4 || noVelocidades > 7);
                   
                   do{
                       noLlantas = 0;
                       try{
                            noLlantas = Integer.parseInt(JOptionPane.showInputDialog(null, "No. de llantas:", "Alta de una motocicleta", 3));
                            if(noLlantas != 2){
                                JOptionPane.showMessageDialog(null, "El no. de llantas debe ser igual a 2 para que sea moto", "Dato erroneo", 2);
                            }
                       } catch(NumberFormatException e){
                           JOptionPane.showMessageDialog(null, "El no. de llantas debe ser numerico", "Dato erroneo", 2);
                       }
                   } while(noLlantas != 2);
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
           if(E[i].getIdVehiculo() == idVehiculo){
           existe = true;
           break;
           }
       }
       return existe;
   }
}
