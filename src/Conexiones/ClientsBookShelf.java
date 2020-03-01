package Conexiones;


import Hilos.HiloCliente;
import jdk.net.Sockets;

import java.net.Socket;

import java.util.ArrayList;

public class ClientsBookShelf {
    private static ArrayList<Enlace> ListaSockets=new ArrayList<Enlace>();
    private static ArrayList<Integer> ListaPuertos=new ArrayList<Integer>();
    public static void add(Enlace enlace){
        ListaSockets.add(enlace);
        ListaPuertos.add(enlace.getPort());
        enlace.setMensajePendiente(false);

    }
    public static Enlace getEnlace(int posicion){
        return ListaSockets.get(posicion);
    }
    public static void Enviar(int posicion,String Mensaje){

        ListaSockets.get(posicion).EnviarMensaje(Mensaje);


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
