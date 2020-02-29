package Graficos;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ScrollPane;
import java.awt.*;

public class LayoutNewContent {
    public static void Add(AnchorPane anchorPane,Node node,double Top,double Bottom,double Right,double Left){
        anchorPane.getChildren().add(node);
        if(Top!=0.0) anchorPane.setTopAnchor(node,Top);
        if(Bottom!=0.0)anchorPane.setBottomAnchor(node,Bottom);
        if(Left!=0.0)anchorPane.setLeftAnchor(node,Left);
        if(Right!=0.0)anchorPane.setRightAnchor(node,Right);
    }
    public static void Update(ScrollPane scroll,Node node){

        scroll.setContent(node);
    }

}
