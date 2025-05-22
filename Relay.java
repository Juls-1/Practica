public class Relay extends Component{
    private boolean isOn;

    public Relay(String name){
        super(name);
        isOn=false;
    }
    public Relay(String name, boolean isOn){
        super(name);
        this.isOn=isOn;
    }

    public void amplifySignal(String signal){
        if (isOn){
            setSignal(signal);
            setSignalStrength(1);
            processSignal(getSignal());
        } 
        else {System.out.println("El rele esta apagado"); }
    }


    @Override
    public void processSignal(String signal) {
        System.out.println("Señal Amplificada en rele: "+signal+" -Intensidad: "+(getSignalStrength()*100)+"%");
    }

    public void setOn(){ isOn=true;}
    public void setOff(){ isOn=false;}
    public boolean getIsOn(){ return isOn;}
}