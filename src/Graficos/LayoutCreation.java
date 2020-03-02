package Graficos;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

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
        //AnchorP.setBackground(new Background(new BackgroundFill(, CornerRadii.EMPTY, Insets.EMPTY)));
        return AnchorP;

    }
    public static ScrollPane scroll(double width,double heigth){
        ScrollPane scrolls=new ScrollPane();
        scrolls.setPrefViewportHeight(heigth);
        scrolls.setPrefViewportWidth(width);
        return scrolls;
    }

}
