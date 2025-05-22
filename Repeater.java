public class Repeater extends Component {
    private int batteryLevel;
    private int maxBattery;
    private boolean isOn;
  

    public Repeater(String name, int maxBattery) {
        super(name);
        this.maxBattery = maxBattery;
        this.batteryLevel = maxBattery;
        this.isOn = false;
    }

    public Repeater(String name, int maxBattery, boolean isOn) {
        super(name);
        this.maxBattery = maxBattery;
        this.batteryLevel = maxBattery;
        this.isOn = isOn;
    }

    public void amplifySignal(String signal){
        if (!isOn || batteryLevel <= 0) {
            String status;
            if (batteryLevel <= 0) {
                status = "batería agotada";
            } else {
                status = "apagado";
            }
            System.out.println(getName()+" no puede amplificar la señal: "+status);
            return;
        }

        setSignal(signal);
        setSignalStrength(1.0);
        batteryLevel--;
        System.out.println(getName()+" amplificó la señal. Bateria restante: "+batteryLevel+ "/" +maxBattery +" -Intensidad: "+(getSignalStrength()*100)+"%");
        
        if (batteryLevel == 0){
            System.out.println("¡"+getName()+" se ha quedado sin batería!");
        }
    }

    public void recharge(){
        batteryLevel = maxBattery;
        System.out.println(getName() + "ha sido recargado. Bateria: "+ batteryLevel +"/" +maxBattery);
    }

    public void setOn() { isOn = true; }
    public void setOff() { isOn = false; }
    public boolean isOn() { return isOn && batteryLevel > 0; }
    public int getBatteryLevel() { return batteryLevel; }
    public int getMaxBattery() { return maxBattery; }
    
    @Override
    public void processSignal(String signal){
        if (isOn && batteryLevel > 0) {
            amplifySignal(signal);
        } 
        else {
            String status;
            if (batteryLevel <= 0){
                status = "batería agotada";
            } else {
                status = "apagado";
            }
            System.out.println(getName() +" no puede procesar la señal: " + status);
            setSignal("");
            setSignalStrength(0);
        }
    }
    
    @Override
    public String toString(){
        String estado;
        if (isOn) {  estado = "Encendido";} 
        else { estado = "Apagado"; }
        return super.toString() +
               "\nTipo: Repeater" +
               "\nEstado: "+estado +
               "\nBatería: "+batteryLevel + "/" + maxBattery;
    }
}
