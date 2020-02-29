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
    private static ArrayList<AnchorPane> Chats=new ArrayList<AnchorPane>();//Guarda los anchorpanel con cada chat
    private static ArrayList<Integer> MensajesxChat=new ArrayList<Integer>();//Guarda la cantidad de mensajes en cada chat
    public static void setChatAcumulator(ScrollPane scroll,AnchorPane anchor) {
            ChatAcumulator.scroll=scroll;
            ChatAcumulator.pane=anchor;
    }
    public static void Creator(int puerto){
        AnchorPaneID anchor=LayoutCreation.AnchorID(400,100000.0);
        Chats.add(anchor);
        String NumeroChat=Integer.toString(NumChats);
        ButtonID btn=new ButtonID("Chat"+NumeroChat,NumChats);
       btn.setOnAction(e->
               ChatAcumulator.ChatToScroll(btn.getID())
               );

       NumChats++;

    }
    private static void ChatToScroll(int indice){
        scroll.setContent(Chats.get(indice));
        ScreenChat=indice;
    }

}

