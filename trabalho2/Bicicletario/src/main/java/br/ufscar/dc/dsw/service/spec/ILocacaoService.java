package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Locacao;

public interface ILocacaoService {

	Locacao buscarPorId(Long id);

	List<Locacao> buscarTodosPorCliente(Long id);

	List<Locacao> buscarTodosPorLocadora(Long id);
	
	void salvar(Locacao locacao);
}
