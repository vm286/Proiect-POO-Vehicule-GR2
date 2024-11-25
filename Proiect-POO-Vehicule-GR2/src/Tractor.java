public class Tractor extends Vehicul{
    private int cai_putere;
    private String starea_curenta;
    private double consum_combustibil;

    //Constructor fara argumente
    public Tractor(){
        super();
        this.cai_putere = 0;
        this.starea_curenta = "nespecificat";
        this.consum_combustibil = 0;
    }
    //Constructor cu toate argumentele
    public Tractor(int id, String marca, int anFabricatie , String culoare , int cai_putere, String starea_curenta , double consum_combustibil){
        super(id,marca,anFabricatie,culoare);
        this.cai_putere = cai_putere;
        this.starea_curenta = starea_curenta;
        this.consum_combustibil = consum_combustibil;
    }
    //Constrictor de copiere
    public Tractor(Tractor tr){
        super(tr);
        this.cai_putere = tr.cai_putere;
        this.starea_curenta = tr.starea_curenta;
        this.consum_combustibil = tr.consum_combustibil;
    }
    //Metoda toString
    @Override
    public String toString(){
        return "Tractorul " + super.getMarca() + " cu puterea de " + cai_putere + " cp si are un consum de " + consum_combustibil + " si este " + starea_curenta;
    }


}


