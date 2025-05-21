public class Transmitter extends Component{
    private boolean isOn;
    private Translator translator;
    private String msg;

    public Transmitter(String name){
        super(name);
        isOn = false;
        msg="";
    }
    public Transmitter(String name, boolean isOn){
        super(name);
        this.isOn = isOn;
    }

    public void sendSignal(String signal){
        if (isOn) {
            msg=signal;
            translator.translateToMorse(signal);
            processSignal(translator.getMsg());
        } 
        else { System.out.println("emisor apagado");}
    }

    @Override
    public void processSignal(String morseMsg){
        System.out.println("Enviando senyal:"+ morseMsg);
    }

    public void setOn(){ isOn=true;}
    public void setOff(){ isOn=false;}
    public boolean isOn(){ return isOn;}
    public String getMsg(){ return this.msg;}
    
    @Override
    public String toString(){
        String estado;
        if(isOn){estado="Encendido";} else{estado="Apagado";}
        return super.toString()+
               "\nTipo: Transmitter"+
               "\nEstado: "+ estado+
               "\nMensaje: "+msg+
               "\nMorse: "+translator.getMsg();
    }
}
