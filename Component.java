public abstract class Component{
    private String name;
    private double signalStrength;

    public Component(String name){
        this.name = name;
    }

    public void setName(String name){ this.name= name;}
    public void setSignalStrength(double signalStrength){this.signalStrength=signalStrength;}
    public String getName() {return name; }
    public double getSignalStrength() {return signalStrength;};

    @Override
    public String toString(){
        return "Nombre del Componente: " + name;
    }

    public abstract void processSignal(String signal);
}