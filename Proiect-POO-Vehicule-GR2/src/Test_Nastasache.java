import java.util.ArrayList;

public class Test_Nastasache {
    public static void main(String[] args) {
// instante si afisari
        // Creare instanțe pentru clasa Vehicul
        Vehicul audi = new Vehicul();
        Vehicul dacia = new Vehicul(1,"dacia",2004,"alb");
        Vehicul dacia2 = new Vehicul(dacia);
        System.out.println(audi);
        System.out.println(dacia);
        System.out.println(dacia2);

        // Creare instanțe pentru clasa Autobuz
        Autobuz tesla = new Autobuz();
        Autobuz Mercedes = new Autobuz(2, true, "Euro6", "mercedes", true, 2021, "Albastru", 40, 101);
        Autobuz mercedes2 = new Autobuz(Mercedes);
        System.out.println(tesla);
        System.out.println(Mercedes);
        System.out.println(mercedes2);

        // Creare instanțe pentru clasa Motocicleta
        Motocicleta bmw = new Motocicleta();
        Motocicleta honda = new Motocicleta(3, "Euro5", 2, false, "Honda", 2019, "Negru", 1000, true);
        Motocicleta honda2 = new Motocicleta(honda); // Copiere din motocicleta2
        System.out.println(bmw);
        System.out.println(honda);
        System.out.println(honda2);


        //vectori
        //metoda for-each si utilizare de getter
        ArrayList<Motocicleta> listaMotociclete = Motocicleta.getListaMotociclete();
        System.out.println("lista de motociclete este: ");
        for (Motocicleta m : Motocicleta.getListaMotociclete()) {
            System.out.println(m);
        }

        //afisare instante care satisfac doua conditii introduse de utilizator
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
    //metoda for-each cu scrierea listei in clasa test
        Autobuz mercedes= new Autobuz(1,true,"euro6","Mercedes",true,2019,"alb",60,52);
        Autobuz volvo= new Autobuz(2,false,"euro3","Volvo",true,2017,"alb",60,40);
        Autobuz iveco = new Autobuz(3,false,"euro2","Iveco",true,2013,"negru",50,33);
        Autobuz Iveco =new Autobuz(4,true,"euro6","Iveco",true,2020,"gri",35,20);
        Autobuz scania= new Autobuz(5,true,"euro6","Scania",true,2019,"alb",60,51);
        Autobuz volvo2= new Autobuz(6,false,"euro3","Volvo",true,2017,"alb",65,43);
        Autobuz scania2 = new Autobuz(7,false,"euro2","Scania",true,2013,"negru",50,35);
        Autobuz scania3 =new Autobuz(8,true,"euro6","Scania",true,2020,"gri",35,25);
        Autobuz man= new Autobuz(9,true,"euro6","MAN",true,2019,"alb",60,70);
        Autobuz man2= new Autobuz(10,false,"euro3","MAN",true,2009,"alb",48,76);

        ArrayList<Autobuz> autobuze = new ArrayList<>();
        autobuze.add(mercedes);
        autobuze.add(volvo);
        autobuze.add(iveco);
        autobuze.add(Iveco);
        autobuze.add(scania);
        autobuze.add(scania2);
        autobuze.add(scania3);
        autobuze.add(man);
        autobuze.add(man2);
        autobuze.add(volvo2);
        //metoda for-each

        System.out.println("lista de autobuze este: ");
        for (Autobuz m : autobuze) {
            System.out.println(m);
        }

        //afisare instante care satisfac doua conditii introduse de utilizator
        System.out.println("lista de autobuze electrice cu aer conditionat este: ");
        for (Autobuz n : autobuze) {
            if (n.isEsteElectric() && n.isAerConditionat())
                System.out.println(n);
        }
        System.out.println("lista de motociclete electrice fara aer conditionat este: ");
        for (Autobuz n : autobuze) {
            if (n.isEsteElectric() && !n.isAerConditionat())
                System.out.println(n);
        }

    }

}
