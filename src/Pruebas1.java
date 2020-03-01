import Conexiones.EnlaceServidores;

public class Pruebas1 {
    public static void main(String[] args){
        EnlaceServidores Lectura=new EnlaceServidores(40000);
        Lectura.ConectarRecepVariable();
        System.out.println("El puerto es "+Lectura.getPort());
        String[] Mensaje=Lectura.RecibirMensaje();
        System.out.println(Mensaje[0]);
    }

}
