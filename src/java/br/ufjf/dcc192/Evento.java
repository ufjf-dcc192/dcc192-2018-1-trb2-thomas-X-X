package br.ufjf.dcc192;

import java.util.Date;
import java.util.List;

public class Evento {
    String  titulo;
    int codigo;
    double minimo;
    Date data, sorteio;
    boolean sorteado = false;

    public boolean isSorteado() {
        return sorteado;
    }

    public void setSorteado(boolean sorteado) {
        this.sorteado = true;
    }
    List<Participante> participantes;

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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
