import java.util.ArrayList;

public class Test_Nastasache {
    public static void main(String[] args) {
        //metoda for-each
        ArrayList<Motocicleta> listaMotociclete = Motocicleta.getListaMotociclete();
        System.out.println("lista de motociclete este: ");
        for (Motocicleta m : Motocicleta.getListaMotociclete()) {
            System.out.println(m);
        }
    }
}
