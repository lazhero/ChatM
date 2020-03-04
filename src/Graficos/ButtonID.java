package Graficos;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class ButtonID extends Button {
    private int id;
    public ButtonID(String texto, int id){
        super(texto);
        this.id=id;
    }
    public int getID(){
        return id;
    }
}
