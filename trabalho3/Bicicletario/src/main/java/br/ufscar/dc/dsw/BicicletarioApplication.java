package br.ufscar.dc.dsw;
//The declared package "" does not match the expected package "br.ufscar.dc.dsw"	BicicletarioApplication.java	/Bicicletario/src/main/java/br/ufscar/dc/dsw	line 1	Java Problem


import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.dao.ILocadoraDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.dao.ILocacaoDAO;
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
	public CommandLineRunner demo(IUsuarioDAO UsuarioDao, IClienteDAO ClienteDao, ILocadoraDAO LocadoraDao, ILocacaoDAO LocacaoDao, BCryptPasswordEncoder encoder) {
		return (args) -> {
						
			Usuario u1 = new Usuario();
			u1.setEmail("admin@hotmail.com");
			u1.setNome("Admin");
			u1.setPassword(encoder.encode("admin"));
			u1.setRole("ROLE_ADMIN");
			UsuarioDao.save(u1);	

			Cliente c1 = new Cliente();
			c1.setEmail("maria@hotmail.com");
			c1.setNome("Maria");
			c1.setPassword(encoder.encode("cliente1"));
			c1.setRole("ROLE_CLIENTE");
			c1.setCpf("468.325.873-40");
			c1.setTelefone("(16)99423-5549");
			c1.setGenero("F");
			c1.setDataNasc("01/01/2001");
			ClienteDao.save(c1);

			Cliente c2 = new Cliente();
			c2.setEmail("joao@gmail.com");
			c2.setNome("João");
			c2.setPassword(encoder.encode("cliente2"));
			c2.setRole("ROLE_CLIENTE");
			c2.setCpf("582.301.476-80");
			c2.setTelefone("(11)95555-8888");
			c2.setGenero("M");
			c2.setDataNasc("15/08/1995");
			ClienteDao.save(c2);

			Cliente c3 = new Cliente();
			c3.setEmail("carlos@yahoo.com");
			c3.setNome("Carlos");
			c3.setPassword(encoder.encode("cliente3"));
			c3.setRole("ROLE_CLIENTE");
			c3.setCpf("987.654.321-00");
			c3.setTelefone("(21)3333-9999");
			c3.setGenero("M");
			c3.setDataNasc("30/04/1988");
			ClienteDao.save(c3);

			Cliente c4 = new Cliente();
			c4.setEmail("ana@gmail.com");
			c4.setNome("Ana");
			c4.setPassword(encoder.encode("cliente4"));
			c4.setRole("ROLE_CLIENTE");
			c4.setCpf("123.456.789-10");
			c4.setTelefone("(31)7777-2222");
			c4.setGenero("F");
			c4.setDataNasc("12/11/1990");
			ClienteDao.save(c4);

			Cliente c5 = new Cliente();
			c5.setEmail("pedro@hotmail.com");
			c5.setNome("Pedro");
			c5.setPassword(encoder.encode("cliente5"));
			c5.setRole("ROLE_CLIENTE");
			c5.setCpf("654.321.987-12");
			c5.setTelefone("(47)8888-5555");
			c5.setGenero("M");
			c5.setDataNasc("25/06/1985");
			ClienteDao.save(c5);
			
			Locadora l1 = new Locadora();
			l1.setEmail("locadora1@hotmail.com");
			l1.setNome("Locadora 1");
			l1.setPassword(encoder.encode("locadora1"));
			l1.setRole("ROLE_LOCADORA");
			l1.setCnpj("12.345.678/0001-90");
			l1.setCidade("São Carlos");
			LocadoraDao.save(l1);

			Locadora l2 = new Locadora();
			l2.setEmail("locadora2@gmail.com");
			l2.setNome("Locadora 2");
			l2.setPassword(encoder.encode("locadora2"));
			l2.setRole("ROLE_LOCADORA");
			l2.setCnpj("98.765.432/0001-21");
			l2.setCidade("Ribeirão Preto");
			LocadoraDao.save(l2);

			Locadora l3 = new Locadora();
			l3.setEmail("locadora3@outlook.com");
			l3.setNome("Locadora 3");
			l3.setPassword(encoder.encode("locadora3"));
			l3.setRole("ROLE_LOCADORA");
			l3.setCnpj("75.432.109/0001-67");
			l3.setCidade("Campinas");
			LocadoraDao.save(l3);

			Locadora l4 = new Locadora();
			l4.setEmail("locadora4@yahoo.com");
			l4.setNome("Locadora 4");
			l4.setPassword(encoder.encode("locadora4"));
			l4.setRole("ROLE_LOCADORA");
			l4.setCnpj("23.876.543/0001-43");
			l4.setCidade("São Paulo");
			LocadoraDao.save(l4);

			Locacao lo1 = new Locacao();
			lo1.setData("30/07/2023 15:00");
			lo1.setValor(BigDecimal.valueOf(54.9));
			lo1.setCliente(c1);
			lo1.setLocadora(l1);
			LocacaoDao.save(lo1);
			
			Locacao lo2 = new Locacao();
			lo2.setData("22/01/2022 12:00");
			lo2.setValor(BigDecimal.valueOf(66.6));
			lo2.setCliente(c1);
			lo2.setLocadora(l2);
			LocacaoDao.save(lo2);

			Locacao lo3 = new Locacao();
			lo3.setData("12/11/2021");
			lo3.setValor(BigDecimal.valueOf(15.8));
			lo3.setCliente(c1);
			lo3.setLocadora(l3);
			LocacaoDao.save(lo3);
		};
	}
}