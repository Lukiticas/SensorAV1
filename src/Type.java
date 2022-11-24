/** 
* Uma classe para organizar e formatar os valores dos sensores:
* Exemlo: "Valor Unidade" = 23°C;
* @author Lucas Matheus Nunes Pereira
*/
public class Type <T> {
    private T value;
    private String unity;

    /**
     * @param value valor gerado pelo sensor
     * @param unity unidade de medida do sensor
     */
    public Type(T value, String unity) {
        this.value = value;
        this.unity = unity;
    }

    public String getUnity() {
        return unity;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    @Override
    public String toString() {
        if(value instanceof Integer) 
            return value + unity;
        
        return String.format("%.2f", value) + unity;
    }
}
