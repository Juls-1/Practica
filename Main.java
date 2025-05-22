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


        System.out.println("\n========== SISTEMA CON REPEATER ==========");
        Transmitter t2= new Transmitter("T2", true);
        Cable c4= new Cable("C4", 15, 4, 10);
        Repeater rep1= new Repeater("REP1", 3, true);  
        Cable c5= new Cable("C5", 10, 5, 10);
        Receiver r2= new Receiver("R2");

        Component[] componentes3 = {t2, c4, rep1, c5, r2};
        TelegraphSystem sistema3 = new TelegraphSystem(componentes3);

        System.out.println("\n--- Caso 1: Señal con repeater con bateria ---");
        sistema3.run("PRUEBA");
        System.out.println("R2 recibio: " + r2.displayMessage());
        System.out.println(rep1);

        System.out.println("\n--- Caso 2: Agotar bateria del repeater ---");
        for (int i = 2; i <= 4; i++) {
            sistema3.run("PRUEBAA");
            System.out.println("R2 recibio: " + r2.displayMessage());
            System.out.println(rep1);
        }

        System.out.println("\n--- Caso 3: Recargar repeater ---");
        rep1.recharge();
        sistema3.run("PRUEBAAA");
        System.out.println("R2 recibio: " + r2.displayMessage());
        System.out.println(rep1);
    }
}
    

    

