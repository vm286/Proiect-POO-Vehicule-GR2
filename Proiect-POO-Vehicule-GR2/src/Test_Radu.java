import java.util.ArrayList;
public class Test_Radu {
    public static void main(String[] args) {
        //instante clasa masina
        Masina masina1 = new Masina();
        Masina masina2 = new Masina(4, "Dacia", 2010, "Rosu", 1459, "sedan", 123343, 5, "halogen");
        Masina masina3 = new Masina(masina2);
        System.out.println(masina1);
        System.out.println(masina2);
        System.out.println(masina3);

        //instante clasa tractor
        Tractor tractor1 = new Tractor();
        Tractor tractor2 = new Tractor(22, "Same", 2010, "ROSU", 110, "cauciucuri", 25.5, 5008, true);
        Tractor tractor3 = new Tractor(tractor2);
        System.out.println(tractor1);
        System.out.println(tractor2);
        System.out.println(tractor3);

        //vectori
        //metoda for-each cu getter
        ArrayList<Masina> listamasini = Masina.getListaMasini();
        System.out.println("Lista de masini este: ");
        for (Masina m : Masina.getListaMasini()) {
            if(m.getMarca()=="Dacia")
            System.out.println(m);
        }


        ArrayList<Tractor> tractoare = Tractor.getListaTractor();
        //for_each
        System.out.println("Lista de tractoare este: ");
        for (Tractor p : tractoare) {
            System.out.println(p);
        }

        System.out.println("Lista de tractoare cu incacator si senile este: ");
        for (Tractor p : tractoare) {
            if(p.getIncarcator()==true && !p.getTip_roti().contains("senile"))
                System.out.println(p);
        }
        System.out.println("Lista tractoare mai noi de 2015 si cu mai putin de 5000 de ore: ");
        for (Tractor p : tractoare) {
            if(p.getAnFabricatie()>2015 && p.getOre_functionare()<5000)
                System.out.println(p);
        }
        //afisare instante care satisfac doua conditii
        System.out.println("Lista de masini care un sub 150000km si 5 sau mai multe locuri: ");
        for (Masina n : Masina.getListaMasini()) {
            if (n.getNrKilometri() < 150000 && n.getNrLocuri() > 4)
                System.out.println(n);
        }
        System.out.println("Lista masini care sunt mai noi de 2022 si faruri led ");
        for (Masina p : Masina.getListaMasini()) {
            if (p.getTip_faruri()=="LED" && p.getAnFabricatie()>2022)
                System.out.println(p);
        }
    }
}
