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
import br.ufscar.dc.dsw.dto.LocacaoDTO;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;

@RestController
public class LocacaoRestController {

	@Autowired
	private ILocacaoService service;

    @GetMapping(path = "/locacoes")
	public ResponseEntity<List<LocacaoDTO>> lista() {
		List<LocacaoDTO> lista = service.buscarTodosDTO();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
    @GetMapping(path = "/locacoes/{id}")
	public ResponseEntity<LocacaoDTO> listaPorId(@PathVariable("id") long id) {
    	LocacaoDTO locacao = service.buscarPorIdDTO(id);
		if (locacao == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(locacao);
	}

	@GetMapping(path = "/locacoes/clientes/{id}")
	public ResponseEntity<List<LocacaoDTO>> listaPorCliente(@PathVariable("id") long id) {
		List<LocacaoDTO> listaClientes = service.buscarTodosPorClienteDTO(id);
		if (listaClientes.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(listaClientes);
	}

    @GetMapping(path = "/locacoes/locadoras/{id}")
	public ResponseEntity<List<LocacaoDTO>> listaPorLocadora(@PathVariable("id") long id) {
		List<LocacaoDTO> listaLocadoras = service.buscarTodosPorLocadoraDTO(id);
		if (listaLocadoras.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(listaLocadoras);
	}
}