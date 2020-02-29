package Conexiones;

import java.util.ArrayList;

public class ClientsBookShelf {
    private static ArrayList<Enlace> ListaSockets=new ArrayList<Enlace>();
    public static void add(Enlace enlace){
        ListaSockets.add(enlace);
    }
    public static Enlace getEnlace(int posicion){
        return ListaSockets.get(posicion);
    }
    public static void Enviar(int posicion,String Mensaje){
        ListaSockets.get(posicion).EnviarMensaje(Mensaje);
    }

}
