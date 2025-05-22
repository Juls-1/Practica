public class Receiver extends Component {
    private Translator translator;
        private String msg;

    public Receiver(String name) {
        super(name);
        translator = new Translator();
        msg="";
    }

    public void receiveSignal(String signal) {
        translator.translateFromMorse(signal);
        setSignal(translator.getMsg());
        msg=translator.getMsg();
        processSignal(getSignal());
    }

    public String displayMessage() {
        return getMsg();
    }
    
    @Override 
    public void processSignal(String signal){
        System.out.println("Señal llego a receiver: "+ signal);
    }

    public String getMsg(){ return this.msg;}
}