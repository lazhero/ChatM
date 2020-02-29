package Hilos;

import Conexiones.ClientsBookShelf;
import Conexiones.Enlace;
import Conexiones.EnlaceServidores;
import Graficos.ChatAcumulator;
import Sort.ArrayListSort;

public class HiloServer extends Thread{
    private EnlaceServidores Server;
    HiloServer(EnlaceServidores Server){
        this.Server=Server;
    }
    public void run(){
        while(true){
            String[] Recibido=this.Server.RecibirMensaje();//Retorna un array donde [0]=Numero de puerto que ocupa como servidor el emisor del texto y [1]=String Mensaje
            int Puerto= Integer.parseInt(Recibido[0]);
            int ComprobacionPos= ArrayListSort.FindPosicion(ClientsBookShelf.ArrayReturn(),Puerto);
            if(ComprobacionPos!=-1){
                ChatAcumulator.AddMessage(Recibido[1]);
                System.out.println("El puerto ya existia");
            }
        }

    }
}
