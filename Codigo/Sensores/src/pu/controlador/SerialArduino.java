package pu.controlador;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.*;
import static pu.vista.Sensores.lblRecibir;

public class SerialArduino extends Thread{
    
    CommPortIdentifier idPuerto;
    SerialPort puertoSerie;
    OutputStream salida;
    PuertoSerie obj;
    
    
    public void txSerial(String mensaje, String puerto) throws NoSuchPortException, PortInUseException, IOException, UnsupportedCommOperationException
    {
       idPuerto=CommPortIdentifier.getPortIdentifier(puerto);
        System.out.println("Puerto "+puerto+" de arduino identificado");
        if(idPuerto.isCurrentlyOwned()){
            System.out.println("Puerto en uso");
        }else{
            puertoSerie=(SerialPort) idPuerto.open("Puerto", 1000);
            System.out.println("Puerto Abierto");
            salida=puertoSerie.getOutputStream();
            puertoSerie.setSerialPortParams(115200, SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            System.out.println("Puerto Configurado");
            System.out.println("Instrucccion enviada");
            System.out.println("Puerto Liberado");
            this.start();
        }
    }
    
    public void run(){
        while(true){
            try {
                salida.write(lblRecibir.getText().getBytes());
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

