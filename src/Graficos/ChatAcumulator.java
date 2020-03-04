package Graficos;

import ComprobacionesFormato.RevisionFormato;
import Conexiones.ClientsBookShelf;
import Conexiones.Enlace;
import Images.ImagesImport;
import Sort.ArrayListSort;
import com.sun.prism.Image;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class ChatAcumulator {
    /**
     * This class works and changes the objets in screen
     */
    private static int PuertoInicio;
    private static int selfport;
    private static int ScreenChat=-10;
    private static Button btnx;
    private static ScrollPane scroll;
    private static AnchorPane pane;
    private static int NumChats= 0;//Guarda la cantidad de chats hasta el momento
    private static ArrayList<AnchorPaneID> Chats=new ArrayList<AnchorPaneID>();//Guarda los anchorpanel con cada chat
    private static ArrayList<Integer> ExitPorts=new ArrayList<Integer>();//Guarda los puertos de salida de cada chat

    /**
     *
     * @param scroll sets the scroll where the messages will be show
     * @param anchor Sets the Windows main container
     * @param puertoServer Sets the windows port as reference
     */
    public static void setChatAcumulator(ScrollPane scroll,AnchorPane anchor,int puertoServer) {
            ChatAcumulator.scroll=scroll;
            ChatAcumulator.pane=anchor;
            selfport=puertoServer;
            PuertoInicio=40000;
    }

    /**
     * Creates a new chat,
     * this means a new button and a new Anchor panel to add to the ScrollPanel and then class AddtoScroll to get the chat into the screen
     */
    public static void Creator(){
        if(ChatAcumulator.NumChats<=7) {
            try {
                Enlace enlace = new Enlace();
                enlace.ConectarEnviarVariable(PuertoInicio, selfport);
                int puerto = enlace.getPort();
                PuertoInicio=puerto+1;
                ClientsBookShelf.add(enlace);
                AnchorPaneID anchor = LayoutCreation.AnchorID(400, 100000.0);
                Chats.add(anchor);
                String NumeroChat = Integer.toString(puerto);
                ButtonID btn = new ButtonID("Chat" + NumeroChat, NumChats);
                btn.setFont(Font.font("Rockwell Extra Bold",15));
                String path="C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructura\\ChatM\\Imagenes\\Us"+Integer.toString(btn.getID())+".png";
                ImageView imagen= ImagesImport.GetImagen(path,0,0,30,30);
                btn.setGraphic(imagen);
                btn.setOnAction(e ->
                        ChatAcumulator.ChatToScroll(btn.getID())
                );
                LayoutNewContent.Add(pane, btn, 50.0 * (btn.getID() + 1), 0, 0, 25.0);
                ChatToScroll(btn.getID());
                NumChats++;
            }
            catch (Exception e){
                System.out.println("No hay otros usuarios disponibles");
            }
        }
    }

    /**
     * This creates a chat associated with a port
     * @param Puerto A int parameter
     */
    public static void Creator(int Puerto){
        if(ChatAcumulator.NumChats<=7) {
            Enlace enlace=new Enlace(Puerto);
            enlace.ConectarEnviarFijo();
            int puerto=enlace.getPort();
            ClientsBookShelf.add(enlace);
            AnchorPaneID anchor = LayoutCreation.AnchorID(400, 100000.0);
            Chats.add(anchor);
            String NumeroChat = Integer.toString(puerto);
            ButtonID btn = new ButtonID("Chat" + NumeroChat, NumChats);
            btn.setWrapText(true);
            btn.setFont(Font.font("Rockwell Extra Bold",15));
            String path="C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructura\\ChatM\\Imagenes\\Us"+Integer.toString(btn.getID())+".png";
            ImageView imagen= ImagesImport.GetImagen(path,0,0,30,30);
            btn.setGraphic(imagen);
            btn.setOnAction(e ->
                    ChatAcumulator.ChatToScroll(btn.getID())
            );
            LayoutNewContent.Add(pane, btn, 50.0 *( btn.getID()+1), 0, 0, 25.0);
            ChatToScroll(btn.getID());
            NumChats++;
        }
    }

    /**
     * Gets the specified position in a AnchorPanel's arrayList , to the screen
     * @param indice The Arrays position
     */
    private static void ChatToScroll(int indice){
        try {
            scroll.setContent(Chats.get(indice));
            ScreenChat = indice;
        }
        catch (Exception e){
            scroll.setContent(LayoutCreation.Anchor(400,10000));
        }
    }

    /**
     * Adds a Label(Chat) to the anchor panel showing in screen
     * @param texto The label's text
     */
    public static void AddMessage(String texto){
        if(!texto.equalsIgnoreCase("") && ScreenChat!=-10) {
            Label label = new Label(texto);
            label.setFont(Font.font("Rockwell Extra Bold",20));
            label.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            AnchorPaneID anchor = Chats.get(ScreenChat);
            int posicion = anchor.getNumeroitems() + 1;
            anchor.RaiseItemNumbers();
            String Mensaje = Integer.toString(selfport) + "~" + texto;
            LayoutNewContent.Add(anchor, label, posicion * 35, 0, 30.0, 0);
            ClientsBookShelf.Enviar(ScreenChat, Mensaje);
        }

    }

    /**
     * Add a message to an AnchorPanel in a specific position
     * @param texto The label's text
     * @param Listpos The position in the array
     */
    public static void AddMessage(String texto,int Listpos){
        if(!texto.equalsIgnoreCase("")) {
            String textopuerto = Integer.toString(selfport);
            System.out.println("Llegue al out mensaje");
            Label label = new Label(texto);
            label.setFont(Font.font("Rockwell Extra Bold",20));
            label.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
            AnchorPaneID anchor = Chats.get(Listpos);
            int posicion = anchor.getNumeroitems() + 1;
            anchor.RaiseItemNumbers();
            LayoutNewContent.Add(anchor, label, posicion * 35, 0, 0, 30.0);
        }


    }


}

