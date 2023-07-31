package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.ILocacaoDAO;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;

@Service
@Transactional(readOnly = false)
public class LocacaoService implements ILocacaoService {

	@Autowired
	ILocacaoDAO dao;
	
	public void salvar(Locacao locacao) {
		dao.save(locacao);
	}
	
	public void excluir(Long id) {
		dao.deleteById(id);
	}
	
	@Transactional(readOnly = true)
    public List<Locacao> buscarLocacoesPorClienteELocadoraEData(Long clienteId, Long locadoraId, String data) {
        return dao.buscarLocacoesPorClienteELocadoraEData(clienteId.longValue(), locadoraId.longValue(), data);
    }


	@Transactional(readOnly = true)
	public Locacao buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Locacao> buscarTodosPorCliente(Long id) {
		return dao.findAllByCliente(id);
	}

	@Transactional(readOnly = true)
	public List<Locacao> buscarTodosPorLocadora(Long id) {
		return dao.findAllByLocadora(id);
	}

}