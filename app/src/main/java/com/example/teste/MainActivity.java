package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     private Button btnAdicionar;
     private EditText editTextNome;
     private TextView tvNomeRecebido;

    private TextView txtMensagem;
    private Button btnIr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdicionar = findViewById(R.id.buttonEnviar);
        editTextNome = findViewById(R.id.editTextNome);
        tvNomeRecebido = findViewById(R.id.textViewNomeRecebido);
        txtMensagem = findViewById(R.id.textMensagem);
        btnIr = findViewById(R.id.buttonIr);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //verifica se o campo esta vazio
                if(TextUtils.isEmpty(editTextNome.getText().toString())){
                    txtMensagem.setText(R.string.campo_obrigatorio);
                }else{
                    txtMensagem.setText("");
                    tvNomeRecebido.setText(editTextNome.getText());
                    editTextNome.setText("");
                }


             }

        });

        btnIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentIndex = new Intent(MainActivity.this, IndexActivity.class);
                startActivity(intentIndex);
            }
        });


    }




}
