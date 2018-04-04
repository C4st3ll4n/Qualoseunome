package castellan.com.qualoseunome;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nome;
    TextView nume;
    private static final String ARQ_PREF = "ArquivoPreferencia";
    SharedPreferences sp;
    SharedPreferences.Editor spe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.etNome);
        nume = findViewById(R.id.textView3);
        sp = getSharedPreferences(ARQ_PREF,0);
        spe = sp.edit();
        if (sp.contains("nome")){
            String name = sp.getString("nome","USER");
            nume.setText(name);
        }else{
            Toast.makeText(this, "Vazio", Toast.LENGTH_SHORT).show();
        }
    }

    public void Click(View e){
        if (nome.getText().toString().isEmpty()){
            Toast.makeText(this, "Campo nome VAZIO\nPreencha esse campo", Toast.LENGTH_SHORT).show();
        }else {
            spe.putString("nome",nome.getText().toString()).apply();
            nume.setText(nome.getText().toString());
        }

    }
}
