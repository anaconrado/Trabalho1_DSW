package br.ufscar.dc.dsw.service.spec;
import java.util.List;
import br.ufscar.dc.dsw.domain.Locadora;

public interface ILocadoraService {
    void salvar(Locadora locadora);
    void excluir(Long id);
	Locadora buscarPorId(Long id);
	List<Locadora> buscarTodos();
    Locadora buscarPorEmail(String email);
}