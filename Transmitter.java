public class Transmitter extends Component{
    private boolean isOn;
    private Translator translator;
    private String msg;

    public Transmitter(String name){
        super(name);
        isOn = false;
        msg="";
        translator= new Translator();
    }
    public Transmitter(String name, boolean isOn){
        super(name);
        this.isOn = isOn;
        translator = new Translator();
    }

    public void sendSignal(String signal){
        if (canSendSignal()) {
            msg=signal;
            translator.translateToMorse(signal);
            setSignal(translator.getMsg());
            processSignal(signal);
        }
        else{  System.out.println("emisor apagado."); } 
    }

    public boolean canSendSignal(){return isOn; }
    @Override
    public void processSignal(String signal){
        System.out.println("Señal salio de transmitter "+getName()+": "+ signal);
    }

    public void setOn(){ isOn=true;}
    public void setOff(){ isOn=false;}
    public boolean isOn(){ return isOn;}
    public String getMsg(){ return this.msg;}
    
    @Override
    public String toString(){
        String estado;
        if(isOn){estado="Encendido";} 
        else{estado="Apagado";}
        return super.toString()+
               "\nTipo: Transmitter"+
               "\nEstado: "+ estado+
               "\nMensaje: "+msg+
               "\nMorse: "+translator.getMsg();
    }
}
