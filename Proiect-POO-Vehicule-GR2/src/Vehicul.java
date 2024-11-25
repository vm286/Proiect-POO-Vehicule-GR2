
public class Vehicul {
    private int id;
    private String marca;
    private int anFabricatie;
    private String culoare;

    // Constructor fără argumente
    public Vehicul() {
        this.id = 0;
        this.marca = "Necunoscut";
        this.anFabricatie = 0;
        this.culoare = "Necunoscut";
    }

    // Constructor cu toate argumentele
    public Vehicul(int id, String marca, int anFabricatie, String culoare) {
        this.id = id;
        this.marca = marca;
        this.anFabricatie = anFabricatie;
        this.culoare = culoare;
    }

    // Constructor de copiere
    public Vehicul(Vehicul other) {
        this.id = other.id;
        this.marca = other.marca;
        this.anFabricatie = other.anFabricatie;
        this.culoare = other.culoare;
    }

    // Metoda toString
    @Override
    public String toString() {
        return "Vehicul ID: " + id + ", Marca: " + marca + ", An: " + anFabricatie + ", Culoare: " + culoare;
    }

    // Getteri și setteri (opțional)
    public int getId(){
        return id;
    }
    public String getMarca(){ return "marca " + marca;}
    public int getAnFabricatie(){
        return anFabricatie;
    }
    public String getCuloare(){
        return culoare;
    }

    
}

