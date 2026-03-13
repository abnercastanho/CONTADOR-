package com.abner.contadormobile;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //difine as variaveis globais (objetos de tela)
    private int contador = 0;
    private TextView tvContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vincula os componentes XML com Java
        tvContador = findViewById(R.id.tvContador);
        Button btnInc = findViewById(R.id.btnIcrementar);
        Button btnDec = findViewById(R.id.btnDecrementar);

        // Evento de click para Incrementar
        btnInc.setOnClickListener( v -> {
            contador++;
            atualizarInterface();


       // ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
           // Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
           // v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
          //  return insets;
        });

        // Evento de click para Decrementar
        btnDec.setOnClickListener( v -> {
            if(contador > 0) {
                contador--;
                atualizarInterface();
            }

        });
    }

    //Metodo para centralizar e atualzar a UI

    private void atualizarInterface(){
        tvContador.setText(String.valueOf(contador));

        // Regra de mudança de COR ao atingir o limite de 10
        if(contador <= 9){
            tvContador.setTextColor(Color.BLACK);
        } else if (contador >= 10 && contador < 20){
            tvContador.setTextColor(Color. BLUE);
        } else {
            tvContador.setTextColor(Color. GREEN);
        }
    }
}