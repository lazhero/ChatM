import Conexiones.Enlace;

public class pruebas {
    public static void main(String[] args){
        Enlace Cliente=new Enlace(4000, "127.0.0.1");
        Cliente.ConectarEnviarVariable();
        Cliente.EnviarMensaje("Milton puto amo");
    }
}
