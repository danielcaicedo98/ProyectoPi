/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.*;
/**
 *
 * @author daniel
 */
public class ProcesoDos extends Thread{
    MarcoMapa miMarco;
    Vendedor miVendedor;
    Ventas venta;
    
    VentasDao misVentas;
    int unoX = 0, unoY = 1;
    int dosX = 0, dosY = 1;
    int tresX = 0, tresY = 1;
    
    
    Integer coordenadasVendedorUno [] = {
        495, 404, 512, 403, 515, 396, 548, 401,
        567, 385, 570, 379, 578, 367, 582, 358, 585, 352,
        595, 336, 598, 328, 606, 316, 606, 309, 611, 305,
        623, 282, 624, 276, 632, 280, 647, 289, 671, 293,//60
        653, 321, 638, 335, 630, 342, 615, 357, 598, 368,
        581, 393, 573, 400, 563, 396, 557, 397, 525, 397,
        496, 401
    };
    
    Integer coordenadasVendedorDos [] ={ 
        483, 403, 472, 402, 460, 400, 460, 382, 466, 366,
        464, 335, 466, 305, 458, 293, 443, 288, 431, 289,//50
        433, 263, 435, 249, 436, 228, 438, 219, 427, 216,
        420, 256, 417, 281, 416, 304, 411, 327, 411, 347,
        406, 386, 400, 403, 416, 406, 446, 401, 469, 401,
        483, 403    
    };
    
    Integer coordenadasVendedorTres [] = {
        476, 404, 460, 404, 460, 414, 458, 431, 457, 443,
        453, 476, 452, 488, 450, 502 ,
        433, 518, 413, 515, 406, 528, 407, 551,//50
        437, 527, 455, 517, 470, 502, 485, 487, 494, 473,
        523, 437, 539, 418, 534, 411, 518, 396, 491, 401 
    };    
    
    public ProcesoDos(){
        miMarco = new MarcoMapa();
        miVendedor = new Vendedor();
        misVentas = new VentasDao();
        venta = new Ventas();
    }
    
    public void run() {
        for (int i = 0; i < 36; i++) {
            miMarco.setCoordenadasUno(coordenadasVendedorUno[unoX]
                     , coordenadasVendedorUno[unoY]);
            //Función que simula ventas realizadas
            //por los vendedores por cuenta propia
            if(i == 2){ 
                misVentas.actualizarDatos("12129280", "CF28", 3, 1000);
                misVentas.actualizarDatos("12129280", "CR24", 2, 1500);
                 misVentas.actualizarDatos("12129280", "JN27", 3, 1000);
            }else if(i == 4){ 
                misVentas.actualizarDatos("12129280", "HO26", 1, 1000);
                misVentas.actualizarDatos("12129280", "PP23", 2, 2200);
                 misVentas.actualizarDatos("12129280", "JN27", 6, 1000);
            }else if(i == 6){ 
                misVentas.actualizarDatos("12129280", "JN27", 6, 1000);
                misVentas.actualizarDatos("12129280", "PA20", 2, 2500);
            }else if(i == 8){ 
                misVentas.actualizarDatos("12129280", "EM21", 4, 1200);
                misVentas.actualizarDatos("12129280", "DE25", 2, 1200);
            }else if(i == 9){ 
                misVentas.actualizarDatos("12129280", "PC22", 1, 2000);
                misVentas.actualizarDatos("12129280", "CF28", 2, 1000);
            }
            else if(i == 15){ 
                misVentas.actualizarDatos("12129280", "PA20", 3, 2500);
                misVentas.actualizarDatos("12129280", "JN27", 2, 1000);
            } 
            //Función que simula la parada de vendedor1
           if(i != 2&& i != 4 && i != 6 
                    && i != 8 && i != 9 && i != 15){ 
                unoY = unoY + 2;
                unoX = unoX + 2;
                
            }
            
           
          
           
           //Ventas y geolocalización de vendedor 2
            miMarco.setCoordenadasDos(coordenadasVendedorDos[dosX]
                     , coordenadasVendedorDos[dosY]);
            if(i != 1 && i != 3 && i != 7 
                    && i != 11 && i != 13 && i != 16 && i < 31){ 
                dosY = dosY + 2;
                dosX = dosX + 2;
            }
            
            if(i == 1){ 
                misVentas.actualizarDatos("987654321", "PC22", 2, 2000);
                misVentas.actualizarDatos("987654321", "CF28", 3, 1000);
                
            }else if(i == 3){ 
                misVentas.actualizarDatos("987654321", "PA20", 2, 2500);
                misVentas.actualizarDatos("987654321", "JN27", 3, 1000);
                
            }else if(i == 7){ 
                misVentas.actualizarDatos("987654321", "JN27", 2, 1000);
                misVentas.actualizarDatos("987654321", "PA20", 2, 2500);
            }else if(i == 11){ 
                misVentas.actualizarDatos("987654321", "EM21", 4, 1200);
                misVentas.actualizarDatos("987654321", "DE25", 2, 1200);
            }else if(i == 13){ 
                misVentas.actualizarDatos("987654321", "CF28", 2, 1000);
                misVentas.actualizarDatos("987654321", "CR24", 2, 1500);
            }
            else if(i == 16){ 
                misVentas.actualizarDatos("987654321", "HO26", 1, 1000);
                misVentas.actualizarDatos("987654321", "PP23", 2, 2200);
                
            }
            
            
            
            
            miMarco.setCoordenadasTres(coordenadasVendedorTres[tresX]
                     , coordenadasVendedorTres[tresY]);
            if(i != 2 && i != 5 && i != 8 
                    && i != 9 && i != 12 && i != 14 && i < 27){
                tresY = tresY + 2;
                tresX = tresX + 2;
            }
            
            
            if(i == 2){ 
                misVentas.actualizarDatos("12457856", "EM21", 4, 1200);
                misVentas.actualizarDatos("12457856", "PA20", 2, 2500);
                
            }else if(i == 5){ 
                misVentas.actualizarDatos("12457856", "CF28", 3, 1000);
                misVentas.actualizarDatos("12457856", "JN27", 3, 1000);
                
            }else if(i == 8){ 
                misVentas.actualizarDatos("12457856", "JN27", 2, 1000);
                misVentas.actualizarDatos("12457856", "PA20", 2, 2500);
            }else if(i == 9){ 
                misVentas.actualizarDatos("12457856", "EM21", 4, 1200);
                misVentas.actualizarDatos("12457856", "CR24", 6, 1500);
            }else if(i == 12){ 
                misVentas.actualizarDatos("12457856", "CF28", 2, 1000);
                misVentas.actualizarDatos("12457856", "CR24", 2, 1500);
            }
            else if(i == 14){ 
                misVentas.actualizarDatos("12457856", "PA20", 4, 2500);
                misVentas.actualizarDatos("12457856", "PP23", 2, 2200);
                
            }
            
            
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProcesoDos.class.getName()).log(Level.SEVERE, null, ex);
          }
             
        }
    }
    
    public void realizarVenta(String prodUno,String prodDos
                                ,String prodTres,int codigoVendedor){
        
        //actualiza Base Datos, le resta la cantidad de productos vendidos 
        //agrega venta realizadas a la Base Datos venta
    }
    
    public void verMarco(){
        miMarco.setVisible(true);
    }
}
