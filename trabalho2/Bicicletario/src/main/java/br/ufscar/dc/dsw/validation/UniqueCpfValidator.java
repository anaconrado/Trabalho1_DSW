package br.ufscar.dc.dsw.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.domain.Cliente;

@Component
public class UniqueCpfValidator implements ConstraintValidator<UniqueCpf, String> {

	@Autowired
	private IClienteDAO dao;

	@Override
	public boolean isValid(String CPF, ConstraintValidatorContext context) {
		if (dao != null) {
			Cliente cliente = dao.findByCPF(CPF);
			return cliente == null;
		} else {
            // Não necessidade de validação
			// Durante a execução da classe LivrariaMvcApplication
			// não há injeção de dependência. 
			return true;
		}
	}
}