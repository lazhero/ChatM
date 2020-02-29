import Conexiones.Enlace;

public class pruebas {
    public static void main(String[] args){
        Enlace Cliente=new Enlace(40002, "127.0.0.1");
        Cliente.ConectarEnviarFijo();
        Cliente.EnviarMensaje("40000~Milton puto amo");
    }
}
