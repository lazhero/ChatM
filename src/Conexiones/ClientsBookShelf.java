package Conexiones;

<<<<<<< HEAD
import Hilos.HiloCliente;
import jdk.net.Sockets;

import java.net.Socket;
=======
>>>>>>> parent of 2a486ac... #2
import java.util.ArrayList;

public class ClientsBookShelf {
    private static ArrayList<Enlace> ListaSockets=new ArrayList<Enlace>();
    private static ArrayList<Integer> ListaPuertos=new ArrayList<Integer>();
    public static void add(Enlace enlace){
        ListaSockets.add(enlace);
        ListaPuertos.add(enlace.getPort());
<<<<<<< HEAD
        enlace.setMensajePendiente(false);
        HiloCliente hilo =new HiloCliente(enlace);
        hilo.start();


=======
>>>>>>> parent of 2a486ac... #2
       // enlace.close();

    }
    public static Enlace getEnlace(int posicion){
        return ListaSockets.get(posicion);
    }
    public static void Enviar(int posicion,String Mensaje){

        //ListaSockets.get(posicion).ConectarEnviarFijo();
        //ListaSockets.get(posicion).EnviarMensaje(Mensaje);
       // ListaSockets.get(posicion).close();
        if((Mensaje.split("~")[1]).equalsIgnoreCase("Eso es todo")){
            ListaSockets.get(posicion).setEnviando(false);
        }
        else {
            ListaSockets.get(posicion).setMensajeaEnviar(Mensaje);
            ListaSockets.get(posicion).setMensajePendiente(true);
        }

    }
    public static int getPortNumber(int position){
        return ListaPuertos.get(position);
    }
    public static ArrayList<Integer> ArrayReturn(){
        return ListaPuertos;
    }
    public static int getlen(){
        return ListaPuertos.size();
    }

}
