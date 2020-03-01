package Conexiones;

import ComprobacionesFormato.RevisionFormato;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class LectorTexto {
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
