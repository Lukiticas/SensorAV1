import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/** 
 * <p>
 * Essa classe existe por utilidade e funcionalidade.
 * No enunciado é dito que há varias zonas, e é requirido que seja gerado logs de cada uma, isso a cada 30 minutos.
 * </p>
 * 
 * <ul>
 * <li>Na classe foi criada um arraylist chamado zones onde deve ficar as possiveis zonas da aplicação.</li>
 * <li>Você pode adicionar, recuperar, limpar e remover zonas.</li>
 * <li>Há metodos para criar a rotina, que vai gerar os logs, adicionar ao banco de dados e imprimir no terminal, a cada 30 minutos.</li>
 * </ul>
 * 
 * <h4>
 * Essa classe engloba os conceitos do enunciado em algo abstrato e de facil uso.
 * </h4>
 * 
 * @author Lucas Matheus Nunes Pereira
 * @see Sensor
 * @see Zones
 * @see Database
 * @see Log
*/
public class Controller {
    /** milissegundos padrões = 30 minutos */
    private final int THIRTY_MINUTES = 1800000;

    ArrayList<Zone> zones = new ArrayList<>();
    private Timer timer;
    private Database db; 
    private int scheduleInterval;

    public Controller() {
        this.timer = new Timer();
        this.db = new Database();
        this.scheduleInterval = THIRTY_MINUTES;
    }

    /**
     * Adiciona uma nova zona ao controlador.
     * @param name nome da nova zona
     */
    public void subscribeZone(String name) {
        zones.add(new Zone(name));
    }

    /**
     * Retorna uma zona especifica da lista, caso não tenha tal zona com aquele nome, irá jogar um erro.
     * @param name nome da zona
     * @return Zone
     */
    public Zone getZone(String name) {
        return zones.get(zones.indexOf(new Zone(name)));
    }

    public void clearZones() {
        zones.clear();
    }

    /**
     * Gera os relatórios de uma zona especfica a cada 30 minutos.
     * Caso a zona não exista, vai lançar um erro.
     * @param name nome da zona
     */
    public void getRelatoryFromZone(String name) {
        Zone currentZone = zones.get(zones.indexOf(new Zone(name)));
        scheduleTaskOnZone(currentZone);
    }

    /**
     * Pega os Log de uma zona e adiciona ao db da aplicação
     * @param zone Zona a ser usada
     */
    private void callLogsAndRegisterInDatabase(Zone zone) {
        Log log = zone.getLog();
        db.addLog(log);  
    }

    /**
     * Inicia uma nova rotina schedule do pacote timer que se repete a cada intervalo de tempo.
     * @param zone Zona a ser monitorada
     * @see Zone
     * @see Timer
     */
    public void scheduleTaskOnZone(Zone zone) {
        timer.schedule(new getLogsTask(zone), 0, scheduleInterval);
    }

    public void stopTask() {
        this.timer.cancel();
    }


    /**
     * @param type tipo de ordenação da database
     * @param order ordem da database
     */
    public void orderBy(String type, boolean order) {
        db.setSortOrder(type, order);
    }
    /**
     * Exntesão da classe TimerTask, cria uma rotina entre chamar callLogsAndRegisterInDatabase
     * e gerar a table que será imprimida no terminal.
     * @see Controller#scheduleTaskOnZone(Zone)
     * @see Controller#callLogsAndRegisterInDatabase(Zone)
     * @see Database#generateTable()
     */
    class getLogsTask extends TimerTask {
        Zone currentZone;
        public getLogsTask(Zone zone) {
            currentZone = zone;
        }

        public void run() {
            callLogsAndRegisterInDatabase(currentZone);
            db.generateTable();
        }
   }

   public void setScheduleInterval(int scheduleInterval) {
       this.scheduleInterval = scheduleInterval;
   }

   public Database getDb() {
       return db;
   }

   public int getScheduleInterval() {
       return scheduleInterval;
   }

   public Timer getTimer() {
       return timer;
   }

   public ArrayList<Zone> getZones() {
       return zones;
   }

   @Override
   public String toString() {
       return zones.toString();
   }
    
}
