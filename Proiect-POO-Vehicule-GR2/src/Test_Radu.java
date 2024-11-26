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
            System.out.println(m);
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
        Tractor JohnDeere = new Tractor(24, "John Deere", 2015, "VERDE", 150, "cauciucuri", 30.0, 7000, false);
        Tractor MasseyFerguson = new Tractor(20, "Massey Ferguson", 2012, "ROSU", 120, "cauciucuri", 28.0, 6000, false);
        Tractor NewHolland = new Tractor(18, "New Holland", 2018, "ALBASTRU", 140, "cauciucuri", 32.5, 4800, true);
        Tractor Fendt = new Tractor(26, "Fendt", 2020, "VERDE", 300, "senile", 35.0, 5500, true);
        Tractor Case = new Tractor(25, "Case", 2017, "GALBEN", 280, "senile", 29.5, 6400, false);
        Tractor Valtra = new Tractor(20, "Valtra", 2014, "NEGRU", 130, "cauciucuri", 27.0, 5900, true);
        Tractor DeutzFahr = new Tractor(30, "Deutz-Fahr", 2019, "VERDE", 175, "cauciucuri", 33.5, 5100, false);
        Tractor Kubota = new Tractor(16, "Kubota", 2016, "PORTOCALIU", 100, "cauciucuri", 26.0, 4500, false);
        Tractor Zetor = new Tractor(18, "Zetor", 2013, "ROSU", 125, "cauciucuri", 28.5, 5300, false);
        Tractor Belarus = new Tractor(23, "Belarus", 2021, "ALB", 190, "cauciucuri", 34.0, 5700, true);

        ArrayList<Tractor> tractoare= new ArrayList<>();
        tractoare.add(JohnDeere);
        tractoare.add(MasseyFerguson);
        tractoare.add(NewHolland);
        tractoare.add(Fendt);
        tractoare.add(Case);
        tractoare.add(Valtra);
        tractoare.add(DeutzFahr);
        tractoare.add(Kubota);
        tractoare.add(Zetor);
        tractoare.add(Belarus);

        //for_each
        System.out.println("Lista de tractoare este: ");
        for (Tractor p : tractoare) {
            System.out.println(p);
        }

        System.out.println("Lista de tractoare cu incacator si senile este: ");
        for (Tractor p : tractoare) {
            if(p.getIncarcator()==true && p.getTip_roti()=="senile")
                System.out.println(p);
        }
    }
}
