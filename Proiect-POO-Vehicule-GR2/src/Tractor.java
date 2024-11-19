public class Tractor extends Vehicul{
    private int cai_putere;
    private String starea_curenta;

    //Constructor fara argumente
    public Tractor(){
        super();
        this.cai_putere = 0;
        this.starea_curenta = "nespecificat";
    }
    //Constructor cu toate argumentele
    public Tractor(int id, String marca, int anFabricatie , String culoare , int cai_putere, String starea_curenta){
        super(id,marca,anFabricatie,culoare);
        this.cai_putere = cai_putere;
        this.starea_curenta = starea_curenta;
    }
    //Constrictor de copiere
    public Tractor(Tractor tr){
        super(tr);
        this.cai_putere = tr.cai_putere;
        this.starea_curenta = tr.starea_curenta;
    }
    //Metoda toString
    @Override
    public String toString(){
        return "Tractorul " + super.getMarca() + " cu puterea de " + cai_putere + " cp este " + starea_curenta;
    }


}


