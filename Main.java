public class Main {
    public static void main(String[] args) {
        
        Transmitter t1 = new Transmitter("T1");
        Cable c1= new Cable("C1", 8, 10, 5);
        Relay re1= new Relay("RE1", true);
        Cable c2= new Cable("C2", 20, 2, 7);
        Cable c3= new Cable("C3", 5,10, 10);
        Receiver r1 = new Receiver("R1");

        Component[] componentes = {t1, c1, re1, c2, r1};
        Component[] componentes2 = {t1, c3, r1};
        TelegraphSystem sistema = new TelegraphSystem(componentes);
        TelegraphSystem sistema2= new TelegraphSystem(componentes2);

        String signal1 = "SOS";
        String signal2 = "Hola Mundo";
        
        sistema.run(signal1);
        System.out.println("R1 recibio: "+r1.displayMessage());

        System.out.println("\n----------------------------------");
        t1.setOn();
        c1.setSignalStrength(0.2);
        sistema.run(signal1);
        System.out.println("R1 recibio: "+r1.displayMessage());

        System.out.println("\n----------------------------------");
        re1.setOff();
        sistema.run(signal1);
        System.out.println("R1 recibio: "+r1.displayMessage());

        System.out.println("\n----------------------------------");
        sistema2.run(signal2);        
        System.out.println("R1 recibio: "+r1.displayMessage());
    }
}
    

    

