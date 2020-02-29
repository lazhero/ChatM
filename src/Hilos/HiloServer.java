package Hilos;

import Conexiones.Enlace;
import Conexiones.EnlaceServidores;

public class HiloServer extends Thread{
    private EnlaceServidores Server;
    HiloServer(EnlaceServidores Server){
        this.Server=Server;
    }
    public void run(){
        while(true){
            String[] Recibido=this.Server.RecibirMensaje();//Retorna un array donde [0]=Numero de puerto que ocupa como servidor el emisor del texto y [1]=String Mensaje
            /*
            Pendiente enviar este mensaje
             */
        }

    }
}
