package com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.tercafeira;

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
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.activity_crudrotina;
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.activity_rotina;
import com.feirafucapi.aplicaofucapi0911.activities.adapter.AdaptadorRotina;
import com.feirafucapi.aplicaofucapi0911.activities.model.Rotina;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class activity_tercafeira_rotina_manha extends AppCompatActivity {

    private RecyclerView recyclerViewTM;
    private List<Rotina> listaRotinasTM = new ArrayList<>();
    private ImageButton btnVoltar;
    private FloatingActionButton fabEditarAdicionar, fabTardeRotina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercafeira_rotina_manha);

        recyclerViewTM = findViewById(R.id.recyclerViewRotinaTM);
        btnVoltar = findViewById(R.id.ibVoltarTR);
        fabEditarAdicionar = findViewById(R.id.floatingActionButtonAdd);
        fabTardeRotina = findViewById(R.id.fabTardeTerca);


        AdaptadorRotina adaptador = new AdaptadorRotina(listaRotinasTM);

        // RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewTM.setLayoutManager(layoutManager);
        recyclerViewTM.setHasFixedSize(true);
        recyclerViewTM.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerViewTM.setAdapter(adaptador);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_rotina.class);
                startActivity(intent);
            }
        });

        fabEditarAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implemente a lógica para edição/adicionar aqui
                // Você pode abrir uma nova atividade de edição ou um diálogo para isso
                // Por exemplo, para adicionar um novo item:
                Intent intent = new Intent(getApplicationContext(), activity_crudrotina.class);
                startActivity(intent);
            }
        });

        fabTardeRotina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_tercafeira_rotina_tarde.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
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
        rotina.setHorarioRotina("09:15");
        rotina.setRotina1(R.mipmap.ic_escova_foreground);
        rotina.setRotina2(R.mipmap.ic_carteirinha_foreground);
        rotina.setRotina3(R.drawable.ic_back_foreground);
        this.listaRotinasTM.add(rotina);

        Rotina rotina1 = new Rotina();
        rotina1.setHorarioRotina("12:15");
        rotina1.setRotina1(R.mipmap.ic_escova_foreground);
        rotina1.setRotina2(R.mipmap.ic_carteirinha_foreground);
        rotina1.setRotina3(R.drawable.ic_launcher_foreground);

        this.listaRotinasTM.add(rotina1);

        Rotina rotina2 = new Rotina();
        rotina2.setHorarioRotina("14:45");
        this.listaRotinasTM.add(rotina2);

        Rotina rotina3 = new Rotina();
        rotina3.setHorarioRotina("16:30");
        this.listaRotinasTM.add(rotina3);


    }
}