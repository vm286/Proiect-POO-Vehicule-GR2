public class Submarin extends Vehicul {
private String model,tipCombustibil,tipArmament;
private int tonaj,adancimeMax;
public Submarin(String model, int tonaj, int id, int anFabricatie, String culoare, int adancimeMax, String tipCombustibil, String tipArmament ) {
    super(id,"Submarin", anFabricatie, culoare );
    this.model = model;
    this.tonaj = tonaj;
    this.adancimeMax = adancimeMax;
    this.tipCombustibil = tipCombustibil;
    this.tipArmament = tipArmament;
}
public Submarin(Submarin s) {
    super(s);
    this.model = s.model;
    this.tonaj = s.tonaj;
    this.adancimeMax = s.adancimeMax;
    this.tipCombustibil = s.tipCombustibil;
    this.tipArmament = s.tipArmament;
}
public Submarin() {
    super();
    this.tonaj = 0;
    this.model = "Not Defined";
}
public String getMarca(){
    return "Submarinul nu are marca comerciala.";
}
    @Override
    public String toString() {
        if(model=="Not Defined"){
            return "Nu a fost definit.";
        }
        else{
            return "Submarin model "+model+" de tonaj:"+tonaj+" de tone."    ;
        }
    }
}
