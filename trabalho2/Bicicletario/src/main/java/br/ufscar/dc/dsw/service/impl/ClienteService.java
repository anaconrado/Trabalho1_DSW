package br.ufscar.dc.dsw.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.dao.ILocacaoDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.service.spec.IClienteService;
import java.util.Optional;

@Service
@Transactional(readOnly = false)
public class ClienteService implements IClienteService {

	@Autowired
	IClienteDAO dao;
	@Autowired
	ILocacaoDAO locacaoDao;

	public void salvar(Cliente cliente) {
		dao.save(cliente);
	}

	public void excluir(Long id) {
        Optional<Cliente> optionalCliente = dao.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            List<Locacao> locacoes = cliente.getLocacoes();
            for (Locacao locacao : locacoes) {
                locacao.setCliente(null); 
                locacaoDao.save(locacao); 
            }
            dao.delete(cliente);
		}
	}

	/*
	public void excluir(Long id) {
		dao.deleteById(id);
	}
	*/
	@Transactional(readOnly = true)
	public Cliente buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}
	
	@Transactional(readOnly = true)
	public List<Cliente> buscarTodos() {
		return dao.findAll();
	}    

	@Transactional(readOnly = true)
	public Cliente buscarPorEmail(String email){
		return dao.findByEmail(email);
	}
}