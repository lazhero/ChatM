package Graficos;

import javafx.scene.layout.AnchorPane;

public class AnchorPaneID extends AnchorPane {
    /*
    A AnchorPanel's child with two extra Fetures , the This container nodes number
     */
    private int Numeroitems;
    AnchorPaneID(){
        super();
        Numeroitems=0;
    }

    /**
     *
     * @return The number of intances of this class
     */
    public int getNumeroitems(){
        return Numeroitems;
    }

    /**
     * Raises by one the number of objects on it
     */
    public void RaiseItemNumbers(){
        Numeroitems++;
    }
}
