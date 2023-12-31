package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.dto.LocacaoDTO;

public interface ILocacaoService {

	List<Locacao> buscarTodos();
	
	Locacao buscarPorId(Long id);
	
	List<Locacao> buscarTodosPorCliente(Long id);

	List<Locacao> buscarTodosPorLocadora(Long id);
	
	//DTOs
	public List<LocacaoDTO> buscarTodosDTO();

	LocacaoDTO buscarPorIdDTO(Long id);

	List<LocacaoDTO> buscarTodosPorClienteDTO(Long id);

	List<LocacaoDTO> buscarTodosPorLocadoraDTO(Long id);
	
    List<Locacao> buscarLocacoesPorClienteELocadoraEData(Long clienteId, Long locadoraId, String data);
	
	void salvar(Locacao locacao);
	
    void excluir(Long id);
}
