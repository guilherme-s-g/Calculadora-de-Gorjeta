package com.example.calculadoradegorjetaprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity
{
    private TextInputEditText textInputValor;
    private SeekBar seekBarPorcetagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private TextView textPorcetagem;
    private double valorProcetagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInputValor = findViewById(R.id.textInputValor);
        seekBarPorcetagem = findViewById(R.id.seekBarPorcetagem);
        textGorjeta = findViewById(R.id.textGorjeta);
        textTotal = findViewById(R.id.textTotal);
        textPorcetagem = findViewById(R.id.textPorcetagem);

        seekBarPorcetagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int procetagem, boolean b)
            {
                valorProcetagem = procetagem;
                textPorcetagem.setText(valorProcetagem + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
            }
        });
    }

    public void calcular()
    {
        String valorDigitado = textInputValor.getText().toString();
        if( valorDigitado == null || valorDigitado.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Digite um valor primeiro!",Toast.LENGTH_LONG).show();
        }
        else
        {
            double valorDigitadoDouble = Double.parseDouble(valorDigitado);
            double gorjeta = valorDigitadoDouble * (valorProcetagem/100);
            double total = gorjeta + valorDigitadoDouble;
            textGorjeta.setText("R$ " + gorjeta);
            textTotal.setText("R$ " + total);
        }
    }

}