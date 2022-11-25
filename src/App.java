public class App {
   public static void main(String[] args) {
        //instanciando a classe controller
        Controller controller = new Controller();

        //adicionando um ambiente
        controller.subscribeZone("Amazon");

        //definindo o intervalo de tempo para gerar o relatório
        //para fins didáticos foi definido para gerar a cada 1 segundo
        //mas o padrão é de 30 minutos
        controller.setScheduleInterval(1000);

        //ordena os registros por tipo ["temperature", "carbon level", "umidity", "date"]
        //e também ordena por ordem: false = ascendente, true = descendente
        controller.orderBy("temperature", false);

        //pede para gerar os relatórios
        controller.getRelatoryFromZone("Amazon");
    }
}