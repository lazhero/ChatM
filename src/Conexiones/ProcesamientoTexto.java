package Conexiones;

import ComprobacionesFormato.RevisionFormato;
import Graficos.Agregando;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ProcesamientoTexto extends Thread {
    private Socket socket;
    public ProcesamientoTexto(Socket socket) {
        this.socket=socket;
    }
    public void run(){
        String[] retorno = null;
        boolean enviar = false;
        String Texto="";
        BufferedReader Lector;
        try {
            Lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Texto = Lector.readLine();
            //System.out.println("El texto es "+Texto);
        } catch (Exception e) {
            Lector = null;
            System.out.println(e.getMessage());
        }
        if (RevisionFormato.Format(Texto, "~")) {
            retorno = Texto.split("~");
            System.out.println("Este es retorno en cero " +retorno[0]);
            System.out.println("Este es retorno en uno "+retorno[1]);
            Agregando.Agregar(retorno);
        }
    }

}
