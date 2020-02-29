package Graficos;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

public class LayoutCreation {
    public static AnchorPane Anchor(double width,double heigth){
        AnchorPane AnchorP =new AnchorPane();
        AnchorP.setPrefHeight(heigth);
        AnchorP.setPrefWidth(width);
        return AnchorP;

    }
    public static AnchorPaneID AnchorID(double width,double heigth){
        AnchorPaneID AnchorP =new AnchorPaneID();
        AnchorP.setPrefHeight(heigth);
        AnchorP.setPrefWidth(width);
        return AnchorP;

    }
    public static ScrollPane scroll(double width,double heigth){
        ScrollPane scrolls=new ScrollPane();
        scrolls.setPrefViewportHeight(heigth);
        scrolls.setPrefViewportWidth(width);
        return scrolls;
    }

}
