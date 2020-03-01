import Conexiones.Enlace;

public class pruebas {
    public static void main(String[] args){
        Enlace Cliente=new Enlace(40000, "127.0.0.1");
        Cliente.ConectarEnviarFijo();
        Cliente.setEscritura();
        System.out.println("Me conecte a "+Cliente.getPort());
        for(int i=0;i<10;i++){
            Cliente.EnviarMensaje("40000~Milton puto amo");
        }
    }
}
