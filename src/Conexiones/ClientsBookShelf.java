package Conexiones;

import jdk.net.Sockets;

import java.net.Socket;
import java.util.ArrayList;

public class ClientsBookShelf {
    private static ArrayList<Enlace> ListaSockets=new ArrayList<Enlace>();
    private static ArrayList<Integer> ListaPuertos=new ArrayList<Integer>();
    private static ArrayList<Socket> SocketShelf=new ArrayList<Socket>();
    public static void add(Enlace enlace){
        ListaSockets.add(enlace);
        ListaPuertos.add(enlace.getPort());

       // enlace.close();

    }
    public static Enlace getEnlace(int posicion){
        return ListaSockets.get(posicion);
    }
    public static void Enviar(int posicion,String Mensaje){
        //ListaSockets.get(posicion).ConectarEnviarFijo();
        ListaSockets.get(posicion).EnviarMensaje(Mensaje);
       // ListaSockets.get(posicion).close();

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
