public class Tractor extends Vehicul{
    private int cai_putere;
    private String tip_roti;
    private double consum_combustibil;
    private int ore_functionare;
    private boolean incarcator;

    //Constructor fara argumente
    public Tractor(){
        super();
        this.cai_putere = 0;
        this.tip_roti = "nespecificat";
        this.consum_combustibil = 0;
        this.ore_functionare = 0;
        this.incarcator = false;
    }
    //Constructor cu toate argumentele
    public Tractor(int id, String marca, int anFabricatie , String culoare , int cai_putere, String starea_curenta , double consum_combustibil , int ore_functionare , boolean incarcator){
        super(id,marca,anFabricatie,culoare);
        this.cai_putere = cai_putere;
        this.tip_roti = starea_curenta;
        this.consum_combustibil = consum_combustibil;
        this.ore_functionare = ore_functionare;
        this.incarcator = incarcator;
    }
    //Constrictor de copiere
    public Tractor(Tractor tr){
        super(tr);
        this.cai_putere = tr.cai_putere;
        this.tip_roti = tr.tip_roti;
        this.consum_combustibil = tr.consum_combustibil;
        this.ore_functionare = tr.ore_functionare;
        this.incarcator = tr.incarcator;
    }
    //Metoda toString
    @Override
    public String toString(){
        return "Tractorul " + super.getMarca() +" din anul "+super.getAnFabricatie() +" cu puterea de " + cai_putere + " cp si are un consum de " + consum_combustibil + " si este " + tip_roti + " si acum are " + ore_functionare + " ore de functionare si " + (incarcator?"are incarcator ":"nu are incarcator ")+ ".";
    }

    public void setCai_putere(int cai_putere) {
        this.cai_putere = cai_putere;
    }
    public int getCai_putere() {
        return cai_putere;
    }
    public void setTip_roti(String tip_roti) {
        this.tip_roti = tip_roti;
    }
    public String getTip_roti() {
        return tip_roti;
    }
    public void setConsum_combustibil(double consum_combustibil) {
        this.consum_combustibil = consum_combustibil;
    }
    public double getConsum_combustibil() {
        return consum_combustibil;
    }
    public void setOre_functionare(int ore_functionare) {
        this.ore_functionare = ore_functionare;
    }
    public int getOre_functionare() {
        return ore_functionare;
    }
    public void setIncarcator(boolean incarcator) {
        this.incarcator = incarcator;
    }
    public boolean getIncarcator() {
        return incarcator;
    }
}


