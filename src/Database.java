/**
 * No enunciado pede que as leituras sejam guardadas numa especie de banco de dados para posterior uso.
 * Essa classe busca emular esse comportamento.
 * Guarda os logs gerados pelas zonas e possui metodos para sortear, imprimir e adicionar mais logs.
 * O tamanho já vem predefinido como 48, assim como no enunciado, mas dá para mudar.
 * O metodo de sorteamento usado é bubble sort.
 * Usei algumas bibliotecas para estilizar a saida no terminal: Formatter.
 * 
 * @author Lucas Matheus Nunes Pereira
 * @see java.util.Formatter
 * @see Zone
 * @see Log
*/
public class Database {
    /** 
     * O valor máximo da database. 
     * Esse valor é ligado ao fato de que, a database recebe os logs de 30 em 30 minutos, logo, para manter a consistencia
     * de 1 dia, a database deveria resetar a cada 24 horas, então, Log a cada 30 minutos, 48 logs ao dia.
    */
    private final int MAX_SIZE;
    private String typeOrder;
    private boolean order;
    private Log[] databaseLogs;

    /** O index, um tipo de pointeiro usado para organizar e adicionar itens no array estático */
    private int INDEX;

    /**
     * O construtor gera uma nova database
     * o tamanho dela usa a consante MAX_SIZE
     */
    public Database() {
        this.MAX_SIZE = 48;
        this.INDEX = 0;
        this.typeOrder = "temperature";
        this.order = false;
        databaseLogs = new Log[MAX_SIZE];
    }

    /**
     * Adiciona um novo log a database.
     * O log é adicionado ao próximo valor da database indicado pelo INDEX
     * 
     * Ele também checa o tamanho do array indicado pelo INDEX, caso for maior ele reinicia o pointeiro
     * Adicionando o item no começo do array, tecnicamente resetando a databse também.
     * 
     * @param log um novo log a ser adicionado
     */
    public void addLog(Log log) {
        if(INDEX >= MAX_SIZE ) {
            this.databaseLogs = new Log[MAX_SIZE];
            INDEX = 0;
        };

        databaseLogs[INDEX] = log;
        INDEX++;

        orderBy(typeOrder, this.order);
    }

    /**
     * Overload para adicionar varios logs ao mesmo tempo
     * @param logs lista de logs (log1, log2, log3...)
     */
    public void addLog(Log ...logs){
        if(INDEX >= MAX_SIZE ) {
            this.databaseLogs = new Log[MAX_SIZE];
            INDEX = 0;  
        };

        for(int i = 0; i < logs.length; i++){
            databaseLogs[INDEX] = logs[i];
            INDEX++;
        }

        orderBy(typeOrder, this.order);
    }

    /**
     * instancia e chama o formatTable,
     * imprimindo todos os valores do database no terminal
     * @see FormatTable
     */
    public void generateTable() {
        this.orderBy(typeOrder, this.order);
        FormatTable table = new FormatTable(databaseLogs, INDEX);
        System.out.println(table.generateTable());
    }

    /**
     * Configura o tipo de organização que a database irá usar:
     * @param type categoria a ser sorteada, 
     * deve estar dentro de 'temperature', "carbon level", "umidity" e "date"
     * @param order booleano para indicar a ordem de true = ascendente e false = descendente;
     */ 
    public void setSortOrder(String type, boolean order) {
        this.typeOrder = type;
        this.order = order;
        orderBy(typeOrder, this.order);
    }

    /**
     * Ordena o database usando o metodo bubble sort, por categoria e ordem.
     * @param type categoria a ser sorteada, 
     * deve estar dentro de 'temperature', "carbon level", "umidity" e "date"
     * @param order booleano para indicar a ordem de true = ascendente e false = descendente;
     */
    public void orderBy(String type, boolean order) {
         switch (type) {
            case "temperature":
                orderByTemperature(order);
                break;
            case "carbon level":
                orderByCarbonLevel(order);
                break;
            case "umidity":
                orderByUmidity(order);
                break;
            case "date":
                orderByDate(order);
                break;
            default:
               orderByTemperature(order);
         }
    }

    public void orderByCarbonLevel(boolean order) {
        int n = INDEX;  
        Log temp;  
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){  

                boolean ascOrDesc = order ? 
                databaseLogs[j-1].getCarbonLevels().getValue() > databaseLogs[j].getCarbonLevels().getValue() : 
                databaseLogs[j-1].getCarbonLevels().getValue() < databaseLogs[j].getCarbonLevels().getValue();

                if(ascOrDesc){  
                    temp = databaseLogs[j-1];  
                    databaseLogs[j-1] = databaseLogs[j];  
                    databaseLogs[j] = temp;  
                }  
            }
        }    
    }

    public void orderByTemperature(boolean order) {
        int n = INDEX;  
        Log temp;  
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){  
                boolean ascOrDesc = order ? 
                databaseLogs[j-1].getTemperature().getValue() > databaseLogs[j].getTemperature().getValue() : 
                databaseLogs[j-1].getTemperature().getValue() < databaseLogs[j].getTemperature().getValue();

                if(ascOrDesc){  
                    temp = databaseLogs[j-1];  
                    databaseLogs[j-1] = databaseLogs[j];  
                    databaseLogs[j] = temp;  
                } 
            }  
        }  
    }

    public void orderByUmidity(boolean order) {
        int n = INDEX;  
        Log temp;  
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){  
                boolean ascOrDesc = order ? 
                databaseLogs[j-1].getUmitity().getValue() > databaseLogs[j].getUmitity().getValue() : 
                databaseLogs[j-1].getUmitity().getValue() < databaseLogs[j].getUmitity().getValue();

                if(ascOrDesc){  
                    temp = databaseLogs[j-1];  
                    databaseLogs[j-1] = databaseLogs[j];  
                    databaseLogs[j] = temp;  
                }
            }  
        }  
    }

    public void orderByDate(boolean order) {
        int n = INDEX;  
        Log temp;  
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){  

                boolean ascOrDesc = order ? 
                databaseLogs[j-1].getDate().before(databaseLogs[j].getDate()) : 
                databaseLogs[j-1].getDate().after(databaseLogs[j].getDate());

                if(ascOrDesc){  
                    temp = databaseLogs[j-1];  
                    databaseLogs[j-1] = databaseLogs[j];  
                    databaseLogs[j] = temp;  
                }  
            }
        }    
    }

    public Log[] getDatabaseLogs() {
        return databaseLogs;
    }

    public int getSize() {
        return INDEX;
    }

    @Override
    public String toString() {
        return databaseLogs.toString();
    }
}
