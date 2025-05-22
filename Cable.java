public class Cable extends Component {
    private double length;
    private double signalLossXKm;
    private String msg;
    private double threshold;


    public Cable(String name, double length, double signalLossXKm){
        super(name);
        this.length=length;
        this.signalLossXKm=signalLossXKm;
        setSignalStrength(calculateSignalStrength());
        this.msg="";
        this.threshold=0;
    }

    public Cable(String name, double length, double signalLossXKm, double threshold){
        super(name);
        this.length=length;
        this.signalLossXKm=signalLossXKm;
        setSignalStrength(calculateSignalStrength());
        this.msg="";
        this.threshold=threshold;
    }    
    

    public void transmit(String signal) {
        if (canTransmit()) {
            msg=signal;
            setSignal(signal);
            processSignal(signal);
        } 
    }

    public boolean canTransmit(){
        return getSignalStrength()>threshold/100;
    }

    private double calculateSignalStrength() {
        return Math.max(0, Math.floor(1 - ((length*signalLossXKm)/100))); 
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
    
    public double getLength(){ return length;}
    public double getSignalLossXKm(){ return signalLossXKm;}
}