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
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.segundafeira.activity_segundafeira_rotina_tarde;
import com.feirafucapi.aplicaofucapi0911.activities.adapter.AdaptadorRotina;
import com.feirafucapi.aplicaofucapi0911.activities.model.Rotina;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class activity_quartafeira_rotina_manha extends AppCompatActivity {

    private ImageButton btnVoltar;
    private RecyclerView recyclerViewQM;
    private List<Rotina> listaRotinasQM = new ArrayList<>();
    private MaterialButton mbtoTarde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quartafeira_rotina_manha);

        recyclerViewQM = findViewById(R.id.recyclerViewRotinaQM);
        mbtoTarde = findViewById(R.id.materialButtonNtoTardeQUARTA);

        AdaptadorRotina adaptador = new AdaptadorRotina(listaRotinasQM);

        // RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewQM.setLayoutManager(layoutManager);
        recyclerViewQM.setHasFixedSize(true);
        recyclerViewQM.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerViewQM.setAdapter(adaptador);

        btnVoltar = findViewById(R.id.ibVoltarSR);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_rotina.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        mbtoTarde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_quartafeira_rotina_tarde.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
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
        rotina.setHorarioRotina("06:15");
        rotina.setRotina1(R.mipmap.ic_escova_foreground);
        rotina.setRotina2(R.mipmap.ic_carteirinha_foreground);
        rotina.setRotina3(R.drawable.ic_back_foreground);
        this.listaRotinasQM.add(rotina);

        Rotina rotina1 = new Rotina();
        rotina1.setHorarioRotina("08:45");
        rotina1.setRotina1(R.mipmap.ic_escova_foreground);
        rotina1.setRotina2(R.mipmap.ic_carteirinha_foreground);
        rotina1.setRotina3(R.drawable.ic_launcher_foreground);

        this.listaRotinasQM.add(rotina1);

        Rotina rotina2 = new Rotina();
        rotina2.setHorarioRotina("16:50");
        this.listaRotinasQM.add(rotina2);

        Rotina rotina3 = new Rotina();
        rotina3.setHorarioRotina("20:10");
        this.listaRotinasQM.add(rotina3);


    }
}