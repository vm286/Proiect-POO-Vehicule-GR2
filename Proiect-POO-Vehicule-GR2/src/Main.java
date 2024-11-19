//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Vehicul{
    public static void main(String[] args) {
        Avion av = new Avion();
        Submarin sub = new Submarin();
        System.out.println(av);
        System.out.println(sub);

    Motocicleta motocicleta1 = new Motocicleta(0,"bmw",2004,"ROSU",1400,true );
    System.out.println(motocicleta1);
    }
}