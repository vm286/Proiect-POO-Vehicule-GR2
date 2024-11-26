import java.awt.*;
import java.util.ArrayList;

public class Test_Vlad {
    public static void main(String[] args) {
        Vehicul Echo1 = new Vehicul();
        Vehicul Echo2 = new Vehicul(1,"Oceaniada",2011,"Galben");
        Vehicul Echo4 = new Vehicul(Echo2);

        System.out.println(Echo1);
        System.out.println(Echo2);
        System.out.println(Echo4);

        Submarin Sub1 = new Submarin();
        Submarin Sub2 = new Submarin("Nautilus", 5000, 1, 1870, "Gri", 2500, "Diesel", "Lanseza torpile");
        Submarin Sub3 = new Submarin(Sub2);
        System.out.println(Sub1);
        System.out.println(Sub2);
        System.out.println(Sub3);

        Avion Av1 = new Avion();
        Avion Av2 = new Avion("Fairchild", "A-10", 5, 1977, "Gri", 3000, 2, 8, "Jet x 2");
        Avion Av3 = new Avion(Av1);

        System.out.println(Av1);
        System.out.println(Av2);
        System.out.println(Av3);
        ArrayList<Submarin> Submarine = Submarin.getListaSubmarine();
        ArrayList<Avion> avioane = Avion.getListaAvioane();
        System.out.println("Lista avioanelor:");
        for(Avion av : Avion.getListaAvioane()) {
            System.out.println(av);
        }
        System.out.println("Lista avioane cu motor cu reactie:");
        for(Avion av : avioane) {
            if(av.isJetType()){
                System.out.println(av);
            }
        }
        System.out.println("Lista avioane cu elice:");
        for(Avion av : avioane) {
            if(av.isJetType()==false){
                System.out.println(av);
            }
        }
        System.out.println("Lista submarine:");
        for(Submarin sub : Submarine) {
            System.out.println(sub);
        }
        System.out.println("Lista submarine cu combustibil nuclear:");
        for(Submarin sub : Submarine) {
            if(sub.isNuclear()){
                System.out.println(sub);
            }
        }
        System.out.println("Lista submarine cu combustibil conventional:");
        for(Submarin sub : Submarine) {
            if(sub.isNuclear()==false){
                System.out.println(sub);
            }
        }
        
    }
}
