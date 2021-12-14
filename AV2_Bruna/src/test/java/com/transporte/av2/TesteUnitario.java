package com.transporte.av2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.transporte.av2.models.Cliente;

import org.junit.jupiter.api.Test;

public class TesteUnitario {

    
    @Test
    void VerificarPlano() {
        //Arrange
        Cliente Cliente = new Cliente();
        
        String rg = "123456789";
        String nome = "Eduardo";
        int idade = 30;
        String reserva = "Sim";
        String verificarRerserva = "Possui Reserva!";
        String formaPagamento =  "Crédito";
        
        
        String esperado = "RG:" + rg + "\n" + "Nome:" + nome + "\n" + "Idade:" + idade + "\n" + "Pagamento:" + formaPagamento + "\n" +"Reserva: " + verificarRerserva;
                                
        //Act
        String resultado = Cliente.VerificarReserva(rg, nome, reserva, idade, formaPagamento);
        
        //Assert
        assertEquals(esperado,resultado);
    }

    
}
