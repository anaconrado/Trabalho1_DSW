package br.ufscar.dc.dsw.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ufscar.dc.dsw.dao.ILocadoraDAO;
import br.ufscar.dc.dsw.dao.ILocacaoDAO;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;
import java.util.Optional;


@Service
@Transactional(readOnly = false)
public class LocadoraService implements ILocadoraService {

	@Autowired
	ILocadoraDAO dao;
	@Autowired
	ILocacaoDAO locacaoDao;
	
	public void salvar(Locadora locadora) {
		dao.save(locadora);
	}
	
	public void excluir(Long id) {
        Optional<Locadora> optionalLocadora = dao.findById(id);
        if (optionalLocadora.isPresent()) {
            Locadora locadora = optionalLocadora.get();
            List<Locacao> locacoes = locadora.getLocacoes();
            for (Locacao locacao : locacoes) {
                locacao.setLocadora(null); 
                locacaoDao.save(locacao); 
            }
            dao.delete(locadora);
		}
	}
	/*
	public void excluir(Long id) {
		dao.deleteById(id);
	}
	*/
	@Transactional(readOnly = true)
	public Locadora buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}
	
	@Transactional(readOnly = true)
	public List<Locadora> buscarTodos() {
		return dao.findAll();
	}    
}