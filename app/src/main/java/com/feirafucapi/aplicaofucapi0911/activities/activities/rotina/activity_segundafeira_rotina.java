package com.feirafucapi.aplicaofucapi0911.activities.activities.rotina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.feirafucapi.aplicaofucapi0911.R;

public class activity_segundafeira_rotina extends AppCompatActivity {

    private ImageButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundafeira_rotina);

        btnVoltar = findViewById(R.id.ibVoltarSR);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_rotina.class);
                startActivity(intent);
            }
        });
    }
}