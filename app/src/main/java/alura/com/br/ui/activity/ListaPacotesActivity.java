package alura.com.br.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import alura.com.br.Dao.PacoteDAO;
import alura.com.br.R;
import alura.com.br.model.Pacote;
import alura.com.br.ui.adapter.ListaPacotesAdapter;

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
        ListView listaPacote = findViewById(R.id.lista_pacotes_listView);
        List<Pacote> pacotes = new PacoteDAO().Lista();
        listaPacote.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}
