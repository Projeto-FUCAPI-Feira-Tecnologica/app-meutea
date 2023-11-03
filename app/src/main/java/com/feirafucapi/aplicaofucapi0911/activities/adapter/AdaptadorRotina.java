package com.feirafucapi.aplicaofucapi0911.activities.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.feirafucapi.aplicaofucapi0911.R;
import com.feirafucapi.aplicaofucapi0911.activities.model.Rotina;

import java.util.List;

public class AdaptadorRotina extends RecyclerView.Adapter<AdaptadorRotina.MyViewHolder> {

    private final List<Rotina> listaRotinass;

    public AdaptadorRotina(List<Rotina> lista) {
        this.listaRotinass = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemRotina = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_rotinas, parent, false);

        return new MyViewHolder(itemRotina);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Rotina rotina = listaRotinass.get(position);

        holder.horario.setText(rotina.getHorarioRotina());
        holder.rotina1.setImageResource(R.drawable.ic_model_recyclerview_rotina);
        holder.rotina2.setImageResource(R.drawable.ic_model_recyclerview_rotina);
    }

    @Override
    public int getItemCount() {
        return listaRotinass.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView horario;
        ImageView rotina1, rotina2, rotina3;

        public MyViewHolder(View itemView) {
            super(itemView);

            horario = itemView.findViewById(R.id.textHorario);
            rotina1 = itemView.findViewById(R.id.ivRotina1);
            rotina2 = itemView.findViewById(R.id.ivRotina2);
            rotina3 = itemView.findViewById(R.id.ivRotina3);
        }
    }
}
