package ComprobacionesFormato;

import java.security.KeyStore;


public class RevisionFormato {
    /**
This method recieves two strings and determinate if the second one causes a two parts division in the first one, using a the String's class split method
if so, returns true , else, return false
@return boolean
@author Luis Zuniga <lazh@estudiantec.cr></lazh@estudiantec.cr>
@version 1.0 First version
@param texto The main string thats going to be checked
@param Subtexto the substring the works as separator in the main one.

 */
    public static boolean Format(String texto,String Subtexto){
      int apperance=texto.indexOf(Subtexto);
      String[] divisiones;
      if (apperance>=0){
          divisiones=texto.split(Subtexto);
          if (divisiones.length==2)return true;
          else return false;
      }
      else return false;
    }


}

