//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
Avion av = new Avion();
Submarin sub=new Submarin();
System.out.println(av);
System.out.println(sub);
Tractor tractor1= new Tractor(22,"Same",2010,"ROSU",110, "functional" );
System.out.println(tractor1);
Tren IR1802 = new Tren(1802,"CFR",2004,"ALBASTRU",3,"NORMAL");
System.out.println(IR1802);
Vapor Combi_Freighter_4500=new Vapor(4500,"DAMEN",2024,"ALB",2950,"MARFAR");
System.out.println(Combi_Freighter_4500);
    }
}