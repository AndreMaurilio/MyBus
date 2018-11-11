package com.fatec.edu.mybus;

import java.io.Serializable;

public class Itinerario implements Serializable{


   private String numeroLinhas;
    private String sentido;
    private String nomeDaRua;

    private String ruas;
    private String horarioSemanal;
    private  String horarioSabado;
    private  String horarioDomingoFeriado;



    public Itinerario(){

        this.setNumeroLinhas(numeroLinhas);

        this.setSentido(sentido);

        this.setNomeDaRua(nomeDaRua);

        this.setRuas(ruas);
        this.setHorarioSemanal(horarioSemanal);
        this.setHorarioSabado(horarioSabado);
        this.setHorarioDomingoFeriado(horarioDomingoFeriado);




    };

    public Itinerario(String numeroLinhas,String sentido,String nomeDaRua,String ruas,String horarioSemanal,
                      String horarioSabado, String horatioDomingoFeriado){
        this.numeroLinhas = numeroLinhas;
        this.sentido = sentido;
        this.nomeDaRua = nomeDaRua;
        this.ruas = ruas;
        this.horarioSemanal = horarioSemanal;
        this.horarioSabado  = horarioSabado;
        this.horarioDomingoFeriado = horatioDomingoFeriado;
    }





    public void setNumeroLinhas(String numeroLinhas) {
        this.numeroLinhas = numeroLinhas;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    public void setNomeDaRua(String nomeDaRua) {
        this.nomeDaRua = nomeDaRua;
    }

    public  void  setRuas(String ruas) {this.ruas = ruas;}


    public void setHorarioSemanal(String horarioSemanal) {
        this.horarioSemanal = horarioSemanal;
    }

    public void setHorarioSabado(String horarioSabado) {
        this.horarioSabado = horarioSabado;
    }

    public void setHorarioDomingoFeriado(String horatioDomingoFeriado) {
        this.horarioDomingoFeriado = horatioDomingoFeriado;
    }

    public String getNumeroLinhas() {
        return numeroLinhas;
    }

    public String getSentido() {
        return sentido;
    }

    public String getNomeDaRua() {
        return nomeDaRua;
    }


    public String getRuas() {
        return ruas;
    }

    public String getHorarioSemanal() {
        return horarioSemanal;
    }

    public String getHorarioSabado() {
        return horarioSabado;
    }

    public String getHorarioDomingoFeriado() {
        return horarioDomingoFeriado;
    }
}

