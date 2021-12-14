package com.transporte.av2.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Cliente {

    @Id
    public String rg;
    public String nome;
    public String reserva;
    public int idade;
    public String formaPagamento;


    @ManyToOne
    public Transporte transporte;
 
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getReserva() {
        return reserva;
    }
    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    public Transporte getTransporte() {
        return transporte;
    }
    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }
    public String VerificarReserva(String rg, String nome, String reserva, int idade, String formaPagamento) {
        this.rg = rg;
        this.nome = nome;
        this.reserva = reserva;
        this.idade = idade;
        this.formaPagamento = formaPagamento;

        String verificarRerserva;

        if (reserva == "Sim") { 
			verificarRerserva =  "Possui Reserva!";
		} else {
			verificarRerserva = "Não possui Reserva!";
		}
		return "RG:" + rg + "\n" + "Nome:" + nome + "\n" + "Idade:" + idade + "\n" + "Pagamento:" + formaPagamento + "\n" +"Reserva: " + verificarRerserva;
    }


}