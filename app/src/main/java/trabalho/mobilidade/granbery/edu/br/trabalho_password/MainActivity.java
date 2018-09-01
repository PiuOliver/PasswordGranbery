package trabalho.mobilidade.granbery.edu.br.trabalho_password;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private PasswordGenerator generator = new PasswordGenerator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox ckb_simbolos = findViewById(R.id.ckB_simbolo);
        final CheckBox ckb_numeros = findViewById(R.id.ckB_numero);
        final CheckBox ckb_minusculos = findViewById(R.id.ckB_minusculo);
        final CheckBox ckb_maiusculos = findViewById(R.id.ckB_maiusculo);

        final EditText edtT_tamanho = findViewById(R.id.edtT_tamanho);
        final TextView txt_NewSenha = findViewById(R.id.txtv_new_senha);
        Button btnGerar = findViewById(R.id.btn_gerarSenha);

        btnGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Senha = "";
                int tamanho = Integer.parseInt(edtT_tamanho.getText().toString());

                if(ckb_simbolos.isChecked() || ckb_maiusculos.isChecked() || ckb_minusculos.isChecked() || ckb_numeros.isChecked()){
                    generator.setIncludeSymbols(ckb_simbolos.isChecked());
                    generator.setIncludeNumbers(ckb_numeros.isChecked());
                    generator.setIncludeLowerCase(ckb_minusculos.isChecked());
                    generator.setIncludeUpperCase(ckb_maiusculos.isChecked());
                    try {
                        generator.setSize(tamanho);
                        txt_NewSenha.setText(generator.generate());
                    }catch (Exception e){
                        txt_NewSenha.setText("Insira o tamnho da senha por gentileza!");
                    }
                }else{
                    txt_NewSenha.setText("Selecione Algum tipo de senha!");

                }
            }
        });
    }
}
