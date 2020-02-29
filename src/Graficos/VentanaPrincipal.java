package Graficos;

import Conexiones.ControlEnvio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class VentanaPrincipal extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

      final AnchorPane FirstLevelAnchorPanel= LayoutCreation.Anchor(800.0,600.0);
       Rectangle rectSecondLevel= WidgetCreation.CreateRec(10.0,10.0,300.0,550.0);
       final ScrollPane SecondLevelScrollPane= LayoutCreation.scroll(400.0,500.0);
       Button btn= WidgetCreation.CreateButton("+");
       Button btn1= WidgetCreation.CreateButton("Y");
       boolean confirmacion=false;
        TextField TextInput=new TextField();
        TextInput.setPrefWidth(385.0);
        TextInput.setPrefHeight(30.0);
        TextInput.setText("Escriba su mensaje aqui ");
        btn.setOnAction(e->
                ChatAcumulator.Creator(SecondLevelScrollPane,FirstLevelAnchorPanel)
        );
       // btn1.setOnAction(e->);
       //AnchorPane ThridLevelAnchorPanel=LayoutCreation.Anchor(400.0,10000.0);
       LayoutNewContent.Add(FirstLevelAnchorPanel,SecondLevelScrollPane,20.0,0.0,0.0,350.0);
       LayoutNewContent.Add(FirstLevelAnchorPanel,btn,0.0,10.0,0,20.0);
       LayoutNewContent.Add(FirstLevelAnchorPanel,btn1,0.0,20.0,15.0,0.0);
       FirstLevelAnchorPanel.getChildren().add(rectSecondLevel);

       LayoutNewContent.Add(FirstLevelAnchorPanel,TextInput,0.0,20.0,65.0,0.0);
       Scene scene=new Scene(FirstLevelAnchorPanel,800,600.0, Color.BLACK);
       primaryStage.setScene(scene);
       primaryStage.show();

    }



}
