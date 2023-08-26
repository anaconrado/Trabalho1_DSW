package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;


import br.ufscar.dc.dsw.domain.Locacao;

@SuppressWarnings("unchecked")
public interface ILocacaoDAO extends CrudRepository<Locacao, Long>{

	List<Locacao> findAll();

	Locacao findById(long id);

	@Query("SELECT locacao FROM Locacao locacao WHERE locacao.cliente.id = ?1")
    List<Locacao> findAllByCliente(Long clienteId);

	@Query("SELECT locacao FROM Locacao locacao WHERE locacao.locadora.id = ?1")
    List<Locacao> findAllByLocadora(Long locadoraId);
	
	Locacao save(Locacao locacao);
	
	void deleteById(Long id);

	@Query("SELECT locacao FROM Locacao locacao WHERE (locacao.locadora.id = ?1 OR locacao.cliente.id = ?2) AND (locacao.data = ?3) ")
	List<Locacao> buscarLocacoesPorClienteELocadoraEData(Long locadora, Long cliente, String data);
}