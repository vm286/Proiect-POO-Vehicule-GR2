import java.util.ArrayList;

public class Test_Mirea {
    public static void main(String[] args) {
        ArrayList<Tren> trenuri = new ArrayList<>();

        // Adăugare de trenuri în lista
        Tren a = new Tren(1, "Siemens", 2018, "Albastru", 6, "București - Constanța",true , "InterCity",120 );
        Tren b = new Tren(2, "Alstom", 2015, "Verde", 8, "Cluj - Oradea", false, "Regional", 120);
        Tren c = new Tren(3, "Bombardier", 2020, "Roșu", 10, "Timișoara - Sibiu", true, "High-Speed",160 );

        Tren d = new Tren(); // Constructor fără argumente
        Tren e = new Tren(); // Constructor fără argumente
        Tren f = new Tren(a); // Constructor de copiere
        Tren g = new Tren(c); // Constructor de copiere
        Tren h = new Tren();
        Tren i = new Tren();
        Tren j = new Tren();

        // Adăugăm trenurile în ArrayList
        trenuri.add(a);
        trenuri.add(b);
        trenuri.add(c);
        trenuri.add(d);
        trenuri.add(e);
        trenuri.add(f);
        trenuri.add(g);
        trenuri.add(h);
        trenuri.add(i);
        trenuri.add(j);

        // Afișăm trenurile
        System.out.println("Lista de trenuri:");
        for (Tren tren : trenuri) {
            System.out.println(tren);
        }
    }
}
