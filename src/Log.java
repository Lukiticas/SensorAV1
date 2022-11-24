import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A classe log se comporta como se fosse uma "ficha", ela guarda os valores que um sensor 
 * em um determinado momento.
 * É uma alternativa ao exercicio onde se pede para usar um array com os elements:
 * [temperatura, nivel de gás carbonico, umidade]
 * por que ficaria muito repetitivo é dificil de se organizar.
 * 
 * ele também é util pois utiliza da biblioteca Date e DateFormat para gerar 
 * Datas bonitas e formatadas no terminal <3
 * 
 * @author Lucas Matheus Nunes Pereira
*/
public class Log {
    private String local;
    private Type<Double> temperature, carbonLevels;
    private Type<Integer> umitity;
    final private Date date;
    
    String pattern = "dd/MM/yyyy, HH:mm:ss";
    SimpleDateFormat sDF = new SimpleDateFormat(pattern);
    
    /**
     * @param local local onde se foi tirado o log
     * @param temperature temperatura registrada
     * @param carbonLevels nivel de carbono registrado
     * @param umitity umidade registrada
     * 
     * @see Type
     * @see Sensor  
     * @see Log
     */
    public Log(String local, Type<Double> temperature, Type<Double> carbonLevels, Type<Integer> umitity) {
        this.local = local;
        this.temperature = temperature;
        this.carbonLevels = carbonLevels;
        this.umitity = umitity;
        date = new Date();
    }

    public Type<Integer> getUmitity() {
        return umitity;
    }

    public Type<Double> getCarbonLevels() {
        return carbonLevels;
    }

    public Type<Double> getTemperature() {
        return temperature;
    }

    public Date getDate() {
        return date;
    }

    public String getFormatedDate() {
        return sDF.format(date);
    }

    public String getLocal() {
        return local;
    }
    
    /**
     * @see java.lang.Object#toString()
     * @returns String "local | temperature | carbonLevels | umidity | dateFormat"
     */
    @Override
    public String toString() {
        return local 
        + " - " + 
        temperature
        + " - " + 
        carbonLevels
        + " - " + 
        umitity 
        + " - " + 
        this.getFormatedDate();
    }
}
