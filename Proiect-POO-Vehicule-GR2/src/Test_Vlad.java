import java.util.ArrayList;

public class Test_Vlad {
    public static void main(String[] args) {
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
        
    }
}
