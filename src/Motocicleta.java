public class Motocicleta extends Vehicul{
   String model;
   int capacitateCilindrica;

   public Motocicleta(int id, String culoare, String marca, String model, int anFabricatie, int capacitateCilindrica){
       super(marca, anFabricatie, culoare, id);
       this.model=model;
       this.capacitateCilindrica=capacitateCilindrica;
   }

   public Motocicleta (){

   }

    @Override
    public String toString() {
        return super.toString();
    }

}
