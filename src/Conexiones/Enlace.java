package Conexiones;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
/*
This class works with Socket class, creating methods that connect to a port, send messages, or return the socket's port
 */
public class Enlace {
    private  int port;
    private  String ip;
    private Socket client;
    private boolean ConectadoS=false;

    private boolean Enviando=true;
    private boolean MensajePendiente=true;
    private String MensajeaEnviar="";
    public Enlace(int port, String ip){
        this.port=port;
        this.ip=ip;
    }

    public Enlace(){
        this.port=40000;
        this.ip="127.0.0.1";
    }

    /**
     *
     * @param ip A string playing the ip direction
     */
    public Enlace(String ip){
        this.ip=ip;
        this.port=40000;
    }

    /**
     *
     * @param port A int playing the port's number
     */
    public Enlace(int port){
        this.port=port;
        this.ip="127.0.0.1";
    }

    /**
     * Try to connect to the setted port, else, calls the ConectarEnviarVariable method
     */
    public void ConectarEnviarFijo(){
        try{
            Socket Receptor=new Socket(this.ip,this.port);
            System.out.println("Conexion Exitosa");
            this.client= Receptor;


        }
        catch(Exception excep){
            System.out.print("El puerto no esta disponible");
            this.ConectarEnviarVariable();
        }
    }

    /**
     * Trys to connect to a port starting with 40000
     */
    public void ConectarEnviarVariable(){
        this.port=40000;
        Socket Receptor=null;
        boolean flag=true;
        while(this.port<40100 && flag) {
            try {
                Receptor = new Socket(this.ip,this.port);
                this.ConectadoS=true;
                System.out.println("Puerto encontrado");
                flag=false;
            } catch (IOException excep) {
                this.port++;
                Receptor=null;

            }
        }
        this.client= Receptor;
    }

    /**
     * Finds a available port and connects to it
     * @param inicio The starting port to try
     */
    public void ConectarEnviarVariable(int inicio){
        this.port=inicio;
        Socket Receptor=null;
        boolean flag=true;
        while(this.port<40100 && flag) {
            try {
                Receptor = new Socket(this.ip,this.port);
                this.ConectadoS=true;
                System.out.println("Puerto encontrado");
                flag=false;
            } catch (IOException excep) {
                this.port++;
                Receptor=null;

            }
        }
        this.client= Receptor;
    }

    /**
     * Finds a available port, trying a sequeces of them, starting from a one
     * @param inicio The first port to try
     * @param PuertoPropio
     */
    public void ConectarEnviarVariable(int inicio,int PuertoPropio){
        this.port=inicio;
        Socket Receptor=null;
        boolean flag=true;
        while(this.port<40100 && flag) {
            try {
                if(this.port!=PuertoPropio) {
                    Receptor = new Socket(this.ip, this.port);
                    this.ConectadoS = true;
                    System.out.println("Puerto encontrado");
                    flag = false;
                }
                else this.port++;
            } catch (IOException excep) {
                this.port++;
                Receptor=null;

            }
        }
        this.client= Receptor;
    }

    /**
     * Sends a messaje through the setted point
     * @param Mensaje A string that will be the message to send
     */
    public void EnviarMensaje(String Mensaje){
        if(this.client==null || this.client.isClosed()){
            try {
                this.client = new Socket(this.ip, this.port);
                this.ConectarEnviarFijo();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try {


            OutputStreamWriter Escritura = new OutputStreamWriter(this.client.getOutputStream());
            Escritura.write(Mensaje + "\n");
            Escritura.flush();
           this.client.close();

        }
        catch(IOException excep){
            System.out.print(excep.getMessage());
        }
    }

    /**
     * Sends a message without closing the client connection
     */
    public void EnviarMensaje1(){

        while(this.Enviando) {
            OutputStreamWriter Escritura=null;
            try{
                Escritura = new OutputStreamWriter(this.client.getOutputStream());
            }
            catch (Exception e){

                this.Enviando=false;
                this.MensajePendiente=false;
                //Escritura=null;
            }
            if(this.MensajePendiente) {
                System.out.println("Entre al bloque de enviar");

                try {
                    Escritura.write(this.MensajeaEnviar + "\n");
                    Escritura.flush();
                    //this.client.close();
                } catch (IOException excep) {
                    System.out.println(excep.getMessage());
                }
                this.MensajePendiente=false;
            }
            else{
                this.Enviando=true;
            }
        }
    }

    /**
     *
     * @param valor Sets if the socket's working in the EnviarMensaje1 method should be working or not
     */
    public void setEnviando(boolean valor){
        this.Enviando=valor;
    }

    /**
     *
     * @param Mensaje Sets the message to send with the EnviarMensaje1 Method
     */
    public void setMensajeaEnviar(String Mensaje){
        this.MensajeaEnviar=Mensaje;
    }

    /**
     * Sets if theres is any message to send with the EnviarMensaje1 Method
     * @param valor
     */
    public void setMensajePendiente(boolean valor){
        this.MensajePendiente=valor;
    }

    /**
     *
     * @return the actual port
     */
    public int getPort(){
        return this.port;
    }

    /**
     * Finds and available port and returns it
     * @param PuertoOcupado get the port to avaid, this is the caller port
     * @return An available port
     */
    public static int PuertoDisponible(int PuertoOcupado){
        int port=40000;
        Socket Receptor=null;
        boolean flag=true;
        while(port<40100 && flag) {
            try {
                if (port!=PuertoOcupado) {
                    Receptor = new Socket("127.0.0.1", port);
                    System.out.println("Puerto encontrado");
                    flag = false;
                }
            } catch (IOException excep) {
                port++;
                Receptor=null;

            }
        }
        Receptor=null;
        return port;
    }

}