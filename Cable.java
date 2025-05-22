public class Cable extends Component {
    private double length;
    private double signalLossXKm;
    private String msg;
    private double threshold;
    private double baseFailChance;
    private double failLength;
    private double failChance;


    public Cable(String name, double length, double signalLossXKm){
        super(name);
        this.length=length;
        this.signalLossXKm=signalLossXKm;
        setSignalStrength(calculateSignalStrength());
        this.msg="";
        this.threshold=0;
        baseFailChance=0.05;
        failLength=10;
        setFailChance(calculateFailChance());
    }

    public Cable(String name, double length, double signalLossXKm, double threshold){
        super(name);
        this.length=length;
        this.signalLossXKm=signalLossXKm;
        setSignalStrength(calculateSignalStrength());
        this.msg="";
        this.threshold=threshold;
        baseFailChance=0.05;
        failLength=10;
        setFailChance(calculateFailChance());
    }   
    public Cable(String name, double length, double signalLossXKm, double threshold, double baseFailChance, double failLength){
        super(name);
        this.length=length;
        this.signalLossXKm=signalLossXKm;
        setSignalStrength(calculateSignalStrength());
        this.msg="";
        this.threshold=threshold;
        this.baseFailChance=baseFailChance;
        this.failLength=failLength;
        setFailChance(calculateFailChance());
    }   

    public void transmit(String signal) {
        if (canTransmit()) {
            msg=signal;
            setSignal(signal);
            processSignal(signal);
        } 
    }

    public boolean canTransmit(){
        return getSignalStrength()>threshold/100 && !hasFailed();
    }

    private double calculateSignalStrength() {
        return Math.max(0, Math.floor(1 - ((length*signalLossXKm)/100))); 
    }

    @Override
    public void processSignal(String signal) {
        System.out.println("Señal salio de cable: "+signal+" -Intensidad: "+(getSignalStrength()*100)+"%");
    }

    public double calculateFailChance(){
         if(length>failLength){
            failChance=baseFailChance;
        }
        else{
            failChance=Math.round(baseFailChance*(length/failLength));
        }
        return failChance;
    }

    public boolean hasFailed(){
        return Math.random() < failChance;
    }

    @Override
    public String toString(){
        return super.toString()+
               "\nTipo: Cable"+
               "\nLongitud de Cable: "+length+
               "\nPerdida de Señal por Km: "+signalLossXKm+
               "\nFuerza de Señal: "+(getSignalStrength()*100)+"%"+
               "\nMensaje: "+msg+
               "\nPorcentaje de Fallo: "+(getFailChance()*100)+"%";
    }

    public void setFailChance(double failChance){ this.failChance=failChance;}
    public double getLength(){ return length;}
    public double getSignalLossXKm(){ return signalLossXKm;}
    public double getFailChance(){ return failChance;}
}