package com.transporte.av2.controllers;

import com.transporte.av2.models.Cliente;
import com.transporte.av2.models.Transporte;
import com.transporte.av2.repository.ClienteRepository;
import com.transporte.av2.repository.TransporteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransporteController {

    @Autowired
    private TransporteRepository tr;

    @Autowired
    private ClienteRepository cr;

    @RequestMapping(value="/cadastrarTransporte", method=RequestMethod.GET)
    public String form(){
        return "transporte/formTransporte";
    }

    @RequestMapping(value="/cadastrarTransporte", method=RequestMethod.POST)
    public String form(Transporte transporte){
        tr.save(transporte);
        return "redirect:/cadastrarTransporte";
    }

    @RequestMapping("/transportes")
    public ModelAndView listaTransportes(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Transporte> transportes = tr.findAll();
        mv.addObject("transportes", transportes);
        return mv;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ModelAndView detalhesTransporte(@PathVariable("id") long id){
        Transporte transporte = tr.findById(id);
        ModelAndView mv = new ModelAndView("detalhesTransporte");
        mv.addObject("transporte", transporte);

        Iterable<Cliente> clientes = cr.findByTransporte(transporte);
        mv.addObject("clientes", clientes);

        return mv;
    }

    @RequestMapping("/deletarTransporte")
	public String deletarTransporte(long id){
		Transporte transporte = tr.findById(id);
		tr.delete(transporte);
		return "redirect:/transportes";
	}

    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public String detalhesTransportePost(@PathVariable("id") long id, Cliente cliente){

        Transporte transporte = tr.findById(id);
		cliente.setTransporte(transporte);
		cr.save(cliente);
		return "redirect:/{id}";
    }

    @RequestMapping("/deletarCliente")
	public String deletarCliente(String rg){
		Cliente cliente = cr.findByRg(rg);
		cr.delete(cliente);
		
		Transporte transporte = cliente.getTransporte();
		long idLong = transporte.getId();
		String id = "" + idLong;
		return "redirect:/" + id;
	}
}
