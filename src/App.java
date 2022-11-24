public class App {
    public static void main(String[] args) {
        Zone floresta = new Zone("Floresta");
        Database database = new Database();

        for(int i = 0; i < 48; i++) {
            Log logFloresta  = floresta.getLog();
            database.addLog(logFloresta);
        }

        database.orderBy("carbon level", true);
        database.generateTable();
    }
}