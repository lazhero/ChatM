package Conexiones;

import ComprobacionesFormato.RevisionFormato;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class LectorTexto {
    /*
    Se encarga de procesar un mensaje asignado por un ServerSocket a un Socket
     */

    /**
     *
     * @param Entrada Socket
     * @return A string which will be the split of the obtained text.
     */
    public static String[] Lectura(Socket Entrada){
        String[] retorno=null;
        try {
            BufferedReader Lector = new BufferedReader(new InputStreamReader(Entrada.getInputStream()));
            String Texto = Lector.readLine();
            if (RevisionFormato.Format(Texto, "~")) {
                retorno = Texto.split("~");
            }
            else{
            }
        }
        catch (Exception e){

        }
        return retorno;
    }
}
