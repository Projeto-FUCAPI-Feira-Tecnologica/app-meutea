package com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.sextafeira;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.feirafucapi.aplicaofucapi0911.R;
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.activity_rotina;
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.quintafeira.activity_quintafeira_rotina_manha;
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.quintafeira.activity_quintafeira_rotina_noite;
import com.feirafucapi.aplicaofucapi0911.activities.adapter.AdaptadorRotina;
import com.feirafucapi.aplicaofucapi0911.activities.model.Rotina;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class activity_sextafeira_rotina_tarde extends AppCompatActivity {

    private MaterialButton mbToManha, mbToNoite;
    private RecyclerView recyclerViewSEX;
    private List<Rotina> listaRotinasSEX = new ArrayList<>();
    private ImageButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sextafeira_rotina_tarde);

        recyclerViewSEX = findViewById(R.id.recyclerViewRotinaSEXT);
        btnVoltar = findViewById(R.id.ibVoltarTR);

        AdaptadorRotina adaptador = new AdaptadorRotina(listaRotinasSEX);

        // RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewSEX.setLayoutManager(layoutManager);
        recyclerViewSEX.setHasFixedSize(true);
        recyclerViewSEX.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerViewSEX.setAdapter(adaptador);


        mbToManha = findViewById(R.id.materialButtonTtoManhaSexta);
        mbToNoite = findViewById(R.id.materialButtonTtoNoiteSexta);
        btnVoltar = findViewById(R.id.ibVoltarTR);

        mbToManha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_sextafeira_rotina_manha.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                finish();
            }
        });

        mbToNoite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_sextafeira_rotina_noite.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                finish();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_rotina.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        criarRotinas();
        super.onStart();
    }

    public void criarRotinas(){ // Parte que será adicionada do banco de dados
        Rotina rotina = new Rotina();
        rotina.setHorarioRotina("05:45");
        rotina.setRotina1(R.mipmap.ic_escova_foreground);
        rotina.setRotina2(R.mipmap.ic_carteirinha_foreground);
        rotina.setRotina3(R.drawable.ic_back_foreground);
        this.listaRotinasSEX.add(rotina);

        Rotina rotina1 = new Rotina();
        rotina1.setHorarioRotina("09:00");
        rotina1.setRotina1(R.mipmap.ic_escova_foreground);
        rotina1.setRotina2(R.mipmap.ic_carteirinha_foreground);
        rotina1.setRotina3(R.drawable.ic_launcher_foreground);

        this.listaRotinasSEX.add(rotina1);

        Rotina rotina2 = new Rotina();
        rotina2.setHorarioRotina("15:45");
        this.listaRotinasSEX.add(rotina2);

        Rotina rotina3 = new Rotina();
        rotina3.setHorarioRotina("22:30");
        this.listaRotinasSEX.add(rotina3);
    }
}