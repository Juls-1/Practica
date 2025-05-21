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
        if (getSignalStrength()>threshold) {
            msg=signal;
            sent=true;
            processSignal(signal);
        } 
        else {
            sent=false;
            System.out.println("La senyal es muy debil");}
    }

    private double calculateSignalStrength() {
        return Math.max(0, 1-(length*signalLossXKm));
    }

    @Override
    public void processSignal(String signal) {
        System.out.println("Enviando senyal: "+signal);
    }

    @Override
    public String toString(){
        return super.toString()+
               "\nTipo: Cable"+
               "\nLongitud de Cable: "+length+
               "\nPerdida de Senyal por Km: "+signalLossXKm+
               "\nFuerza de Senyal: "+getSignalStrength()+
               "\nMensaje: "+msg;
    }
    
    public void setSentTrue() {sent=true;}
    public void setSentFalse() {sent=false;}
    public boolean getSent(){ return sent;}
    
}