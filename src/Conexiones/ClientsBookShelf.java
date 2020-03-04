package Conexiones;


import Hilos.HiloCliente;
import jdk.net.Sockets;

import java.net.Socket;

import java.util.ArrayList;
/*
This class saves a serie of Enlace's classes objets and return their associated port if call the getPortNumber method or
the object as itself if you call the getEnlaceMetod
This also has the capability to call a object Enviar method
 */

public class ClientsBookShelf {
    private static ArrayList<Enlace> ListaSockets=new ArrayList<Enlace>();
    private static ArrayList<Integer> ListaPuertos=new ArrayList<Integer>();
    public static void add(Enlace enlace){
        ListaSockets.add(enlace);
        ListaPuertos.add(enlace.getPort());
        enlace.setMensajePendiente(false);

    }

    /**
     *
     * @param posicion The position if which the desired objets will be in the arrayList
     * @return A Enlace object or a null if there was any problem
     */
    public static Enlace getEnlace(int posicion){
        return ListaSockets.get(posicion);
    }

    /**
     *
     * @param posicion The desired posicion in the ArrayList<Enlace></Enlace>
     * @param Mensaje
     */
    public static void Enviar(int posicion,String Mensaje){

        ListaSockets.get(posicion).EnviarMensaje(Mensaje);


    }

    /**
     *
     * @param position The desired Enlace's position
     * @return Enlace's port number
     */
    public static int getPortNumber(int position){
        return ListaPuertos.get(position);
    }

    /**
     *
     * @return A integer's ArrayList, with all the ports existing at the moment
     */
    public static ArrayList<Integer> ArrayReturn(){
        return ListaPuertos;
    }

    /**
     *
     * @return int that will be the Integer's arrayList length
     */
    public static int getlen(){
        return ListaPuertos.size();
    }
    public static int getlastport(){
        Object[] Array=ListaPuertos.toArray();
        int i=Array.length-1;
        return ListaPuertos.get(i);
    }

}
