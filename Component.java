public abstract class Component{
    private String name;
    private double signalStrength;
    private String signal;

    public Component(String name){
        this.name = name;
        this.signalStrength=1;
        this.signal="";
    }

    public void setName(String name){ this.name= name;}
    public void setSignalStrength(double signalStrength){this.signalStrength=signalStrength;}
    public void setSignal(String signal){this.signal=signal;}
    public String getName() {return name; }
    public double getSignalStrength() {return signalStrength;};
    public String getSignal() {return signal;}

    @Override
    public String toString(){
        return "Nombre del Componente: " + name;
    }

    public abstract void processSignal(String signal);
}