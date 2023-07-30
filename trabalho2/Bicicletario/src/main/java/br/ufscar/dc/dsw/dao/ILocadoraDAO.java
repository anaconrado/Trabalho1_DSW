package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.dsw.domain.Locadora;

@SuppressWarnings("unchecked")
public interface ILocadoraDAO extends CrudRepository<Locadora, Long>{
	Locadora findById(long id);
    //Locadora findByCNPJ (String CNPJ);
	List<Locadora> findAll();
	Locadora save(Locadora locadora);
	void deleteById(Long id);

	@Query("SELECT locadora FROM Locadora locadora WHERE locadora.cnpj = :cnpj")
	Locadora findByCNPJ(@Param ("cnpj") String cnpj);

	/*@Query("SELECT l FROM Locadora WHERE l.CNPJ = :CNPJ")
	Locadora findByEmail(@Param ("email") String email);*/
}