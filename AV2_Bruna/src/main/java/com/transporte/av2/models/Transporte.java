package com.transporte.av2.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Transporte implements Serializable{

    @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    public long id; //id do onibus

    public String opcoes;    
    public String origem;
    public String destino;
    public String dataIda;
    public String dataVolta;
    public String capacidade;
    public float valor;


    @OneToMany
	public List<Cliente> clientes;


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getCapacidade() {
        return capacidade;
    }


    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }


    public String getOpcoes() {
        return opcoes;
    }


    public void setOpcoes(String opcoes) {
        this.opcoes = opcoes;
    }


    public String getOrigem() {
        return origem;
    }


    public void setOrigem(String origem) {
        this.origem = origem;
    }


    public String getDestino() {
        return destino;
    }


    public void setDestino(String destino) {
        this.destino = destino;
    }


    public String getDataIda() {
        return dataIda;
    }


    public void setDataIda(String dataIda) {
        this.dataIda = dataIda;
    }


    public String getDataVolta() {
        return dataVolta;
    }


    public void setDataVolta(String dataVolta) {
        this.dataVolta = dataVolta;
    }


    public float getValor() {
        return valor;
    }


    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
