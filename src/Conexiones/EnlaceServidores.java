package Conexiones;
import ComprobacionesFormato.RevisionFormato;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class EnlaceServidores {
    /*
    This class works with the ServerSocket class, it has methods to receive messages, connect to a port, etc
     */
    private  int port;
    private  String ip;
    private boolean recibiendo=true;
    private boolean ConectadoS=false;
    private ServerSocket Server;
    private String[] Texto;
    private Socket cliente;
    public EnlaceServidores(int port, String ip){
        this.port=port;
        this.ip=ip;
    }

    /**
     * Sets a port=40000 and ip="127.0.0.1"
     */
    public EnlaceServidores(){
        this.port=4000;
        this.ip="127.0.0.1";
    }

    /**
     * Sets a ip equal to the received one and port=4000
     * @param ip
     */
    public EnlaceServidores(String ip){
        this.ip=ip;
        this.port=4000;
    }

    /**
     * Sets a port equals to the received one and a ip ="127.0.0.1"
     * @param port
     */
    public EnlaceServidores(int port){
        this.port=port;
        this.ip="127.0.0.1";
    }

    /**
     * Trys to connect to the setted port,else calls the  ConectarRecepVariable method
     */
    public void ConectarRecepFijo(){
        try{
            this.Server=new ServerSocket(this.port);
            System.out.println("Conexion Exitosa");
        }
        catch(IOException excep){
            System.out.println("El puerto no esta disponible");
            this.ConectarRecepVariable();
        }
    }

    /**
     * Finds a available port and connects to it
     */
    public void ConectarRecepVariable(){
        this.port=40000;
        this.Server=null;
        boolean flag=true;
        while(this.port<40100 && flag) {
            try {
                this.Server = new ServerSocket(this.port);
                ServerSocket Prueba=new ServerSocket(this.port+1);
                System.out.println("Conexion Exitosa");
                flag=false;
                this.ConectadoS=true;
            } catch (IOException excep) {
                this.port++;

            }
        }

    }

    /**
     * Accepts a client's message
     * @return A two units length String[],applying the split method to it with a setted separator
     */
    public String[] RecibirMensaje(){
        String Texto="";
        String[] retorno=null;
        boolean Recibiendo=true;
        try {
            while (Recibiendo) {
                this.cliente = this.Server.accept();
                BufferedReader Lector = new BufferedReader(new InputStreamReader(this.cliente.getInputStream()));
                Texto = Lector.readLine();
                if(RevisionFormato.Format(Texto,"~")){
                    retorno=Texto.split("~");
                    Recibiendo=false;


                }
            }

        }
        catch(IOException Exp){
            System.out.print(Exp.getMessage());
        }
        return retorno;

    }

    /**
     *
     * @return int representing the actual port
     */
    public int getPort(){
        return this.port;
    }

    /**
     *
     * @return The ServerSocket object
     */
    public ServerSocket getServer() {
        return Server;
    }
}