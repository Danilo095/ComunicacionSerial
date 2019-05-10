
package pu.controlador;

import pu.vista.Actuadores;
import java.io.*;
import javax.comm.*;

public class PuertoSerie extends Thread {
    
    CommPortIdentifier idPuerto;
    SerialPort puertoSerie;
    public OutputStream salida;
    public InputStream entrada;
    
    public int longitud = -1;
    public byte[] buffer = new byte[1024]; //una inicializacion es  new byte[1024]
    public String aux=""; //Para que el mensaje se guarde
    
    
    
    public PuertoSerie(String puerto) throws NoSuchPortException, PortInUseException, IOException, UnsupportedCommOperationException
    {
       idPuerto=CommPortIdentifier.getPortIdentifier(puerto);
        System.out.println("Puerto "+puerto+" de arduino identificado");
        if(idPuerto.isCurrentlyOwned()){
            System.out.println("Puerto en uso");
        }else{
            puertoSerie=(SerialPort) idPuerto.open("Puerto", 1000);
            System.out.println("Puerto Abierto");
            salida=puertoSerie.getOutputStream();
            entrada=puertoSerie.getInputStream();
            puertoSerie.setSerialPortParams(115200, SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            System.out.println("Puerto Configurado");
            this.start();

        }
    }

    public PuertoSerie(CommPortIdentifier idPuerto, SerialPort puertoSerie, OutputStream salida, InputStream entrada) {
        this.idPuerto = idPuerto;
        this.puertoSerie = puertoSerie;
        this.salida = salida;
        this.entrada = entrada;
    }

    public PuertoSerie() {
    }

    

  

    public void tx(String mensaje){
        
        try {
            salida.write(mensaje.getBytes());
          
        } catch (Exception ex) {
               System.out.println(ex);
        }
     
    }
    
    
    public void run() {
        System.out.println("hilo iniciado");
        while (true) {            
            
            try {
                //salida.write(Actuadores.lblRecibirArduino.getText().getBytes());
                if((longitud=entrada.read(buffer))>-1){
                    
                    aux = new String(buffer,0,longitud);
                    System.out.println(aux);
                    Actuadores.lblRecibir.setText(aux);
                    salida.write(Actuadores.lblRecibirArduino.getText().getBytes());
                    
                    
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
            
            
        }
    }
    public void cerrar() throws IOException{
        salida.close();
        entrada.close();
        puertoSerie.close();
    }
    
}

