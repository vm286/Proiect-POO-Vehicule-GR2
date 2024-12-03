import java.util.ArrayList;

public class Test_Mirea {
    public static void main(String[] args) {
        // Instanțe și afișări pentru clasa Vehicul
        Vehicul ford = new Vehicul();
        Vehicul toyota = new Vehicul(1, "Toyota", 2015, "Roșu");
        Vehicul toyotaCopy = new Vehicul(toyota);
        System.out.println(ford);
        System.out.println(toyota);
        System.out.println(toyotaCopy + "\n");

        // Instanțe și afișări pentru clasa Tren
        Tren intercity = new Tren();
        Tren marfar = new Tren(2, "Marfar", true, "CFR", 2009, "Alb", 50, "București - Cluj", 120);
        Tren marfarCopy = new Tren(marfar);
        System.out.println(intercity);
        System.out.println(marfar);
        System.out.println(marfarCopy + "\n");

        // Instanțe și afișări pentru clasa Vapor
        Vapor yacht = new Vapor();
        Vapor cargo = new Vapor(3, "Cargo", false, "Maersk", 2018, "Albastru", 5000.5, 25, "Rotterdam - Constanța");
        Vapor cargoCopy = new Vapor(cargo);
        System.out.println(yacht);
        System.out.println(cargo);
        System.out.println(cargoCopy + "\n");

        ArrayList<Tren> trenuri = new ArrayList<>();
        trenuri.add(new Tren(4, "Marfar", true, "CFR", 2010, "Roșu", 30, "București - Constanța", 100));
        trenuri.add(new Tren(5, "Personal", false, "SNCF", 2005, "Albastru", 20, "Cluj - Oradea", 80));
        trenuri.add(new Tren(6, "Rapid", true, "DB", 2018, "Gri", 50, "Timișoara - Arad", 120));
        trenuri.add(new Tren(7, "Intercity", true, "Renfe", 2019, "Negru", 40, "Sibiu - Brașov", 140));
        trenuri.add(new Tren(8, "Marfar", false, "ČD", 2000, "Alb", 35, "Iași - Suceava", 70));
        trenuri.add(new Tren(9, "Personal", true, "VR", 2013, "Galben", 25, "Buzău - Brăila", 90));
        trenuri.add(new Tren(10, "Rapid", false, "OBB", 2009, "Portocaliu", 45, "Galați - Tulcea", 110));
        trenuri.add(new Tren(11, "Intercity", true, "PKP", 2021, "Mov", 60, "Târgu Mureș - Alba Iulia", 160));
        trenuri.add(new Tren(12, "Marfar", false, "CP", 2015, "Verde", 50, "Satu Mare - Baia Mare", 75));
        trenuri.add(new Tren(13, "Personal", true, "JR", 2012, "Maro", 20, "Pitești - Craiova", 95));
        System.out.println("Lista de trenuri:");
        for (Tren t : trenuri) {
            System.out.println(t);
        }
        System.out.println("\n");

        ArrayList<Vapor> vapoare = new ArrayList<>();
        vapoare.add(new Vapor(14, "Cargo", true, "Maersk", 2015, "Roșu", 5000.0, 30, "Rotterdam - Constanța"));
        vapoare.add(new Vapor(15, "Pasageri", false, "MSC", 2018, "Alb", 8000.0, 50, "Barcelona - Genova"));
        vapoare.add(new Vapor(16, "Cargo", false, "Hapag", 2020, "Albastru", 4500.0, 25, "Hamburg - Londra"));
        vapoare.add(new Vapor(17, "Pasageri", true, "Carnival", 2017, "Negru", 10000.0, 60, "Miami - Bahamas"));
        vapoare.add(new Vapor(18, "Cargo", false, "CMA CGM", 2013, "Gri", 4000.0, 20, "Shanghai - Los Angeles"));
        vapoare.add(new Vapor(19, "Pasageri", true, "Norwegian", 2019, "Verde", 12000.0, 70, "Atena - Istanbul"));
        vapoare.add(new Vapor(20, "Cargo", false, "COSCO", 2014, "Galben", 3000.0, 15, "Hong Kong - Singapore"));
        vapoare.add(new Vapor(21, "Pasageri", true, "Princess", 2021, "Mov", 11000.0, 65, "Sydney - Auckland"));
        vapoare.add(new Vapor(22, "Cargo", false, "ZIM", 2012, "Maro", 3500.0, 18, "Mombasa - Durban"));
        vapoare.add(new Vapor(23, "Pasageri", true, "Royal Caribbean", 2016, "Portocaliu", 15000.0, 80, "New York - Bermuda"));
        System.out.println("Lista de vapoare:");
        for (int i = 0; i < vapoare.size(); i++) {
            System.out.println(vapoare.get(i));
        }
        System.out.println("\n");

        vapoare.set(4,new Vapor(cargo));

        for (int i = 0; i < vapoare.size(); i++) {
            System.out.println(vapoare.get(i));
        }

        System.out.println("\n");

        System.out.println("Trenuri electrice cu viteză minimă de 100 km/h:");
        for (Tren t : trenuri) {
            if (t.getEsteElectric() && t.getVitezaMaxima() > 100) {
                System.out.println(t);
            }
        }
        System.out.println("\n");

        System.out.println("Trenuri care nu sunt electrice dar care sunt marfare:");
        for (Tren t : trenuri) {
            if (!t.getEsteElectric() && t.getTipTren().equals("Marfar")) {
                System.out.println(t);
            }
        }
        System.out.println("\n");


        System.out.println("Vapoare care nu sunt spărgătoare de gheață și au capacitate echipaj mai mare de 15:");
        for (Vapor v : vapoare) {
            if (!v.getSpargatorGheata() && v.getCapacitateEchipaj() > 15) {
                System.out.println(v);
            }
        }
        System.out.println("\n");

        System.out.println("Vapoare care sunt spărgătoare de gheață, au capacitate echipaj mai mare de 15 și culoarea portocalie:");
        for (Vapor v : vapoare) {
            if (v.getSpargatorGheata() && v.getCapacitateEchipaj() > 15 && v.getCuloare().equals("Portocaliu")) {
                System.out.println(v);
            }
        }
    }
}

