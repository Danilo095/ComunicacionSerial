
package pu.controlador;
import pu.vista.Actuadores;
import static pu.vista.Actuadores.lblRecibir;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.*;
import static pu.vista.Actuadores.lblRecibirArduino;
import pu.controlador.PuertoSerie;

public class SerialArduino extends Thread{
    
    CommPortIdentifier idPuerto;
    SerialPort puertoSerie;
    OutputStream salida;
    InputStream entrada;
    String opcion="";
    private int longitud = -1;
    private byte[] buffer = new byte[1024]; //una inicializacion es  new byte[1024]
    public String aux; //Para que el mensaje se guarde
    //public PuertoSerie puerto;
    PuertoSerie comunicacion = new PuertoSerie();
    public String op="";
    
    
    
    public void txSerial(String dato, String puerto) throws NoSuchPortException, 
            PortInUseException, IOException, UnsupportedCommOperationException
    {
       idPuerto=CommPortIdentifier.getPortIdentifier(puerto);
        System.out.println("Puerto "+puerto+" de arduino identificado");
        if(idPuerto.isCurrentlyOwned()){
            System.out.println("Puerto en uso");
        }else{
            puertoSerie=(SerialPort) idPuerto.open("Puerto", 1000);
            System.out.println("Puerto Abierto");
            puertoSerie.setSerialPortParams(9600, SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            System.out.println("Puerto Configurado");
            salida=puertoSerie.getOutputStream();
            System.out.println("Flujo de salida configurado");
            entrada=puertoSerie.getInputStream();
            System.out.println("Flujo de entrada configurado");
            //opcion=dato;
            this.start();
        }
    }
    
    public void run(){
      
        System.out.println("hilo iniciado");
        while (true) {     
            try {   
                 salida.write(lblRecibir.getText().getBytes());
                 //puerto.tx(lblRecibirArduino.getText());
                if((longitud=entrada.read(buffer))>-1){
                    aux = new String(buffer,0,longitud);
                    System.out.println(aux);
                    Actuadores.lblRecibirArduino.setText(aux);
                    comunicacion.tx(aux);
//                    comunicacion.salida.write(aux.getBytes());
                    //comunicacion.salida.write(lblRecibirArduino.getText());
                }
                
            } catch (IOException ex) {
                Logger.getLogger(SerialArduino.class.getName()).log(Level.SEVERE, null, ex);
            } 
           
                        
            
        }
    }
    
    public void cerrar(){
        try {
            salida.close();
        } catch (IOException ex) {
            Logger.getLogger(SerialArduino.class.getName()).log(Level.SEVERE, null, ex);
        }
        puertoSerie.close();
}
    
}

