package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

//import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;

//33074212

@RestController
public class LocadoraRestController {

    @Autowired
	private ILocadoraService service;

	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
	}
	
	private void parse(Locadora loc, JSONObject json) {

		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				loc.setId(((Integer) id).longValue());
			} else {
				loc.setId(((Long) id));
			}
		}
		
		loc.setEmail((String) json.get("email"));
		loc.setNome((String) json.get("nome"));
		loc.setPassword((String) json.get("password"));
        loc.setRole((String) json.get("role"));
        loc.setCnpj((String) json.get("cnpj"));
        loc.setCidade((String) json.get("cidade"));
        loc.setLocacoes((List<Locacao>) json.get("locacoes"));		
	}

    //Está listando todas as locadoras
	@GetMapping(path = "/locadoras")
	public ResponseEntity<List<Locadora>> lista() {
		List<Locadora> lista = service.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

    @GetMapping(path = "/locadoras/cidades/{nome}")
	public ResponseEntity<List<Locadora>> listaLocCidades(@PathVariable("nome") String nome) {
		List<Locadora> lista = service.buscarPorCidade(nome);
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
    //Retorna uma locadora por ID
	@GetMapping(path = "/locadoras/{id}")
	public ResponseEntity<Locadora> lista(@PathVariable("id") long id) {
	    Locadora loc = service.buscarPorId(id);
		if (loc == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(loc);
	}
    
    //Cadastra uma nova locadora
	@PostMapping(path = "/locadoras")
	//@ResponseBody
	public ResponseEntity<Locadora> cria(@RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Locadora loc = new Locadora(); 
				parse(loc, json);
				service.salvar(loc);
				return ResponseEntity.ok(loc);
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); 
		}
	}
    

    //Atualiza locadora por ID
	@PutMapping(path = "/locadoras/{id}")
	public ResponseEntity<Locadora> atualiza(@PathVariable("id") long id, @RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
			    Locadora loc = service.buscarPorId(id);
				if (loc == null) {
					return ResponseEntity.notFound().build();
				} else {
					parse(loc, json);
					service.salvar(loc);
					return ResponseEntity.ok(loc);
				}
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); 
		}
	}
    
    //Remove uma Locadora por ID
	@DeleteMapping(path = "/locadoras/{id}")
	public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {

		Locadora loc = service.buscarPorId(id);
		if (loc == null) {
			return ResponseEntity.notFound().build();
		} else {
			service.excluir(id);
			return ResponseEntity.noContent().build();
	    }
	}
}
