public class Receiver extends Component {
    private String msg;
    private Translator translator;
    
    public Receiver(String name) {
        super(name);
        msg = "";
    }

    public void receiveSignal(String signal) {
        translator.translateFromMorse(signal);
        msg = translator.getMsg();
    }

    public void displayMessage() {
        System.out.println("Mensaje recibido: " + msg);
    }
    
    @Override 
    public void processSignal(String signal){
    }
}