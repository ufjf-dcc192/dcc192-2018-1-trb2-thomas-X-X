package br.ufjf.dcc192;

import java.util.Date;

public class Evento {
    String codigo, titulo;
    double minimo;
    Date data, sorteio;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getMinimo() {
        return minimo;
    }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getSorteio() {
        return sorteio;
    }

    public void setSorteio(Date sorteio) {
        this.sorteio = sorteio;
    }
    
    public void sorteia(){
       
    }
}