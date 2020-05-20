package alura.com.br.util;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String getDiasTexto(int valor) {
        if (valor > 1) {
            return  valor + PLURAL;
        }
        return  valor + SINGULAR;

    }
}
