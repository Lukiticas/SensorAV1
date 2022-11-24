import java.util.Formatter;

/**
 * Esse classe existe para organizar e abstrair a impressão de dados do database no terminal.
 * 
 * @see java.util.Formatter
 * @see Database
 * @see Zone
 * @see Log
 * 
 * @author Lucas Matheus Nunes Pereira
*/
public class FormatTable {
    private Log[] source;
    private int limit;
    private String pattern;
    Formatter fmt;

    public FormatTable(Log[] source, int limit) {
        this.source = source;
        this.limit = limit;
        this.pattern = "%-15s %-15s %-10s %-15s %-20s\n";
        this.fmt = new Formatter(); 
    }   
    
    public Formatter generateTable() {
        fmt.format(pattern,"Local", "Temperature", "Umidity", "carbon levels", "date");

        for(int i = 0; i < limit; i++) {
            fmt.format(pattern, source[i].getLocal(),
                                       source[i].getTemperature(),
                                       source[i].getUmitity(),
                                       source[i].getCarbonLevels(),
                                       source[i].getFormatedDate());
        };
                
        return fmt;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Log[] getSource() {
        return source;
    }

    public void setSource(Log[] source) {
        this.source = source;
    }
}
