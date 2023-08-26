package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Locacao;

public interface ILocacaoService {

	Locacao buscarPorId(Long id);

	List<Locacao> buscarTodosPorCliente(Long id);

	List<Locacao> buscarTodosPorLocadora(Long id);
	
    List<Locacao> buscarLocacoesPorClienteELocadoraEData(Long clienteId, Long locadoraId, String data);
	
	void salvar(Locacao locacao);
	
    void excluir(Long id);
}
