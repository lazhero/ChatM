package Graficos;

import Conexiones.ClientsBookShelf;
import Sort.ArrayListSort;
import javafx.application.Platform;

public class Agregando {
    /**
     *Once the port its ckecked, finds it in a array, its there, calls the ChatAcumulator.Add method
     * else calls the ChatAcumulator.creator first and the the Add method
     * @param Recibido A String[] whose [0] will be the sender port number and [1] will be the message
     */
    public static void Agregar(String[] Recibido){

        int Puerto= Integer.parseInt(Recibido[0]);
        int ComprobacionPos= ArrayListSort.FindPosicion(ClientsBookShelf.ArrayReturn(),Puerto);
        System.out.println("La posicion en lista es "+ComprobacionPos);
        if(ComprobacionPos!=-1){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    ChatAcumulator.AddMessage(Recibido[1],ComprobacionPos);
                }
            });

            System.out.println("El puerto ya existia");
        }
        else{
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Estoy en la creacion");
                        ChatAcumulator.Creator(Puerto);
                        ChatAcumulator.AddMessage(Recibido[1], ClientsBookShelf.getlen() - 1);
                    }
                    catch (Exception e){
                        System.out.println("Muchachones, exploto");
                    }
                }
            });
        }
    }
}
