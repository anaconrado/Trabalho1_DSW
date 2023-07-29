package br.ufscar.dc.dsw;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.dao.ILocadoraDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Locacao;



@SpringBootApplication
public class BicicletarioApplication {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(BicicletarioApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO UsuarioDao, IClienteDAO ClienteDao, ILocadoraDAO LocadoraDao, BCryptPasswordEncoder encoder) {
		return (args) -> {
			
			Cliente c1 = new Cliente();
			c1.setEmail("cliente1@hotmail.com");
			c1.setNome("Cliente 1");
			c1.setPassword(encoder.encode("cliente1"));
			c1.setRole("ROLE_CLIENTE");
			c1.setCpf("0000");
			c1.setTelefone("nao tem");
			c1.setGenero("feminino");
			c1.setDataNasc("01/01/2001");
			ClienteDao.save(c1);

			Cliente c2 = new Cliente();
			c2.setEmail("cliente2@hotmail.com");
			c2.setNome("Cliente 2");
			c2.setPassword(encoder.encode("cliente2"));
			c2.setRole("ROLE_CLIENTE");
			c2.setCpf("2222");
			c2.setTelefone("nao tem");
			c2.setGenero("masculino");
			c2.setDataNasc("01/01/2001");
			ClienteDao.save(c2);
			
			Usuario u2 = new Usuario();
			u2.setEmail("admin@hotmail.com");
			u2.setNome("Admin");
			u2.setPassword(encoder.encode("admin"));
			u2.setRole("ROLE_ADMIN");
			UsuarioDao.save(u2);	
			
			Locadora l1 = new Locadora();
			l1.setEmail("locadora1@hotmail.com");
			l1.setNome("Locadora 1");
			l1.setPassword(encoder.encode("locadora1"));
			l1.setRole("ROLE_LOCADORA");
			l1.setCnpj("1111");
			l1.setCidade("São Carlos");
			LocadoraDao.save(l1);

			Locadora l2 = new Locadora();
			l2.setEmail("locadora2@hotmail.com");
			l2.setNome("Locadora 2");
			l2.setPassword(encoder.encode("locadora2"));
			l2.setRole("ROLE_LOCADORA");
			l2.setCnpj("3333");
			l2.setCidade("São Carlos");
			LocadoraDao.save(l2);

			Locacao lo1 = new Locacao();
			lo1.setData("30/01/2022");
			lo1.setValor(BigDecimal.valueOf(54.9));
			lo1.setCliente(c1);
			lo1.setLocadora(l1);
		};
	}
}