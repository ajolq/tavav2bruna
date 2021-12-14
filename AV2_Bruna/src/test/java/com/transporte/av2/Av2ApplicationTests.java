package com.transporte.av2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.transporte.av2.models.Transporte;
import com.transporte.av2.repository.TransporteRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class Av2ApplicationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

	@Autowired
	public TransporteRepository repository;

	Transporte transporte;

	@BeforeAll
    public void iniciar() {
        this.transporte = new Transporte();
        transporte.setOrigem("uberlandia");
        transporte.setDestino("rio de janeiro");
    }

    @Test
    public void CadastrarTransporte() {

        Transporte form = new Transporte();
        form.setOrigem("rio de janeiro");
        form.setDestino("sao paulo");

        HttpEntity<Transporte> httpEntity = new HttpEntity<>(form);

        ResponseEntity<Transporte> response = this.testRestTemplate
            .exchange("/transportes", HttpMethod.POST, httpEntity, Transporte.class);
    
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getDestino(), "sao paulo");
    }

	@Test
    public void buscarTodoTransportes() {

        ResponseEntity<Transporte[]> response = this.testRestTemplate
        .exchange("/transportes", HttpMethod.GET, null, Transporte[].class);
    
        assertEquals(response.getClass(), HttpStatus.OK);
    }

    @Test
    public void buscarTransporteById() {

        ResponseEntity<Transporte> response = this.testRestTemplate
        .exchange("/transportes" + repository.findById(0), HttpMethod.GET, null, Transporte.class);
    
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getDestino(), "rio de janeiro");
    }

    @Test
    public void removerTransporte() {

        ResponseEntity<Void> response = this.testRestTemplate
        .exchange("/transportes" + repository.findById(0), HttpMethod.DELETE, null, Void.class);
    
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}

