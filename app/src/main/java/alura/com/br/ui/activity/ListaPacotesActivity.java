package alura.com.br.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import alura.com.br.Dao.PacoteDAO;
import alura.com.br.R;
import alura.com.br.model.Pacote;
import alura.com.br.ui.adapter.ListaPacotesAdapter;

import static alura.com.br.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APPBAR);
        configuraLista();
    }

    private void configuraLista() {
        final ListView listaPacote = findViewById(R.id.lista_pacotes_listView);
        final List<Pacote> pacotes = new PacoteDAO().Lista();
        listaPacote.setAdapter(new ListaPacotesAdapter(pacotes, this));

        listaPacote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pacote pacoteClicado = pacotes.get(position);
                retViewResumoPacote(pacoteClicado);
            }
        });
    }

    private void retViewResumoPacote(Pacote pacoteClicado) {
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteClicado);
        startActivity(intent);
    }
}
