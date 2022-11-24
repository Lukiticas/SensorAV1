/** 
* No enunciado é mencionado que há 3 sensores em um ambiente, essa classe visa emular oque esse ambiente, ou zona, deveria ser.
* Ela é iniciado com 3 sensores, de carbono, de temperatura e de umidade.
 * @author Lucas Matheus Nunes Pereira
*/
public class Zone {
    private String name;
    private SensorCarbon carbon;
    private SensorTemperature temperature;
    private SensorUmidity umidity;

    /**
     * Inicia os três sensores de temperatura, umidade e nivel e carbono.
     * @param name nome do local/zona
     */
    public Zone(String name) {
        this.name = name;
        this.carbon = new SensorCarbon(name + "carbon", name);
        this.temperature = new SensorTemperature(name + "temperature", name);
        this.umidity = new SensorUmidity(name + "umidity", name);
    }

    /**
     * Gera logs com o estado atual dos sensores do ambiente
     * Os valores são aleatórios como explicado nas classes dos sensores.
     * 
     * @see Log 
     * @see Sensor
     * 
     * @return Log
     */
    private Log generateLogs() {
        Type<Double> tempValue = temperature.getReading();
        Type<Double> carbonValue = carbon.getReading();
        Type<Integer> umidityValue = umidity.getReading();
        return new Log(name, tempValue, carbonValue, umidityValue);
    }

    /**
     * @see Zone#generateLogs()
     * @return um novo log gerado pelo metodo generateLogs();
     */
    public Log getLog() {
        Log newLog =  generateLogs();
        return newLog;
    }

    public String getName() {
        return name;
    }

    public Type<Integer> getUmidity() {
        return umidity.getReading();
    }

    public Type<Double> getCarbon() {
        return carbon.getReading();
    }

    public Type<Double> getTemperature() {
        return temperature.getReading();
    }

    /**
     * Atualiza o nome da zona, atualizando os respectivos sensores.
     * @param name Novo nome do local
     */
    public void setName(String name) {
        this.name = name;

        carbon.setName(name);
        carbon.setLocal(name);

        temperature.setName(name);
        temperature.setLocal(name);

        umidity.setName(name);
        umidity.setLocal(name);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Zone)) return false;
        Zone temp = (Zone) obj;
        if(temp.name == this.name) return true;
        return super.equals(obj);
    }
}
