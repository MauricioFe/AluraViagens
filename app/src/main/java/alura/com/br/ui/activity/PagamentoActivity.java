package alura.com.br.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

import alura.com.br.R;
import alura.com.br.model.Pacote;
import alura.com.br.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITLEAPPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITLEAPPBAR);

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2,
                new BigDecimal("243.99"));
        mostraPreco(pacote);
        Button btnFinalizaCompra= findViewById(R.id.pagamento_botao_finaliza_compra);
        btnFinalizaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                startActivity(intent);
            }
        });
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco);
        String moedaBR = MoedaUtil.formaMoeda(pacote.getPreco());
        preco.setText(moedaBR);
    }
}
