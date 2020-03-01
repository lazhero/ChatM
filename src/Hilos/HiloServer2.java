package Hilos;

import Conexiones.ProcesamientoTexto;

import java.net.ServerSocket;
import java.net.Socket;

public class HiloServer2 extends Thread {
    ServerSocket Server;
    public HiloServer2(ServerSocket Server){
        this.Server=Server;
    }
    public void run(){
        while(true){
            try {
                Socket socket = this.Server.accept();
                ProcesamientoTexto procesar=new ProcesamientoTexto(socket);
                procesar.start();
            }
            catch (Exception e){}
        }
    }
}
