package com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.quartafeira;

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
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.tercafeira.activity_tercafeira_rotina_tarde;
import com.feirafucapi.aplicaofucapi0911.activities.adapter.AdaptadorRotina;
import com.feirafucapi.aplicaofucapi0911.activities.model.Rotina;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class activity_quartafeira_rotina_noite extends AppCompatActivity {

    private MaterialButton mbToTarde;
    private RecyclerView recyclerViewQN;
    private List<Rotina> listaRotinasQN = new ArrayList<>();
    private ImageButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quartafeira_rotina_noite);

        recyclerViewQN = findViewById(R.id.recyclerViewRotinaQN);
        mbToTarde = findViewById(R.id.materialButtonNtoTardeQuarta);
        btnVoltar = findViewById(R.id.ibVoltarTR);

        AdaptadorRotina adaptador = new AdaptadorRotina(listaRotinasQN);

        // RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewQN.setLayoutManager(layoutManager);
        recyclerViewQN.setHasFixedSize(true);
        recyclerViewQN.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerViewQN.setAdapter(adaptador);

        mbToTarde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_quartafeira_rotina_tarde.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
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
        rotina.setHorarioRotina("02:55");
        rotina.setRotina1(R.mipmap.ic_escova_foreground);
        rotina.setRotina2(R.mipmap.ic_carteirinha_foreground);
        rotina.setRotina3(R.drawable.ic_back_foreground);
        this.listaRotinasQN.add(rotina);

        Rotina rotina1 = new Rotina();
        rotina1.setHorarioRotina("04:55");
        rotina1.setRotina1(R.mipmap.ic_escova_foreground);
        rotina1.setRotina2(R.mipmap.ic_carteirinha_foreground);
        rotina1.setRotina3(R.drawable.ic_launcher_foreground);

        this.listaRotinasQN.add(rotina1);

        Rotina rotina2 = new Rotina();
        rotina2.setHorarioRotina("15:45");
        this.listaRotinasQN.add(rotina2);

        Rotina rotina3 = new Rotina();
        rotina3.setHorarioRotina("22:30");
        this.listaRotinasQN.add(rotina3);


    }
}