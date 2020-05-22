package alura.com.br.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import alura.com.br.R;
import alura.com.br.model.Pacote;
import alura.com.br.util.DataUtil;
import alura.com.br.util.MoedaUtil;
import alura.com.br.util.ResourceUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITLEAPPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITLEAPPBAR);
        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2,
                new BigDecimal("243.99"));
        mostrarLocal(pacote);
        mostrarImagem(pacote);
        mostrarData(pacote);
        mostrarPreco(pacote);
    }

    private void mostrarPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco);
        String moedaBR = MoedaUtil.formaMoeda(pacote.getPreco());
        preco.setText(moedaBR);
    }

    private void mostrarData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data);
        String periodoEmTexto = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(periodoEmTexto);
    }

    private void mostrarImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imgem_pacote);
        Drawable drawable = ResourceUtil.getDrawable(pacote.getImagem(), this);
        imagem.setImageDrawable(drawable);
    }

    private void mostrarLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local);
        local.setText((pacote.getLocal()));
    }
}
