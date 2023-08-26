package br.ufscar.dc.dsw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;

@RestController
public class LocacaoRestController {

	@Autowired
	private ILocacaoService service;

    @GetMapping(path = "/locacoes")
	public ResponseEntity<List<Locacao>> lista() {
		List<Locacao> lista = service.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
    @GetMapping(path = "/locacoes/{id}")
	public ResponseEntity<Locacao> listaPorId(@PathVariable("id") long id) {
		Locacao locacao = service.buscarPorId(id);
		if (locacao == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(locacao);
	}

	@GetMapping(path = "/locacoes/clientes/{id}")
	public ResponseEntity<List<Locacao>> listaPorCliente(@PathVariable("id") long id) {
		List<Locacao> listaClientes = service.buscarTodosPorCliente(id);
		if (listaClientes.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(listaClientes);
	}

    @GetMapping(path = "/locacoes/locadoras/{id}")
	public ResponseEntity<List<Locacao>> listaPorLocadora(@PathVariable("id") long id) {
		List<Locacao> listaLocadoras = service.buscarTodosPorLocadora(id);
		if (listaLocadoras.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(listaLocadoras);
	}
}