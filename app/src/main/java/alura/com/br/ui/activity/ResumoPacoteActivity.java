package alura.com.br.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import alura.com.br.R;
import alura.com.br.model.Pacote;
import alura.com.br.util.DataUtil;
import alura.com.br.util.DiasUtil;
import alura.com.br.util.MoedaUtil;
import alura.com.br.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITLEAPPBAR = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITLEAPPBAR);

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2,
                new BigDecimal("243.99"));
        mostrarLocal(pacote);
        mostraImagem(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);

        Intent intent = new Intent(this, PagamentoActivity.class);
        startActivity(intent);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaViagem);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBr= MoedaUtil.formaMoeda(pacote.getPreco());
        preco.setText(moedaBr);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasTexto = DiasUtil.getDiasTexto(pacote.getDias());
        dias.setText(diasTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawable = ResourceUtil.getDrawable(pacote.getImagem(), this);
        imagem.setImageDrawable(drawable);
    }

    private void mostrarLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}
