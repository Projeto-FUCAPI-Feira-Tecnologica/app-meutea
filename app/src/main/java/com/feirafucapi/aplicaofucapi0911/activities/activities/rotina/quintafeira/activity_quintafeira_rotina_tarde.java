package com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.quintafeira;

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
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.quartafeira.activity_quartafeira_rotina_manha;
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.quartafeira.activity_quartafeira_rotina_noite;
import com.feirafucapi.aplicaofucapi0911.activities.adapter.AdaptadorRotina;
import com.feirafucapi.aplicaofucapi0911.activities.model.Rotina;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class activity_quintafeira_rotina_tarde extends AppCompatActivity {

    private MaterialButton mbToManha, mbToNoite;
    private RecyclerView recyclerViewQIT;
    private List<Rotina> listaRotinasQIT = new ArrayList<>();
    private ImageButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quintafeira_rotina_tarde);

        recyclerViewQIT = findViewById(R.id.recyclerViewRotinaQIT);
        btnVoltar = findViewById(R.id.ibVoltarTR);

        AdaptadorRotina adaptador = new AdaptadorRotina(listaRotinasQIT);

        // RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewQIT.setLayoutManager(layoutManager);
        recyclerViewQIT.setHasFixedSize(true);
        recyclerViewQIT.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerViewQIT.setAdapter(adaptador);


        mbToManha = findViewById(R.id.materialButtonTtoManhaQuinta);
        mbToNoite = findViewById(R.id.materialButtonTtoNoiteQuinta);
        btnVoltar = findViewById(R.id.ibVoltarTR);

        mbToManha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_quintafeira_rotina_manha.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                finish();
            }
        });

        mbToNoite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_quintafeira_rotina_noite.class);
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
        this.listaRotinasQIT.add(rotina);

        Rotina rotina1 = new Rotina();
        rotina1.setHorarioRotina("09:00");
        rotina1.setRotina1(R.mipmap.ic_escova_foreground);
        rotina1.setRotina2(R.mipmap.ic_carteirinha_foreground);
        rotina1.setRotina3(R.drawable.ic_launcher_foreground);

        this.listaRotinasQIT.add(rotina1);

        Rotina rotina2 = new Rotina();
        rotina2.setHorarioRotina("15:45");
        this.listaRotinasQIT.add(rotina2);

        Rotina rotina3 = new Rotina();
        rotina3.setHorarioRotina("22:30");
        this.listaRotinasQIT.add(rotina3);
    }
}