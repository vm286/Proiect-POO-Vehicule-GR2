public class Tractor extends Vehicul{
    private int cai_putere;
    private String starea_curenta;
    private double consum_combustibil;
    private int ore_functionare;
    private boolean incarcator;

    //Constructor fara argumente
    public Tractor(){
        super();
        this.cai_putere = 0;
        this.starea_curenta = "nespecificat";
        this.consum_combustibil = 0;
        this.ore_functionare = 0;
        this.incarcator = false;
    }
    //Constructor cu toate argumentele
    public Tractor(int id, String marca, int anFabricatie , String culoare , int cai_putere, String starea_curenta , double consum_combustibil , int ore_functionare , boolean incarcator){
        super(id,marca,anFabricatie,culoare);
        this.cai_putere = cai_putere;
        this.starea_curenta = starea_curenta;
        this.consum_combustibil = consum_combustibil;
        this.ore_functionare = ore_functionare;
        this.incarcator = incarcator;
    }
    //Constrictor de copiere
    public Tractor(Tractor tr){
        super(tr);
        this.cai_putere = tr.cai_putere;
        this.starea_curenta = tr.starea_curenta;
        this.consum_combustibil = tr.consum_combustibil;
        this.ore_functionare = tr.ore_functionare;
        this.incarcator = tr.incarcator;
    }
    //Metoda toString
    @Override
    public String toString(){
        return "Tractorul " + super.getMarca() + " cu puterea de " + cai_putere + " cp si are un consum de " + consum_combustibil + " si este " + starea_curenta + " si acum are " + ore_functionare + " ore de functionare si " + (incarcator?" are incarcator ":" nu are incarcator ")+ ".";
    }


}


