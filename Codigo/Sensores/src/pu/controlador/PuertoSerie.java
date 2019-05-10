
package pu.controlador;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.UnsupportedCommOperationException;
import pu.vista.Sensores;


public class PuertoSerie extends Thread{
    private CommPortIdentifier idPuerto;
    private SerialPort puertoSerie; //siempre tiene que ser privada todos los atributos.
    private OutputStream flujoSalida;
    private InputStream flujoEntrada;
    
    private int longitud = -1;
    private byte[] buffer = new byte[1024]; //una inicializacion es  new byte[1024]
    private String aux; //Para que el mensaje se guarde
    
    public PuertoSerie(String puerto) throws PortInUseException, 
            UnsupportedCommOperationException, IOException{
        try {
                idPuerto=CommPortIdentifier.getPortIdentifier(puerto);
                if(idPuerto.isCurrentlyOwned()){
                    System.out.println("puerto en uso");
                } else{
                        puertoSerie=(SerialPort) idPuerto.open("comunicacion",1000);
                System.out.println("Puerto Abierto");
                puertoSerie.setSerialPortParams(115200, SerialPort.DATABITS_8, 
                        SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                System.out.println("Puerto configurado");
                flujoSalida=puertoSerie.getOutputStream();
                System.out.println("Flujo de salida configurado");
                flujoEntrada=puertoSerie.getInputStream();
                System.out.println("Flujo de entrada configurado");
                this.start();
                }
            } catch (NoSuchPortException ex) {
                Logger.getLogger(PuertoSerie.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void txSerial(String mensaje){
        try {
            flujoSalida.write(mensaje.getBytes());
            System.out.println(mensaje);
        } catch (IOException ex) {
            Logger.getLogger(PuertoSerie.class.getName()).log(Level.SEVERE, null, ex);
        }

            
    }
    
    @Override
    public void run() {
        System.out.println("hilo iniciado");
        while (true) {            
            try {
                if((longitud=flujoEntrada.read(buffer))>-1){
                    
                    aux = new String(buffer,0,longitud);
                    System.out.println(aux);
                    Sensores.lblRecibir.setText(aux);
                        //CO2.lblCO2.setText(aux);
                }
            } catch (IOException ex) {
                Logger.getLogger(PuertoSerie.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    public void cerrar() throws IOException{
        flujoSalida.close();
        flujoEntrada.close();
        puertoSerie.close();
    }
    
    public void comunicacion(){
        
    }

    public String getAux() {
        return aux;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }

    public PuertoSerie(SerialPort puertoSerie) {
        this.puertoSerie = puertoSerie;
    }
    
}
