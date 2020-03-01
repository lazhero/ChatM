import Conexiones.Enlace;

public class pruebas {
    public static void main(String[] args){
<<<<<<< HEAD
        Enlace Cliente=new Enlace(40000, "127.0.0.1");
        Cliente.ConectarEnviarVariable();
        //Cliente.setEscritura();
=======
        Enlace Cliente=new Enlace(40002, "127.0.0.1");
        Cliente.ConectarEnviarFijo();
>>>>>>> parent of 2a486ac... #2
        System.out.println("Me conecte a "+Cliente.getPort());
        Cliente.EnviarMensaje("40000~Milton puto amo");
    }
}
