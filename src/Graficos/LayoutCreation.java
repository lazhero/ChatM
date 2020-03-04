package Graficos;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

public class LayoutCreation {
    /*
    A class to create some JAvafx containers
     */

    /**
     * Creates an anchorpane
     * @param width sets the anchor panel width's
     * @param heigth sets the anchor height's
     * @return the anchor panel
     */
    public static AnchorPane Anchor(double width,double heigth){
        AnchorPane AnchorP =new AnchorPane();
        AnchorP.setPrefHeight(heigth);
        AnchorP.setPrefWidth(width);
        return AnchorP;

    }

    /**
     *Creates an anchorpanelID
     * @param width sets the anchor panel width's
     * @param heigth sets the anchor height's
     * @return the anchorpanelID
     */
    public static AnchorPaneID AnchorID(double width,double heigth){
        AnchorPaneID AnchorP =new AnchorPaneID();
        AnchorP.setPrefHeight(heigth);
        AnchorP.setPrefWidth(width);
        //AnchorP.setBackground(new Background(new BackgroundFill(, CornerRadii.EMPTY, Insets.EMPTY)));
        return AnchorP;

    }

    /**
     *
     * @param width the scroll width's
     * @param heigth the Scrolls height's
     * @return the scrollpane
     */
    public static ScrollPane scroll(double width,double heigth){
        ScrollPane scrolls=new ScrollPane();
        scrolls.setPrefViewportHeight(heigth);
        scrolls.setPrefViewportWidth(width);
        return scrolls;
    }

}
