import java.util.ArrayList;

public class Test_Nastasache {
    public static void main(String[] args) {
        //metoda for-each
        ArrayList<Motocicleta> listaMotociclete = Motocicleta.getListaMotociclete();
        System.out.println("lista de motociclete este: ");
        for (Motocicleta m : Motocicleta.getListaMotociclete()) {
            System.out.println(m);
        }
        System.out.println("lista de motociclete electrice cu atas este: ");
        for (Motocicleta n : Motocicleta.getListaMotociclete()) {
            if (n.isEsteElectric() && n.isAreAtas())
                System.out.println(n);
        }
        System.out.println("lista de motociclete electrice fara atas este: ");
        for (Motocicleta n : Motocicleta.getListaMotociclete()) {
            if (n.isEsteElectric() && !n.isAreAtas())
                System.out.println(n);
        }
    }
}
