public class Cable extends Component {
    private int length;
    private double signalLossXKm;
    private String msg;
    private double threshold;
    private boolean sent;

    public Cable(String name, int length, double signalLossXKm){
        super(name);
        this.length=length;
        this.signalLossXKm=signalLossXKm;
        setSignalStrength(calculateSignalStrength());
        this.msg="";
        this.threshold=0;
        this.sent=false;
    }

    public Cable(String name, int length, double signalLossXKm, double threshold){
        super(name);
        this.length=length;
        this.signalLossXKm=signalLossXKm;
        setSignalStrength(calculateSignalStrength());
        this.msg="";
        this.threshold=threshold;
        this.sent=false;
    }    
    

    public void transmit(String signal) {
        if (canTransmit()) {
            msg=signal;
            sent=true;
            setSignal(signal);
            processSignal(signal);
        } 
        else { sent=false;}
    }

    public boolean canTransmit(){
        return getSignalStrength()>threshold;
    }

    private double calculateSignalStrength() {
        return Math.max(0, 1-((length*signalLossXKm)/100));
    }

    @Override
    public void processSignal(String signal) {
        System.out.println("Señal salio de cable: "+signal+" -Intensidad: "+(getSignalStrength()*100)+"%");
    }

    @Override
    public String toString(){
        return super.toString()+
               "\nTipo: Cable"+
               "\nLongitud de Cable: "+length+
               "\nPerdida de Senyal por Km: "+signalLossXKm+
               "\nFuerza de Senyal: "+(getSignalStrength()*100)+"%"+
               "\nMensaje: "+msg;
    }
    
    public void setSentTrue() {sent=true;}
    public void setSentFalse() {sent=false;}
    public boolean getSent(){ return sent;}
    
}