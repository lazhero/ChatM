package Hilos;

import Conexiones.Enlace;

public class HiloCliente extends Thread {
    private Enlace enlace;
    public HiloCliente(Enlace enlace){
        this.enlace=enlace;
    }
    public void run(){
        enlace.EnviarMensaje1();    }
}
