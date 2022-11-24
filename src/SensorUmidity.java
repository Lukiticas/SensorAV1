/** 
 * Esse é o sensor de umidade, ele extende a classe sensor
 * extendendo seus valores para imitar como um sensor de temperatura se comportaria
 * @author Lucas Matheus Nunes Pereira
 * @see Sensor
*/
public class SensorUmidity extends Sensor<Integer> {
    /**
     * @see SensorUmidity
     * @param name nome do sensor
     * @param local local onde está instalada
     */
    public SensorUmidity(String name, String local) {
        super(local, name, "umidity", "%");
        this.reading = new Type<>(random.nextInt(100), unity);
    }

    /**
     * @see Sensor#getReading()
     * retorna os valores lidos pelo sensor:
     * 
     * @return type<Integer>
     * Unidade de medida: %
     * Valores: Integer
     */
    @Override
    public Type<Integer> getReading() {
        this.reading = new Type<>(random.nextInt(100), unity);
        return reading;
    }
}
