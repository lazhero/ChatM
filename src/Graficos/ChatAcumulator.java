package Graficos;

import Conexiones.ClientsBookShelf;
import Conexiones.Enlace;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class ChatAcumulator {
    private static int selfport;
    private static int ScreenChat;
    private static ScrollPane scroll;
    private static AnchorPane pane;
    private static int NumChats= 0;//Guarda la cantidad de chats hasta el momento
    private static ArrayList<AnchorPaneID> Chats=new ArrayList<AnchorPaneID>();//Guarda los anchorpanel con cada chat
    private static ArrayList<Integer> ExitPorts=new ArrayList<Integer>();//Guarda los puertos de salida de cada chat
    public static void setChatAcumulator(ScrollPane scroll,AnchorPane anchor,int puertoServer) {
            ChatAcumulator.scroll=scroll;
            ChatAcumulator.pane=anchor;
            selfport=puertoServer;
    }
    public static void Creator(){
        if(ChatAcumulator.NumChats<=7) {
            try {
                Enlace enlace = new Enlace();
                enlace.ConectarEnviarVariable(40000, selfport);
<<<<<<< HEAD
                //enlace.setEscritura();
=======
>>>>>>> parent of 2a486ac... #2
                int puerto = enlace.getPort();
                ClientsBookShelf.add(enlace);
                AnchorPaneID anchor = LayoutCreation.AnchorID(400, 100000.0);
                Chats.add(anchor);
                String NumeroChat = Integer.toString(puerto);
                ButtonID btn = new ButtonID("Chat" + NumeroChat, NumChats);
                btn.setOnAction(e ->
                        ChatAcumulator.ChatToScroll(btn.getID())
                );
                LayoutNewContent.Add(pane, btn, 50.0 * (btn.getID() + 1), 0, 0, 25.0);
                NumChats++;
            }
            catch (Exception e){
                System.out.println("No hay otros usuarios disponibles");
            }
        }
    }
    public static void Creator(int Puerto){
        if(ChatAcumulator.NumChats<=7) {
            Enlace enlace=new Enlace(Puerto);
            enlace.ConectarEnviarFijo();
<<<<<<< HEAD
            //enlace.setEscritura();
=======
>>>>>>> parent of 2a486ac... #2
            int puerto=enlace.getPort();
            ClientsBookShelf.add(enlace);
            AnchorPaneID anchor = LayoutCreation.AnchorID(400, 100000.0);
            Chats.add(anchor);
            String NumeroChat = Integer.toString(puerto);
            ButtonID btn = new ButtonID("Chat" + NumeroChat, NumChats);
            btn.setOnAction(e ->
                    ChatAcumulator.ChatToScroll(btn.getID())
            );
            LayoutNewContent.Add(pane, btn, 50.0 *( btn.getID()+1), 0, 0, 25.0);
            NumChats++;
        }
    }
    private static void ChatToScroll(int indice){
        scroll.setContent(Chats.get(indice));
        ScreenChat=indice;
    }
    public static void AddMessage(String texto){
        Label label=new Label(texto);
        AnchorPaneID anchor=Chats.get(ScreenChat);
        int posicion=anchor.getNumeroitems()+1;
        anchor.RaiseItemNumbers();
        String Mensaje=Integer.toString(selfport)+"~"+texto;
        LayoutNewContent.Add(anchor,label,posicion*30,0,30.0,0);
        ClientsBookShelf.Enviar(ScreenChat,Mensaje);

    }
    public static void AddMessage(String texto,int Listpos){
        String textopuerto=Integer.toString(selfport);
        System.out.println("Llegue al out mensaje");
        Label label=new Label(texto);
        AnchorPaneID anchor=Chats.get(Listpos);
        int posicion=anchor.getNumeroitems()+1;
        anchor.RaiseItemNumbers();
        LayoutNewContent.Add(anchor,label,posicion*30,0,0,30.0);


    }

}

