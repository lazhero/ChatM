package Hilos;

import Conexiones.Enlace;

public class HiloCliente extends Thread {
    /*
    A class who runs a thread to send a message without interrupting the other process happening
     */
    private Enlace enlace;
    public HiloCliente(Enlace enlace){
        this.enlace=enlace;
    }
    @Override
    public void run(){
        enlace.EnviarMensaje1();    }
}
