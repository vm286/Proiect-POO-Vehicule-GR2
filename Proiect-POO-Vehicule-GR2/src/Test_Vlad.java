import java.util.ArrayList;

public class Test_Vlad {
    public static void main(String[] args) {
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
