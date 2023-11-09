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
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.activity_rotina;
import com.feirafucapi.aplicaofucapi0911.activities.adapter.AdaptadorRotina;
import com.feirafucapi.aplicaofucapi0911.activities.model.Rotina;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class activity_tercafeira_rotina_noite extends AppCompatActivity {

    private MaterialButton mbToTarde;
    private RecyclerView recyclerViewTN;
    private List<Rotina> listaRotinasTN = new ArrayList<>();
    private ImageButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercafeira_rotina_noite);

        recyclerViewTN = findViewById(R.id.recyclerViewRotinaTN);
        mbToTarde = findViewById(R.id.materialButtonNtoTarde);
        btnVoltar = findViewById(R.id.ibVoltarTR);

        AdaptadorRotina adaptador = new AdaptadorRotina(listaRotinasTN);

        // RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewTN.setLayoutManager(layoutManager);
        recyclerViewTN.setHasFixedSize(true);
        recyclerViewTN.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerViewTN.setAdapter(adaptador);

        mbToTarde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_tercafeira_rotina_tarde.class);
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
        this.listaRotinasTN.add(rotina);

        Rotina rotina1 = new Rotina();
        rotina1.setHorarioRotina("04:55");
        rotina1.setRotina1(R.mipmap.ic_escova_foreground);
        rotina1.setRotina2(R.mipmap.ic_carteirinha_foreground);
        rotina1.setRotina3(R.drawable.ic_launcher_foreground);

        this.listaRotinasTN.add(rotina1);

        Rotina rotina2 = new Rotina();
        rotina2.setHorarioRotina("15:45");
        this.listaRotinasTN.add(rotina2);

        Rotina rotina3 = new Rotina();
        rotina3.setHorarioRotina("22:30");
        this.listaRotinasTN.add(rotina3);


    }
}
