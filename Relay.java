public class Relay extends Component{
    private boolean isOn;

    public Relay(String name){
        super(name);
        isOn=false;
    }

    public void amplifySignal(String signal){
        if (isOn){
            setSignalStrength(1);
            
        } 
        else {System.out.println("El rele esta apagado"); }
    }


    @Override
    public void processSignal(String signal) {
        System.out.println("Enviando senyal: "+signal);
    }
}