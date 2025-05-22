public class TelegraphSystem {
    private Component[] components;

    public TelegraphSystem(Component[] components){
        this.components = components;
    }

    public void run(String signal) {
        if (components[0] instanceof Transmitter && components[components.length-1] instanceof Receiver) {
            if(((Transmitter) components[0]).canSendSignal()){
                ((Transmitter) components[0]).sendSignal(signal);

                for (int i=1; i<components.length-1; i++) {
                    if (components[i] instanceof Cable) {
                        if (((Cable) components[i]).canTransmit()) {
                            ((Cable) components[i]).transmit(components[i-1].getSignal());
                        } else {
                            System.out.println("La señal es demasiado debil para ser transmitida por el cable");
                        }
                    } 
                    else if (components[i] instanceof Relay) {
                        if (i>1 && components[i-1] instanceof Cable) {
                            ((Relay) components[i]).amplifySignal(components[i-1].getSignal());
                        } else {
                            components[i].processSignal(signal);
                        }
                    } else {
                        components[i].processSignal(signal);
                    }
                }
                ((Receiver) components[components.length-1]).receiveSignal(components[components.length-2].getSignal());
            }
            else{
                System.out.println("El emisor no puede enviar la señal");
            }
        }
        else{   
            System.out.println("Configuracion no soportada");
        }
    }
}