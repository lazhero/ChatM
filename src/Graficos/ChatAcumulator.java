package Graficos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class ChatAcumulator {
    private int Chatid;
    private static int ScreenChat;
    private static ScrollPane scroll;
    private static AnchorPane pane;
    private static int NumChats= 0;//Guarda la cantidad de chats hasta el momento
    private static ArrayList<AnchorPaneID> Chats=new ArrayList<AnchorPaneID>();//Guarda los anchorpanel con cada chat
    private static ArrayList<Integer> ExitPorts=new ArrayList<Integer>();//Guarda los puertos de salida de cada chat
    public static void setChatAcumulator(ScrollPane scroll,AnchorPane anchor) {
            ChatAcumulator.scroll=scroll;
            ChatAcumulator.pane=anchor;
    }
    public static void Creator(int puerto){
        if(ChatAcumulator.NumChats<=7) {
            ExitPorts.add(puerto);
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
        LayoutNewContent.Add(anchor,label,posicion*30,0,30.0,0);
    }

}

