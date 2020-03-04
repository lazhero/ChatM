package Graficos;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class ButtonID extends Button {
    /*
    A Button's class child with their own id
     */
    private int id;

    /**
     *
     * @param texto Sets the button text
     * @param id sets the id
     *
     */
    public ButtonID(String texto, int id){
        super(texto);
        this.id=id;
    }

    /**
     *
     * @return the button id
     */
    public int getID(){
        return id;
    }
}
