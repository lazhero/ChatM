package Graficos;

import Conexiones.HiloServer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class ChatAcumulator {
    private static  ArrayList<AnchorPane> Chats=new ArrayList<AnchorPane>();
    private static  ArrayList<Integer> MessagesNumber=new ArrayList<Integer>();
    private int id;
    private static int chatActual;
    private static int NumeroChat=0;
    private static ArrayList<Integer> PuertosSalida=new ArrayList<Integer>();
    private static ScrollPane scroll=null;
    private static AnchorPane anchor=null;
   private ChatAcumulator(ScrollPane scroll,AnchorPane anchor){
        if(NumeroChat==0){
           ChatAcumulator.scroll=scroll;
           ChatAcumulator.anchor=anchor;
        }
        NumeroChat++;
        id=NumeroChat;//Potencial Error
       String Texto ="Chat "+ Integer.toString(id);
       Button btnk=new Button(Texto);
      btnk.setOnAction(e->this.ButtonAction());

       AnchorPane panel= LayoutCreation.Anchor(400.0,10000.0);
      // System.out.println("Hecho");
       Chats.add(panel);
       HiloServer hilo=new HiloServer(this.id);
       hilo.start();
       double TOP=10.0+60*this.id;
       System.out.println(id);
       btnk.setOnAction(e -> ButtonAction());
       btnk.setShape(new Circle(40));
       btnk.setStyle("-fx-background-color: #44ff4e; ");
       LayoutNewContent.Add(ChatAcumulator.anchor,btnk,TOP,0.0,0.0,25.0);
       //System.out.println("Hecho");
    }
    public static void Creator(ScrollPane scroll,AnchorPane anchor){
       if(ChatAcumulator.NumeroChat<7){
          ChatAcumulator Btn= new ChatAcumulator(scroll,anchor);
       }
    }
    private void ButtonAction(){
       ChatAcumulator.chatActual=this.id-1;
           ChatAcumulator.scroll.setContent(ChatAcumulator.Chats.get(chatActual));


    }
    public static void AddChat(String[] Mensaje,int ChatNum){
       try{
           MessagesNumber.set(ChatNum-2,MessagesNumber.get(ChatNum-2)+1);
       }
       catch(Exception e){
           MessagesNumber.add(1);
           PuertosSalida.add(Integer.parseInt(Mensaje[0]));
        }
        System.out.println("He llegado");
       int ubicacion=MessagesNumber.get(ChatNum-2);
        Label label =new Label(Mensaje[1]);
        LayoutNewContent.Add(ChatAcumulator.Chats.get(ChatNum-2),label,(ubicacion)*20,0,15,0);

    }
    public static void AddChat(String Mensaje,int ChatNum){
        int ubicacion=MessagesNumber.get(ChatNum);
        Label label =new Label(Mensaje);
        LayoutNewContent.Add(ChatAcumulator.Chats.get(ChatNum),label,(ubicacion)*20,0,0,15);




    }


    public static int getChatActual(){
       return chatActual;
    }
    public static int getPuerto(int Subindice){
       return PuertosSalida.get(Subindice);
    }
    public static void AddPuerto(int Puerto){
       ChatAcumulator.PuertosSalida.add(Puerto);
    }
    public static void increase(int Posicion){
       try {
           ChatAcumulator.MessagesNumber.set(Posicion, MessagesNumber.get(Posicion) + 1);
       }
       catch (Exception e){
           ChatAcumulator.MessagesNumber.add(1);
       }
    }
}

