/** 
 * Esse é o sensor de temperatura, ele extende a classe sensor
 * extendendo seus valores para imitar como um sensor de temperatura se comportaria
 * @author Lucas Matheus Nunes Pereira
 * @see Sensor
*/
public class SensorTemperature extends Sensor<Double> {
    /**
     * @see SensorTemperature
     * @param name nome do sensor
     * @param local local onde está instalada
     */
    public SensorTemperature(String name, String local) {
        super(local, name, "temperature", "°C");
        this.reading = new Type<>(random.nextDouble(100), unity);
    }

    /**
     * @see Sensor#getReading()
     * retorna os valores lidos pelo sensor:
     * 
     * @return type<Double>
     * Unidade de medida: °C
     * Valores: Double
     */
    @Override
    public Type<Double> getReading() {
        this.reading = new Type<>(random.nextDouble(100), unity);
        return reading;
    }
}
