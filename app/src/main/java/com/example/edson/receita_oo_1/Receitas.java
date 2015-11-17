package com.example.edson.receita_oo_1;

import java.io.Serializable;

/**
 * Created by Edson on 12/11/2015.
 */
public class Receitas implements Serializable{
    private String nomeReceita;
    private String item1;
    private String item2;
    private String item3;
    private String modoPreparo;

    public Receitas(String s, String s1, String s2, String s3, String s4) {

        setNomeReceita(s);
        setItem1(s1);
        setItem2(s2);
        setItem3(s3);
        setModoPreparo(s4);
    }


    public String getNomeReceita() {
        return nomeReceita;
    }

    public void setNomeReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public String getItem3() {
        return item3;
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }


}

