package ComprobacionesFormato;

import java.security.KeyStore;

public class RevisionFormato {
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

