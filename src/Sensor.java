import java.util.Random;

/** 
 * A classe sensor tenta imitar um sensor fisico, tendo em seu contexto
 * Nome, local, seu tipo e sua unidade de medida.
 * Os valores gerados por ela são aleatórios.
 * @author Lucas Matheus Nunes Pereira
*/
public class Sensor <T> {
    protected static Random random = new Random();
    protected String local, name, type, unity;

    /**
     * @see Type
     */
    protected Type<T> reading;
    
    /**
     * @see Sensor
     * @param name nome do sensor
     * @param local local onde está instalada
     * @param type o que esse sensor lê
     * @param unity unidade de medida
     */
    public Sensor(String name, String local,  String type, String unity) {
        this.local = local;
        this.name = name;
        this.type = type;
        this.unity = unity;
    }

    public Type<T> getReading() {
        return reading;
    }

    public String getLocal() {
        return local;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getUnity() {
        return unity;
    }

    public void setName(String name) {
        this.name = name + " " + type;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
       return reading.toString();
    }
}
