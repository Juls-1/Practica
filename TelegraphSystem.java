public class TelegraphSystem {
    private Component[] components;

    public TelegraphSystem(Component[] components){
        this.components = components;
    }

    public void run(String signal){
        if(components[0] instanceof Transmitter && components[components.length-1] instanceof Receiver){
            System.out.println("PLaceholder");
    }
    
}
