package alura.com.br.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {
    public static String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();      //Classe calendar para utilização de datas, o metodo getInstace pega a data atual.
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM"); //Classe para formatação de data
        String dataFormatadaIda = formatoBr.format(dataIda.getTime());
        String dataFormatadaVolta = formatoBr.format(dataVolta.getTime());
        return dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dataVolta.get(Calendar.YEAR);
    }
}
