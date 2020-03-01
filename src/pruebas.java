import Conexiones.Enlace;

public class pruebas {
    public static void main(String[] args){

        Enlace Cliente=new Enlace(40002, "127.0.0.1");
        Cliente.ConectarEnviarVariable();
        System.out.println("Me conecte a "+Cliente.getPort());
        Cliente.EnviarMensaje("40001~Vida a milton");

    }
}
