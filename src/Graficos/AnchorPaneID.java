package Graficos;

import javafx.scene.layout.AnchorPane;

public class AnchorPaneID extends AnchorPane {
    private int Numeroitems;
    AnchorPaneID(){
        super();
        Numeroitems=0;
    }
    public int getNumeroitems(){
        return Numeroitems;
    }
    public void RaiseItemNumbers(){
        Numeroitems++;
    }
}
