public class Submarin extends Vehicul {
private String model;
private int tonaj;
public Submarin(String model, int tonaj, int id, int anFabricatie, String culoare ) {
    super(id,"Submarin", anFabricatie, culoare );
    this.model = model;
    this.tonaj = tonaj;
}
public Submarin(Submarin s) {
    super(s);
    this.model = s.model;
    this.tonaj = s.tonaj;
}
public Submarin() {
    super();
    this.model = "Not Defined";
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
