package Images;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

public class ImagesImport {
    public static ImageView GetImagen(String path,double coordx,double coordy,double heigth,double width){
        try {
            Image image = new Image(new FileInputStream(path));
            ImageView imagen=new ImageView(image);
            imagen.setX(coordx);
            imagen.setY(coordy);
            imagen.setFitHeight(heigth);
            imagen.setFitWidth(width);
            imagen.setPreserveRatio(true);
            return imagen;
        }
        catch (Exception e){
            ImageView imagen=null;
            return imagen;
        }

    }
}
