package Graficos;

import Conexiones.EnlaceServidores;
import Hilos.HiloServer2;
import Images.ImagesImport;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class VentanaPrincipal2 extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        EnlaceServidores Server =new EnlaceServidores();
        Server.ConectarRecepVariable();
        int mitelefono=Server.getPort();
        System.out.println(mitelefono);
        HiloServer2 hilo=new HiloServer2(Server.getServer());
        hilo.start();
        ImageView ImagenBtnEnviar=ImagesImport.GetImagen("C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructura\\ChatM\\Imagenes\\Iconos.png",0.0,0.0,40.0,40.0);
        ImageView ImagenBtnAdd=ImagesImport.GetImagen("C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructura\\ChatM\\Imagenes\\Button Add.png",0,0,35,35);
      final AnchorPane FirstLevelAnchorPanel= LayoutCreation.Anchor(800.0,600.0);
       Rectangle rectSecondLevel= WidgetCreation.CreateRec(15.0,15.0,300.0,530.0);
       final ScrollPane SecondLevelScrollPane= LayoutCreation.scroll(400.0,500.0);
       Button btn= WidgetCreation.CreateButton("");
       btn.setStyle("-fx-background-color: #ff0e00; ");
        btn.setGraphic(ImagenBtnAdd);
        btn.setShape(new Circle(-2));
       Button btn1= WidgetCreation.CreateButton("");
        btn1.setShape(new Circle(-2));
        btn1.setStyle("-fx-background-color: #ff0e00; ");
        btn1.setGraphic(ImagenBtnEnviar);
        btn1.setWrapText(true);
       //btn1.setGraphic(ImagesImport.GetImagen("file:c://Tecnologico de Costa Rica//Tercer Semestre//Algoritmos y estructura//ChatM//Imagenes//Iconos.png",0,0,60.0,60.0));
       boolean confirmacion=false;
        TextField TextInput=new TextField();
        TextInput.setPrefWidth(385.0);
        TextInput.setPrefHeight(30.0);
        TextInput.setText("Escriba su mensaje aqui ");
        ChatAcumulator.setChatAcumulator(SecondLevelScrollPane,FirstLevelAnchorPanel,mitelefono);
        btn.setOnAction(e->
        {
            ChatAcumulator.Creator(); }
        );
       btn1.setOnAction(e->
            {ChatAcumulator.AddMessage(TextInput.getText());
                TextInput.clear();}
               );
       //AnchorPane ThridLevelAnchorPanel=LayoutCreation.Anchor(400.0,10000.0);
       LayoutNewContent.Add(FirstLevelAnchorPanel,SecondLevelScrollPane,20.0,0.0,0.0,350.0);
       LayoutNewContent.Add(FirstLevelAnchorPanel,btn,0.0,10.0,0,20.0);
       LayoutNewContent.Add(FirstLevelAnchorPanel,btn1,0.0,15.0,18.0,0.0);
       FirstLevelAnchorPanel.getChildren().add(rectSecondLevel);
       //FirstLevelAnchorPanel.getChildren().addAll(imagen);

       LayoutNewContent.Add(FirstLevelAnchorPanel,TextInput,0.0,20.0,65.0,0.0);
       Scene scene=new Scene(FirstLevelAnchorPanel,800,600.0, Color.BLACK);
       primaryStage.setScene(scene);
       primaryStage.setResizable(false);
       primaryStage.show();

    }



}
