/** 
 * Esse é o sensor de carbono, ele estende a classe sensor
 * extendendo seus valores para imitar como um sensor de carbono se comportaria
 * @author Lucas Matheus Nunes Pereira
 * @see Sensor
*/
public class SensorCarbon extends Sensor<Double> {

    /**
     * @see SensorCarbon
     * @param name nome do sensor
     * @param local local onde está instalada
     */
    public SensorCarbon(String name, String local) {
        super(name, local, "carbon", "mol/CO²");
        this.reading = new Type<Double>(random.nextDouble(100), local);
    }

    /**
     * @see Sensor#getReading()
     * retorna os valores lidos pelo sensor:
     * 
     * @return type<Double>
     * Unidade de medida: mol/CO
     * Valores: Double
     */
    @Override
    public Type<Double> getReading() {
        this.reading = new Type<>(random.nextDouble(100), unity);
        return reading;
    }
}
