package com.feirafucapi.aplicaofucapi0911.activities.model;

import android.widget.ImageView;

import java.io.Serializable;

public class Rotina implements Serializable {

    private Long id;
    private String horarioRotina;
    private int rotina1, rotina2, rotina3;

    public Rotina() {
    }

    public Rotina(String horarioRotina, int rotina1, int rotina2, int rotina3) {
        this.horarioRotina = horarioRotina;
        this.rotina1 = rotina1;
        this.rotina2 = rotina2;
        this.rotina3 = rotina3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHorarioRotina() {
        return horarioRotina;
    }

    public void setHorarioRotina(String horarioRotina) {
        this.horarioRotina = horarioRotina;
    }

    public int getRotina1() {
        return rotina1;
    }

    public void setRotina1(int rotina1) {
        this.rotina1 = rotina1;
    }

    public int getRotina2() {
        return rotina2;
    }

    public void setRotina2(int rotina2) {
        this.rotina2 = rotina2;
    }

    public int getRotina3() {
        return rotina3;
    }

    public void setRotina3(int rotina3) {
        this.rotina3 = rotina3;
    }
}

