package Graficos;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class WidgetCreation {
    public static Button CreateButton(String text){
        Button button;
        if(!text.equalsIgnoreCase("")){
        button=new Button(text);}
        else{
            button=new Button();
        }


        return button;
    }
    public static ButtonID CreateButton(String text,int id){
        ButtonID btn=new ButtonID(text,id);
        btn.setShape(new Circle(40));
        btn.setStyle("-fx-background-color: #44ff4e; ");
        return btn;
    }
    public static Rectangle CreateRec(double coordX, double coordY, double width, double height){
        Rectangle rect=new Rectangle();
        rect.setX(coordX);
        rect.setY(coordY);
        rect.setWidth(width);
        rect.setHeight(height);
        rect.setFill(Color.GREEN);
        rect.setArcHeight(40);
        rect.setArcWidth(40);
        return rect;
    }

}
