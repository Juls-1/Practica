public class TelegraphSystem {
    private Component[] components;

    public TelegraphSystem(Component[] components){
        this.components=components;
    }

    public void run(String signal){
        if (!isValidConfiguration()){
            System.out.println("Configuracion no soportada");
        }
        if(((Transmitter) components[0]).canSendSignal()) {
            startTransmision(signal);
            processComponents();
            deliverToReceiver();
        }
        else {
            System.out.println("El emisor no puede enviar la señal");
        }    
    }

    private boolean isValidConfiguration(){
        return components[0] instanceof Transmitter && components[components.length-1] instanceof Receiver;
    }

    private void startTransmision(String signal){
        ((Transmitter) components[0]).sendSignal(signal);
        components[0].setSignalStrength(1.0);
    }

    private void processComponents(){
        for (int i=1; i<components.length-1; i++){
            Component prev=components[i-1];
            Component curr=components[i];

            if (curr instanceof Cable) {
                prev = prevWhenRealyOff(prev, i);
                processCable((Cable) curr, prev);
                if (!((Cable) curr).canTransmit()){
                    if(((Cable) curr).hasFailed()){
                        System.out.println("El cable ha fallado y no puede transmitir la señal");
                    }
                    else{
                    System.out.println("La señal es demasiado debil para ser transmitida por el cable");
                    }
                    cleanReceiver();
                }
            } else if (curr instanceof Relay) {
                processRelay((Relay) curr, prev);
            } else {
                curr.setSignalStrength(prev.getSignalStrength());
                curr.processSignal(prev.getSignal());
            }
        }
    }

    private Component prevWhenRealyOff(Component prev, int i){
        if (prev instanceof Relay && !((Relay) prev).getIsOn() && i >= 2) {
            return components[i-2];
        }
        return prev;
    }

    private void processCable(Cable cable, Component prev){
        cable.setSignalStrength(prev.getSignalStrength());
        double newStrength = prev.getSignalStrength() * (1 - (cable.getLength() * cable.getSignalLossXKm())/100);
        newStrength = Math.round(newStrength * 100.0)/100.0;
        cable.setSignalStrength(newStrength);
        if (cable.canTransmit()) {
            cable.transmit(prev.getSignal());
        }
    }

    private void processRelay(Relay relay, Component prev){
        if (relay.getIsOn()){
            relay.setSignalStrength(1.0);
            relay.amplifySignal(prev.getSignal());
        } else {
            System.out.println("El rele esta apagado");
            relay.setSignalStrength(prev.getSignalStrength());
            relay.setSignal(prev.getSignal());
        }
    }

    private void cleanReceiver(){
        Receiver receiver = (Receiver) components[components.length-1];
        receiver.setSignal("");
        receiver.setSignalStrength(0);
    }

    private void deliverToReceiver() {
        Component last = components[components.length-2];
        Receiver receiver = (Receiver) components[components.length-1];
        receiver.setSignalStrength(last.getSignalStrength());
        receiver.receiveSignal(last.getSignal());
    }
}