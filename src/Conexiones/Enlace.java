package Conexiones;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Enlace {
    private  int port;
    private  String ip;
    private Socket client;
    private boolean ConectadoS=false;

    private boolean Enviando=true;
    private boolean MensajePendiente=true;
    private String MensajeaEnviar;
    public Enlace(int port, String ip){
        this.port=port;
        this.ip=ip;
    }
    public Enlace(){
        this.port=40000;
        this.ip="127.0.0.1";
    }
    public Enlace(String ip){
        this.ip=ip;
        this.port=40000;
    }
    public Enlace(int port){
        this.port=port;
        this.ip="127.0.0.1";
    }

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
    public void EnviarMensaje(String Mensaje){
        try {

            //this.ConectarEnviarFijo();
            OutputStreamWriter Escritura = new OutputStreamWriter(this.client.getOutputStream());
            Escritura.write(Mensaje + "\n");
            Escritura.flush();
           this.client.close();

        }
        catch(IOException excep){
            System.out.print(excep.getMessage());
        }
    }
    public void EnviarMensaje1(){

        while(this.Enviando) {
            if(this.MensajePendiente) {

                try {
                    //this.ConectarEnviarFijo();
                    OutputStreamWriter Escritura = new OutputStreamWriter(this.client.getOutputStream());
                    Escritura.write(this.MensajeaEnviar + "\n");
                    Escritura.flush();
                    //this.client.close();
                } catch (IOException excep) {
                    System.out.println(excep.getMessage());
                }
                this.MensajePendiente=false;
            }
        }
    }
    public void setEnviando(boolean valor){
        this.Enviando=valor;
    }
    public void setMensajeaEnviar(String Mensaje){
        this.MensajeaEnviar=Mensaje;
    }
    public void setMensajePendiente(boolean valor){
        this.MensajePendiente=valor;
    }

    public int getPort(){
        return this.port;
    }
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