package Graficos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class ChatAcumulator {
           ChatAcumulator.scroll=scroll;
    private int Chatid;
    private static int ScreenChat;
    private static ScrollPane scroll;
    private static AnchorPane pane;
    private static int NumChats= 0;
    private static ArrayList<AnchorPane> Chats=new ArrayList<AnchorPane>();
    ChatAcumulator(ScrollPane scroll,AnchorPane anchor) {
            ChatAcumulator.scroll=scroll;
            ChatAcumulator.pane=anchor;

    }
    public static void Creator(int puerto){
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

